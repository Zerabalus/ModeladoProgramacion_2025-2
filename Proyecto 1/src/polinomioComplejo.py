class polinomioComplejo:
    
    """
    Módulo que tiene la clase que representa un polinomio con coeficientes complejos y permite evaluarlo en 
    puntos del plano.
    
    Métodos:
        evaluar(z): Evalúa el polinomio en el punto complejo z.
    """

    def __init__(self, coeficientes):
        
        """
        Inicializa el polinomio con los coeficientes dados.

        Args:
            coeficientes (list[complex]): Coeficientes del polinomio ordenados
        """
        
        self.coeficientes = coeficientes

    def evaluar(self, z):
        
        """
        Evalúa el polinomio en el punto complejo z, basado en el README del proyecto

        Args:
            z (complex): Punto donde se evalua el polinomio

        Returns:
            complex: Resultado de la evaluación
        """
        return sum(coef * (z ** i) for i, coef in enumerate(self.coeficientes))