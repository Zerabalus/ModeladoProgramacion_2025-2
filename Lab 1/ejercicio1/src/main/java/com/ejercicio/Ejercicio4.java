package com.ejercicio;

/**
 * Convierte un número decimal a su representación romana.
 *
 * @param numero El número decimal a convertir.
 * @return La representación romana del número decimal.
 */
public class Ejercicio4 {

    public String convertirDecimalARomano(int numero) {
        int[] valoresDecimales = {
                1000,
                900,
                500,
                400,
                100,
                90,
                50,
                40,
                10,
                9,
                5,
                4,
                1, };
        String[] valoresRomanos = {
                "M",
                "CM",
                "D",
                "CD",
                "C",
                "XC",
                "L",
                "XL",
                "X",
                "IX",
                "V",
                "IV",
                "I", };

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < valoresDecimales.length; i++) {
            while (numero >= valoresDecimales[i]) {
                resultado.append(valoresRomanos[i]);
                numero -= valoresDecimales[i];
            }
        }

        return resultado.toString();
    }
}
