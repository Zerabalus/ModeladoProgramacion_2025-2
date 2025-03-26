from PIL import Image

class imagenGenerada:
    @staticmethod
    def guardar_imagen(imagen_array, nombre_archivo):
        Image.fromarray(imagen_array).save(nombre_archivo)