import os
from archivoEntrada import archivoEntrada
from polinomioComplejo import polinomioComplejo
from generadorFractal import GeneradorFractal
from imagenGenerada import imagenGenerada
import re
from datetime import datetime

def procesar_archivo_entrada(ruta_entrada, numero_archivo=None):
    try:
        parametros = archivoEntrada.parsear_archivo(ruta_entrada)
        
        # Parsear polynomial
        poly_str = parametros['polynomial'].replace(' ', '')
        
        # Determinar automáticamente el grado máximo
        grados = [int(m.group(1)) for m in re.finditer(r'x\^(\d+)', poly_str)]
        grado_max = max(grados) if grados else 0
        
        # Inicializar coeficientes con ceros
        coeficientes = [complex(0)] * (grado_max + 1)
        
        # Extraer todos los términos con sus exponentes
        terminos = re.findall(r'([+-]?\([^)]+\))(x\^(\d+))?', poly_str)
        
        for coef_term, _, exp in terminos:
            # Manejar signo
            sign = -1 if coef_term.startswith('-') else 1
            coef_term = coef_term.lstrip('+-')
            
            # Convertir coeficiente a complejo
            coef = complex(coef_term.strip('()').replace('i', 'j')) * sign
            
            # Determinar posición en la lista (orden descendente)
            pos = grado_max - (int(exp) if exp else 0)
            coeficientes[pos] = coef
        
        polinomio = polinomioComplejo(coeficientes)
        
        # Generar nombre único de salida
        nombre_base = os.path.splitext(os.path.basename(ruta_entrada))[0]
        nombre_salida = parametros.get('nombre', f'fractal_{nombre_base}.png')
        
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
        imagenGenerada.guardar_imagen(fractal_imagen, f"output/{nombre_salida}")
        
        print(f"✓ Archivo procesado: {ruta_entrada}")
        print(f"   Grado del polinomio: {grado_max}")
        print(f"   Coeficientes: {[str(c) for c in coeficientes]}")
        print(f"   Imagen generada: output/{nombre_salida}\n")
    
    except Exception as e:
        print(f"✗ Error procesando {ruta_entrada}: {str(e)}\n")

def main():
    # Crear directorios si no existen
    os.makedirs("input", exist_ok=True)
    os.makedirs("output", exist_ok=True)
    
    # Procesar archivos únicos sin duplicados
    archivos_procesados = set()
    for archivo in sorted(os.listdir("input")):
        if archivo.endswith(".txt") and archivo not in archivos_procesados:
            archivos_procesados.add(archivo)
            ruta_completa = os.path.join("input", archivo)
            procesar_archivo_entrada(ruta_completa)
    
    if not archivos_procesados:
        print("No se encontraron archivos .txt válidos en el directorio input/")
    else:
        print(f"\nProceso completado. Se generaron {len(archivos_procesados)} fractales.")

if __name__ == "__main__":
    main()