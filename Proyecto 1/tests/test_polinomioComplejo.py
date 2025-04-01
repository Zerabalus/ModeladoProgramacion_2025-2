import unittest
from src.polinomioComplejo import polinomioComplejo

class test_polinomioComplejo(unittest.TestCase):
    def test_evaluar(self):
        polinomio = polinomioComplejo([complex(1), complex(2), complex(1)])
        self.assertEqual(polinomio.evaluar(complex(1)), complex(4))
    
    def test_polinomio_vacio(self):
        polinomio = polinomioComplejo([])
        self.assertEqual(polinomio.evaluar(complex(1,1)), complex(0))
            
if __name__ == "__main__":
    unittest.main()
