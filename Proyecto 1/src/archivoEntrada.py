"""
Módulo que tiene la clase para leer archivos de entrada con parámetros dados en un formato específico 
(el que se indica en los *.txt del proyecto).

Clase:
    archivoEntrada: Contiene métodos para analizar archivos y procesar sus valores.

Métodos:
    - analizar_archivo(ruta_archivo): Lee un archivo y devuelve los parámetros ya procesados
    - analizar_valor(valor): Método para convertir valores según su formato
    (polinomios, números complejos, enteros, tuplas)
"""

class archivoEntrada:
    @staticmethod
    def analizar_archivo(ruta_archivo):
        """
        Analiza un archivo de entrada y extrae los parámetros.
        Args:
            ruta_archivo (str): Ruta del archivo a procesar
        Returns:
            Los parámetros procesados. Los valores se convierten automáticamente a:
                - int 
                - complex 
                - tuple
                - str
        """
        
        parametros = {}
        with open(ruta_archivo, 'r') as archivo:
            for linea in archivo:
                linea = linea.strip() #para eliminar espacios, tabulaciones y saltos de línea
                if not linea or linea.startswith('//'):
                    continue
                try:
                    clave, valor = [part.strip() for part in linea.split(':', 1)]
                    parametros[clave] = archivoEntrada.analizar_valor(valor)
                except ValueError as e:
                    print(f"Error con la línea: '{linea}'. Error: {e}")
                    continue
        return parametros

    @staticmethod
    def analizar_valor(valor):
        
        valor = valor.strip() # El strip similar a lo de arriba
        
        # Polinomios como str
        if 'x^' in valor:
            return valor
        # Números complejos
        if 'i' in valor:
            valor = valor.replace('i', 'j').replace(' ', '')
            try:
                return complex(valor)
            except ValueError:
                return valor
        # Números enteros
        elif valor.isdigit():
            return int(valor)
        # Tuplas
        elif valor.startswith('(') and valor.endswith(')'):
            return tuple(map(int, valor.strip('()').split(',')))
        else:
            return valor