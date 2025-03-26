class polinomioComplejo:
    def __init__(self, coeficientes):
        self.coeficientes = coeficientes  # Ej: [1+0j, -1+0j] para x - 1

    def evaluar(self, z):
        return sum(coef * (z ** i) for i, coef in enumerate(self.coeficientes))