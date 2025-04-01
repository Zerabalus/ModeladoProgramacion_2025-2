from PIL import Image

class imagenGenerada:
    """
    Módulo que tiene la clase para manejar la generación y guardado de imágenes.
    """
    
    @staticmethod
    def guardar_imagen(imagen_lista, nombre_archivo):
        """
        Guarda una imagen a partir de una matriz de píxeles
        
        Args:
        imagen_lista: Lista de listas que representan los píxeles en formato RGB
        nombre_archivo: Nombre del archivo como se guardará la imagen
        """
        # Crea una nueva imagen en modo RGB
        img = Image.new('RGB', (len(imagen_lista[0]), len(imagen_lista)))
        
        # Pone los píxeles
        pixels = img.load()
        for y in range(img.size[1]):
            for x in range(img.size[0]):
                pixels[x, y] = tuple(imagen_lista[y][x])
        
        img.save(nombre_archivo)