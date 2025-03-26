import numpy as np
from PIL import Image
import colorsys

class GeneradorFractal:
    def __init__(self, ancho, alto, polinomio, min_complejo, max_complejo, iteraciones, umbral, color_base):
        self.ancho = ancho
        self.alto = alto
        self.polinomio = polinomio
        self.min_complejo = complex(min_complejo)
        self.max_complejo = complex(max_complejo)
        self.iteraciones = iteraciones
        self.umbral = umbral
        self.color_base = color_base

    def generar(self):
        imagen = np.zeros((self.alto, self.ancho, 3), dtype=np.uint8)
        
        # Pre-calcular el logaritmo para mejor distribución de colores
        log_iter = np.log(self.iteraciones)
        
        for x in range(self.ancho):
            for y in range(self.alto):
                z = self._pixel_a_complejo(x, y)
                escape_time = self._calcular_tiempo_escape(z)
                
                if escape_time < self.iteraciones:
                    # Mejor mapeo de color con ajuste de brillo
                    normalized = escape_time / self.iteraciones
                    log_scale = np.log(escape_time + 1) / log_iter
                    
                    # Ajuste de saturación y brillo
                    h = (self.color_base[0]/255, self.color_base[1]/255, self.color_base[2]/255)
                    r, g, b = colorsys.hsv_to_rgb(h[0], h[1], min(1.0, log_scale * 1.5))
                    
                    # Aplicar gamma correction
                    gamma = 0.8
                    r = int(255 * (r ** gamma))
                    g = int(255 * (g ** gamma))
                    b = int(255 * (b ** gamma))
                    
                    imagen[y, x] = (r, g, b)
                else:
                    imagen[y, x] = (0, 0, 0)  # Negro para puntos que convergen
        
        return imagen

    def _pixel_a_complejo(self, x, y):
        real = self.min_complejo.real + (x / self.ancho) * (self.max_complejo.real - self.min_complejo.real)
        imag = self.min_complejo.imag + (y / self.alto) * (self.max_complejo.imag - self.min_complejo.imag)
        return complex(real, imag)

    def _calcular_tiempo_escape(self, z):
        for i in range(self.iteraciones):
            z = self.polinomio.evaluar(z)
            if abs(z) > self.umbral:
                return i
        return self.iteraciones