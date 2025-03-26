from archivoEntrada import archivoEntrada
from polinomioComplejo import polinomioComplejo
from generadorFractal import GeneradorFractal
from imagenGenerada import imagenGenerada
import re

def parse_polynomial(poly_str, degree):
    # Diccionario para coeficientes por grado
    coef_dict = {i: complex(0) for i in range(degree+1)}
    
    # Dividir en términos
    terms = re.findall(r'([+-]?\([^)]+\)x\^\d+|[+-]?\([^)]+\))', poly_str.replace(' ', ''))
    
    for term in terms:
        # Manejar signo
        sign = -1 if term.startswith('-') else 1
        term = term.lstrip('+-')
        
        # Extraer coeficiente y grado
        if 'x^' in term:
            coef_part, exp_part = term.split('x^')
            exp = int(exp_part)
            coef = complex(coef_part.strip('()').replace('i', 'j'))
        else:
            coef = complex(term.strip('()').replace('i', 'j'))
            exp = 0
            
        coef_dict[exp] = coef * sign
    
    # Ordenar coeficientes de mayor a menor grado
    return [coef_dict[i] for i in sorted(coef_dict.keys(), reverse=True)]

def main():
    parametros = archivoEntrada.parsear_archivo("input/input.txt")
    
    # Parsear el polinomio
    degree = parametros['degree']
    poly_str = parametros['polynomial']
    coeficientes = parse_polynomial(poly_str, degree)
    
    # Crear polinomio
    polinomio = polinomioComplejo(coeficientes)
    
    # Generar fractal
    generador = GeneradorFractal(
        ancho=parametros['width'],
        alto=parametros['height'],
        polinomio=polinomio,
        min_complejo=parametros['min'],
        max_complejo=parametros['max'],
        iteraciones=parametros['iterations'],
        umbral=parametros['threshold'],
        color_base=parametros['color']
    )
    fractal_imagen = generador.generar()
    
    # Guardar imagen
    imagenGenerada.guardar_imagen(fractal_imagen, f"output/{parametros['nombre']}")

if __name__ == "__main__":
    main()