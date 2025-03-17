package com.ejercicio;

/**
 * Encontrar los valores faltantes y repetidos en una matriz.
 * 
 * @param matriz             La matriz a analizar.
 * @param numerosEncontrados Un arreglo de booleanos que indica si se ha
 *                           encontrado
 *                           un numero en la matriz.
 * @param numeroRepetido     El numero que se encuentra repetido en la matriz.
 * @param numeroFaltante     El numero que falta en la matriz.
 * @return Un vector con dos elementos. El primer elemento es el valor que se
 *         encuentra repetido en la matriz y el segundo el valor que falta.
 */

public class Ejercicio1 {

    public int[] encontrarValores(int[][] matriz) {

        int tamaño = matriz.length;
        boolean numerosEncontrados[] = new boolean[tamaño * tamaño];
        int numeroRepetido = 0;
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int numero : matriz[fila]) {
                if (numerosEncontrados[numero - 1])
                    numeroRepetido = numero;
                else
                    numerosEncontrados[numero - 1] = true;
            }
        }
        int numeroFaltante = 0;
        for (int fila = 0; fila < numerosEncontrados.length; fila++) {
            if (!numerosEncontrados[fila]) {
                numeroFaltante = fila + 1;
                break;
            }
        }
        return new int[] { numeroRepetido, numeroFaltante };
    }
}
