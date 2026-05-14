import os
from archivoEntrada import archivoEntrada
from polinomioComplejo import polinomioComplejo
from generadorFractal import generadorFractal
from imagenGenerada import imagenGenerada

def procesar_archivo_entrada(ruta_entrada, numero_archivo=None):
    
    """
    Módulo que tiene la clase que procesa un archivo de entrada para generar un fractal 
    basado en un polinomio complejo.

    Args:
        ruta_entrada (str): Ruta del archivo de configuración *.txt
        numero_archivo (int, optional): Número identificador para archivos, por defecto es none

    El archivo debe contener parámetros en formato clave=valor, incluyendo:
    - polynomial: Expresión del polinomio complejo
    - width/height: Dimensiones de la imagen
    - min/max: Límites del plano complejo
    - iterations: Máximo de iteraciones
    - threshold: Umbral de divergencia
    - color: Color base en formato RGB
    - nombre: Nombre para el archivo de salida

    Genera:
    - Imagen PNG en el directorio output/
    - Mensaje en la terminal con el resumen
    """
    try:
        parametros = archivoEntrada.analizar_archivo(ruta_entrada)
        
        # Analiza
        polinomio = parametros['polynomial'].replace(' ', '')
        
        # Determina el grado
        grados = []
        pos = 0
        while True:
            pos = polinomio.find('x^', pos)
            if pos == -1:
                break
            pos += 2 #salta x^
            
            end_pos = pos
            while end_pos < len(polinomio) and polinomio[end_pos].isdigit():
                end_pos += 1
            
            grados.append(int(polinomio[pos:end_pos]))
        grado_max = max(grados) if grados else 0
        
        # Inicializa con ceros
        coeficientes = [complex(0)] * (grado_max + 1)
        
        # Extrae todos los términos con sus exponentes
        terminos = []
        i = 0
        n = len(polinomio)
        coef_actual = ""
        exponente_actual = "0"  # Para términos constantes 
        while i < n: 
            
            # Maneja los  paréntesis de los coeficientes complejos
            if polinomio[i] == '(':
                coef_actual += polinomio[i]
                i += 1
                maneja_parentesis = 1
                while i < n and maneja_parentesis > 0:
                    if polinomio[i] == '(': maneja_parentesis += 1
                    elif polinomio[i] == ')': maneja_parentesis -= 1
                    coef_actual += polinomio[i]
                    i += 1 
            # Detecta x^
            elif i < n - 1 and polinomio[i:i+2] == 'x^':# Extrae el exponente
                i += 2
                exponente_actual = ""
                while i < n and polinomio[i].isdigit():
                    exponente_actual += polinomio[i]
                    i += 1
                terminos.append((coef_actual, exponente_actual))
                coef_actual = ""
                exponente_actual = "0"
            # Maneja operadores como separadores de términos
            elif polinomio[i] in '+-' and coef_actual:
                terminos.append((coef_actual, exponente_actual))
                coef_actual = polinomio[i]
                exponente_actual = "0"
                i += 1
            # Acumula caracteres del coeficiente
            else:
                coef_actual += polinomio[i]
                i += 1

        # Agrega el último término
        if coef_actual:
            terminos.append((coef_actual, exponente_actual))
        
        for coef_term, exp in terminos:
            # Maneja signo
            signo = -1 if coef_term.startswith('-') else 1
            coef_term = coef_term.lstrip('+-')
            
            # Convierte coeficiente a complejo
            coef = complex(coef_term.strip('()').replace('i', 'j')) * signo
            
            # Determina la posición en la lista (en orden descendente)
            pos = grado_max - (int(exp) if exp else 0)
            coeficientes[pos] = coef
        
        polinomio = polinomioComplejo(coeficientes)
        
        # Genera nombre único de salida
        nombre_base = os.path.splitext(os.path.basename(ruta_entrada))[0]
        nombre_salida = parametros.get('nombre', f'fractal_{nombre_base}.png')
        
        generador = generadorFractal(
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
        
        print(f"(ᵔᗜᵔ) Archivo procesado: {ruta_entrada}")
        print(f"     Grado del polinomio: {grado_max}")
        print(f"     Coeficientes: {[str(c) for c in coeficientes]}")
        print(f"✎ᝰ. Imagen generada: output/{nombre_salida}\n")
    
    except Exception as e:
        print(f" ૮ᵕ•_•ა  Error procesando {ruta_entrada}: {str(e)}\n")

def main():
    """
    Función principal de la generación de fractales desde los archivos de entrada.

    1. Crea directorios input/ y output/ si no existen
    2. Busca archivos .txt en input/
    3. Procesa cada archivo
    4. Genera imágenes fractales en output/
    5. Imprime información en la terminal

    Mensajes de salida:
    - Archivo procesado
    - Error
    - Resumen de grado, coeficientes, el mensaje y con conteo de archivos
    """
    # Crea los directorios si no existen, por si acaso más que nada
    os.makedirs("input", exist_ok=True)
    os.makedirs("output", exist_ok=True)
    
    # Procesa los archivos
    archivos_procesados = set()
    for archivo in sorted(os.listdir("input")):
        if archivo.endswith(".txt") and archivo not in archivos_procesados:
            archivos_procesados.add(archivo)
            ruta_completa = os.path.join("input", archivo)
            procesar_archivo_entrada(ruta_completa)
    
    if not archivos_procesados:
        print("(O_O)¡No se encontraron archivos .txt válidos en el directorio input!/")
    else:
        print(f"\n ¡Completado! (≡^∇^≡). Se generaron {len(archivos_procesados)} fractales.")

if __name__ == "__main__":
    main()