package com.lab2;

/**
 * Clase que proporciona un método para determinar si un
 * número es feliz. Un número es feliz si eventualmente
 * llega a 1 al reemplazarlo por la suma de los cuadrados
 * de sus dígitos.
 *
 * @param n el número a evaluar
 * 
 * @return true si el número es feliz, false en caso contrario
 */

public class Ejercicio3 {

    public boolean esFeliz(int n) {

        /*
         * Como nota, para números de un solo
         * dígito menores a 10, solo 1 y 7 pueden
         * ser felices, eventualmente conducir a 1
         */

        if (n == 1 || n == 7) {
            return true;
        }
        if (n < 10) {
            return false;
        }

        int sumaCuadrados = 0;
        while (n > 0) {
            int numero = n % 10;
            sumaCuadrados += numero * numero;
            n /= 10;
        }

        return esFeliz(sumaCuadrados);
    }
}
