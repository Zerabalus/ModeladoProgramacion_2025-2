from src.polinomioComplejo import polinomioComplejo

def test_evaluar_polinomio():
    polinomio = polinomioComplejo([1 + 0j, -1 + 0j])  # x - 1
    assert polinomio.evaluar(1 + 0j) == 0 + 0j
    assert polinomio.evaluar(2 + 0j) == 1 + 0j