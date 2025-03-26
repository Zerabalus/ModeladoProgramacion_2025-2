import numpy as np
from PIL import Image

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
        for x in range(self.ancho):
            for y in range(self.alto):
                z = self._pixel_a_complejo(x, y)
                color = self._obtener_color(z)
                imagen[y, x] = color
        return imagen

    def _pixel_a_complejo(self, x, y):
        real = self.min_complejo.real + (x / self.ancho) * (self.max_complejo.real - self.min_complejo.real)
        imag = self.min_complejo.imag + (y / self.alto) * (self.max_complejo.imag - self.min_complejo.imag)
        return complex(real, imag)

    def _obtener_color(self, z):
        for i in range(self.iteraciones):
            z = self.polinomio.evaluar(z)
            if abs(z) > self.umbral:
                factor = i / self.iteraciones
                return tuple(int(c * factor) for c in self.color_base)
        return (0, 0, 0)  # Negro si converge