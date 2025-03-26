import numpy as np
from src.polinomioComplejo import polinomioComplejo
from src.generadorFractal import GeneradorFractal

def test_generador_fractal():
    polinomio = polinomioComplejo([1 + 0j, -1 + 0j])  # x - 1
    generador = GeneradorFractal(
        ancho=100,
        alto=100,
        polinomio=polinomio,
        min_complejo=-2-2j,
        max_complejo=2+2j,
        iteraciones=10,
        umbral=2,
        color_base=(255, 100, 50)
    )
    imagen = generador.generar()
    assert isinstance(imagen, np.ndarray)
    assert imagen.shape == (100, 100, 3)