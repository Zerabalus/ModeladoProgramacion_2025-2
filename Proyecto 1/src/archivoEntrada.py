import re

class archivoEntrada:
    @staticmethod
    def parsear_archivo(ruta_archivo):
        parametros = {}
        with open(ruta_archivo, 'r') as archivo:
            for linea in archivo:
                linea = linea.strip()
                if not linea or linea.startswith('//'):
                    continue
                try:
                    clave, valor = [part.strip() for part in linea.split(':', 1)]
                    parametros[clave] = archivoEntrada._parsear_valor(valor)
                except ValueError as e:
                    print(f"Error al parsear la línea: '{linea}'. Error: {e}")
                    continue
        return parametros

    @staticmethod
    def _parsear_valor(valor):
        valor = valor.strip()
        
        # Manejar polynomial como string sin cambios
        if 'x^' in valor:
            return valor
            
        # Manejar números complejos
        if 'i' in valor:
            valor = valor.replace('i', 'j').replace(' ', '')
            try:
                return complex(valor)
            except ValueError:
                return valor
        # Manejar números enteros
        elif valor.isdigit():
            return int(valor)
        # Manejar tuplas de colores
        elif valor.startswith('(') and valor.endswith(')'):
            return tuple(map(int, valor.strip('()').split(',')))
        else:
            return valor