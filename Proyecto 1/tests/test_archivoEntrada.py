import unittest
import os
import shutil
from src.archivoEntrada import archivoEntrada

class TestArchivoEntrada(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        os.makedirs("test_input", exist_ok=True)
        with open("test_input/test_file.txt", "w") as f:
            f.write(
                "// Ejemplo comentario\n"
                "width: 800\n"
                "height: 600\n"
                "polynomial: x^2 + (1+2i)x^1 + (3-4i)\n"
                "min: (-2,-1)\n"  
                "max: (1,1)\n"
                "iterations: 100\n"
                "threshold: 2\n"
                "nombre: test_fractal.png\n"
                "color: (255,0,0)\n"
            )

    
    @classmethod
    def tearDownClass(cls):
        shutil.rmtree("test_input")
    
    def test_analizar_archivo(self):
        parametros = archivoEntrada.analizar_archivo("test_input/test_file.txt")
        
        self.assertIsInstance(parametros, dict)
        self.assertEqual(parametros['width'], 800)
        self.assertEqual(parametros['height'], 600)
        self.assertEqual(parametros['polynomial'], "x^2 + (1+2i)x^1 + (3-4i)")
        
        
    def test_analizar_valor(self):
        
        self.assertEqual(archivoEntrada.analizar_valor("42"), 42)
        self.assertEqual(archivoEntrada.analizar_valor("3+4i"), complex(3, 4))
        self.assertEqual(archivoEntrada.analizar_valor("(1,2,3)"), (1, 2, 3))
        self.assertEqual(archivoEntrada.analizar_valor("x^2 + 1"), "x^2 + 1")

if __name__ == "__main__":
    unittest.main()

