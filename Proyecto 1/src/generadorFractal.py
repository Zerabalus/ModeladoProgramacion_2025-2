import numpy as np
from PIL import Image
import colorsys
import math

class GeneradorFractal:
    def __init__(self, ancho, alto, polinomio, min_complejo, max_complejo, iteraciones, umbral, **kwargs):
        self.ancho = ancho
        self.alto = alto
        self.polinomio = polinomio
        self.min_complejo = complex(min_complejo)
        self.max_complejo = complex(max_complejo)
        self.iteraciones = iteraciones
        self.umbral = umbral
        self.centro_x = ancho // 2
        self.centro_y = alto // 2
        self.radio_max = math.sqrt(self.centro_x**2 + self.centro_y**2)
        
        # Acepta cualquier parámetro adicional sin generar errores
        self.color_base = kwargs.get('color_base', None)  # No se usa realmente

    def generar(self):
        imagen = np.zeros((self.alto, self.ancho, 3), dtype=np.uint8)
        
        for x in range(self.ancho):
            for y in range(self.alto):
                z = self._pixel_a_complejo(x, y)
                escape_time = self._calcular_tiempo_escape(z)
                
                if escape_time < self.iteraciones:
                    # Cálculo de distancia normalizada al centro
                    dx, dy = x - self.centro_x, y - self.centro_y
                    distancia = math.sqrt(dx*dx + dy*dy) / self.radio_max
                    
                    # Factor de brillo (1 en centro, 0.3 en bordes)
                    brillo = 0.3 + 0.7 * (1 - distancia**0.7)
                    
                    # Rango azul (0.55) a morado (0.83)
                    hue = 0.55 + 0.28 * (escape_time / self.iteraciones)
                    
                    # Conversión a RGB con saturación máxima
                    r, g, b = colorsys.hsv_to_rgb(hue, 1.0, brillo)
                    
                    # Ajuste de canales para tonos fríos intensos
                    r, g, b = r*0.8, g*0.9, min(1.0, b*1.2)
                    
                    imagen[y, x] = (int(255*r), int(255*g), int(255*b))
                else:
                    imagen[y, x] = (0, 0, 0)  # Fondo negro
        
        return imagen

    def _pixel_a_complejo(self, x, y):
        real = self.min_complejo.real + (x/self.ancho) * (self.max_complejo.real - self.min_complejo.real)
        imag = self.min_complejo.imag + (y/self.alto) * (self.max_complejo.imag - self.min_complejo.imag)
        return complex(real, imag)

    def _calcular_tiempo_escape(self, z):
        for i in range(self.iteraciones):
            z = self.polinomio.evaluar(z)
            if abs(z) > self.umbral:
                return i
        return self.iteraciones