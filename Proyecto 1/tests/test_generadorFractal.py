import unittest
from src.generadorFractal import generadorFractal
from src.polinomioComplejo import polinomioComplejo

class test_generadorFractal(unittest.TestCase):
    def setUp(self):
        self.polinomio = polinomioComplejo([complex(1), complex(0), complex(1)])
        self.generador = generadorFractal(
            ancho=10,
            alto=10,
            polinomio=self.polinomio,
            min_complejo=complex(-2, -2),
            max_complejo=complex(2, 2),
            iteraciones=20,
            umbral=2.0,
            color_base=(127, 105, 165) #Moradito
        )

    def test_generar_tamano_correcto(self):
        
        """Verifica que la imagen generada tenga las dimensiones correctas"""
        imagen = self.generador.generar()
        
        # Comprueba dimensiones
        self.assertEqual(len(imagen), 10)  # Alto
        self.assertEqual(len(imagen[0]), 10)  # Ancho
        
        # Cada pixel debe ser de 3 valores
        self.assertEqual(len(imagen[0][0]), 3)
        
    def test_parametros_invalidos(self):
        with self.assertRaises(ValueError):
            generadorFractal(
                ancho=0,  # Inválido
                alto=10,
                polinomio=self.polinomio,
                min_complejo=complex(-2, -2),
                max_complejo=complex(2, 2),
                iteraciones=20,
                umbral=2.0
            )
            
    def test_no_hay_umbral(self):
        generador = generadorFractal(
            ancho=10,
            alto=10,
            polinomio=self.polinomio,
            min_complejo=complex(-2, -2),
            max_complejo=complex(2, 2),
            iteraciones=20,
            umbral=0.0  # Todos los puntos deberían diverger
        )
        imagen = generador.generar()
        # Verificar que no hay puntos negros
        for fila in imagen:
            for pixel in fila:
                self.assertNotEqual(pixel, [0, 0, 0])
    

    def test_generar_tipos_de_datos(self):
        
        """Verifica que los tipos de datos en la imagen sean correctos"""
        imagen = self.generador.generar()
        
        for fila in imagen:
            for pixel in fila:
                
                # Componentes son enteros
                self.assertIsInstance(pixel[0], int)
                self.assertIsInstance(pixel[1], int)
                self.assertIsInstance(pixel[2], int)
                
                # Los valores deben estar entre 0 y 255
                self.assertTrue(0 <= pixel[0] <= 255)
                self.assertTrue(0 <= pixel[1] <= 255)
                self.assertTrue(0 <= pixel[2] <= 255)

    def test_generar_puntos_conocidos(self):
        """Verifica el comportamiento en puntos conocidos del plano complejo"""
        
        generador = generadorFractal(
            ancho=3,
            alto=3,
            polinomio=self.polinomio,
            min_complejo=complex(-1, -1),
            max_complejo=complex(1, 1),
            iteraciones=10,
            umbral=2.0,
            color_base=(255, 0, 0)
        )
        
        imagen = generador.generar()
        
        # El centro (1,1) debería corresponder a z ≈ 0+0i
        # No debería ser negro
        self.assertNotEqual(imagen[1][1], [0, 0, 0])
        
        # Debería diverger más rápido
        self.assertNotEqual(imagen[0][0], [0, 0, 0])
        self.assertNotEqual(imagen[2][2], [0, 0, 0])

    def test_generar_puntos_convergentes(self):
        """Verifica que los puntos convergentes sean negros"""
        
        # Polinomio que converge
        polinomio_convergente = polinomioComplejo([complex(0), complex(1)])
        
        generador = generadorFractal(
            ancho=5,
            alto=5,
            polinomio=polinomio_convergente,
            min_complejo=complex(-0.1, -0.1),
            max_complejo=complex(0.1, 0.1),
            iteraciones=10,
            umbral=2.0,
            color_base=(127, 105, 165) #Moradito
        )
        
        imagen = generador.generar()
        
        # Todos los puntos deberían ser negros (convergen)
        for fila in imagen:
            for pixel in fila:
                self.assertEqual(pixel, [0, 0, 0])

if __name__ == "__main__":
    unittest.main()