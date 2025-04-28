package com.lab3;

/**
 * Clase del método que modifica una matriz convirtiendo en ceros
 * todas las filas y columnas donde se encuentre al menos un cero.
 * No utiliza espacio adicional.
 */

public class Ejercicio1 {

    /**
     * Identifica las filas y columnas que contienen ceros, y luego
     * actualiza la matriz
     *
     * @param matriz La matriz de enteros a modificar.
     *               No debe ser nula y debe tener al menos un elemento.
     */

    public void convertirCeros(int[][] matriz) {
        int[] fila = new int[matriz.length];
        int[] columna = new int[matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 0) {
                    fila[i] = -1;
                    columna[j] = -1;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (fila[i] == -1 || columna[j] == -1) {
                    matriz[i][j] = 0;
                }
            }
        }
    }
}
