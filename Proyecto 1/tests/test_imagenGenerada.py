import unittest
import os
import shutil
from PIL import Image
from src.imagenGenerada import imagenGenerada

class test_imagenGenerada(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        os.makedirs("test_output", exist_ok=True)
        cls.imagen_prueba = [[[127, 105, 165] for _ in range(10)] for _ in range(10)]  # Moradito
    
    @classmethod
    def tearDownClass(cls):
        shutil.rmtree("test_output")
    
    def test_guardar_imagen(self):
        imagenGenerada.guardar_imagen(self.imagen_prueba, "test_output/test.png")
        self.assertTrue(os.path.exists("test_output/test.png"))

if __name__ == "__main__":
    unittest.main()