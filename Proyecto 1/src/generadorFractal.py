from PIL import Image

class generadorFractal:
    
    """
    Generador de fractales

    Módulo que tiene la clase que crea imágenes fractales evaluando un polinomio complejo en cada punto del plano.
    El color de cada píxel se determina según el tiempo de escape (iteraciones necesarias para diverger),
    aplicando un gradiente de color blanco (255,255,255) según la divergencia.

    Métodos:
        generar(): Genera la imagen fractal como una matriz
        _pixel_a_complejo(x, y): Convierte coordenadas de píxel a un número complejo
        _calcular_tiempo_escape(z): Calcula las iteraciones hasta que el punto diverja
    """

    def __init__(self, ancho, alto, polinomio, min_complejo, max_complejo, iteraciones, umbral, **kwargs):
        
        if ancho <= 0 or alto <= 0:
            raise ValueError("Ancho y alto deben ser mayores que 0")
        if iteraciones <= 0:
            raise ValueError("Iteraciones debe ser mayor que 0")
        
        """
        Inicializa el generador de fractales con los parámetros dados.

        Args:
            ancho (int): Ancho de la imagen en píxeles
            alto (int): Alto de la imagen en píxeles
            polinomio (objeto): Polinomio complejo con método evaluar(z)
            min_complejo (str/complex): Límite inferior del plano
            max_complejo (str/complex): Límite superior del plano
            iteraciones (int): Máximo de iteraciones por punto
            umbral (float): Radio de divergencia
            **kwargs:
                color_base (tuple): Color inicial por si no hay una especificación
                color (tuple): Alternativa a color_base
        """
        self.ancho = ancho
        self.alto = alto
        self.polinomio = polinomio
        self.min_complejo = complex(min_complejo)
        self.max_complejo = complex(max_complejo)
        self.iteraciones = iteraciones
        self.umbral = umbral
        self.color_base = kwargs.get('color_base', kwargs.get('color', (255, 0, 0)))

    def generar(self):
        """
        Genera la imagen fractal
        
        Returns:
            Los puntos convergentes (no divergen) quedan en negro [0,0,0]
            Los puntos divergentes tienen color según su velocidad de escape, (basado en el punto 4).
        """
        imagen = [[[0, 0, 0] for _ in range(self.ancho)] for _ in range(self.alto)]
        
        for x in range(self.ancho):
            for y in range(self.alto):
                z = self._pixel_a_complejo(x, y)
                escape_time = self._calcular_tiempo_escape(z)
                
                if escape_time < self.iteraciones:
                    # Controla el degradado
                    t = (escape_time / self.iteraciones) ** 0.4
                    # Calcula el gradiente 
                    imagen[y][x] = [
                        int(self.color_base[i] + (255 - self.color_base[i]) * t)
                        for i in range(3)
                    ]
        
        return imagen

    def _pixel_a_complejo(self, x, y):
        """
        Mapea coordenadas de píxel a coordenadas en el plano complejo.

        Args:
            x (int): Coordenada horizontal
            y (int): Coordenada vertical

        Returns:
            complex: Punto correspondiente en el plano complejo.
        """
        real = self.min_complejo.real + (x / self.ancho) * (self.max_complejo.real - self.min_complejo.real)
        imag = self.min_complejo.imag + (y / self.alto) * (self.max_complejo.imag - self.min_complejo.imag)
        return complex(real, imag)

    def _calcular_tiempo_escape(self, z):
        
        """
        Calcula iteraciones hasta que z diverja (|z| > umbral) o se alcance el límite

        Args:
            z (complex): Punto inicial en el plano complejo

        Returns:
            int: Iteraciones hasta que divergen o convergen
        """
        for i in range(self.iteraciones):
            z = self.polinomio.evaluar(z)
            if abs(z) > self.umbral:
                return i
        return self.iteraciones