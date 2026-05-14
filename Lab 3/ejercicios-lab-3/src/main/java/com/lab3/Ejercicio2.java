package com.lab3;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Clase del método que dado un arreglo de intervalos , combina
 * todos los intervalos sobrepuestos, regresando un arreglo con todos los
 * intervalos sin sobreponer, respetando la cobertura de los
 * intervalos originales dados.
 */

public class Ejercicio2 {

    /**
     * Combina intervalos sobrepuestos en un array de intervalos dado.
     * 
     * @param intervalos Arreglo de intervalos donde cada intervalo está
     *                   representado como [inicio, fin]
     * @return Arreglo convertido
     */

    public int[][] combinar(int[][] intervalos) {
        // Si es es nulo o vacío, retornarlo tal cual
        if (intervalos == null || intervalos.length == 0)
            return intervalos;

        // Ordena los intervalos por su valor inicial
        Arrays.sort(intervalos, (a, b) -> Integer.compare(a[0], b[0]));

        // Si el final del intervalo anterior es mayor que el inicio del intervalo
        // actual, entonces hay una superposición
        LinkedList<int[]> intervalosCombinados = new LinkedList<>();

        for (int[] actual : intervalos) {
            // Si la lista está vacía o no hay superposición solo agrega al intervalo actual
            if (intervalosCombinados.isEmpty() || intervalosCombinados.getLast()[1] < actual[0]) {
                intervalosCombinados.add(actual);
            }
            // Si hay superposición, combina el actual con el último intervalo
            else {
                intervalosCombinados.getLast()[1] = Math.max(intervalosCombinados.getLast()[1], actual[1]);
            }
        }

        // Convierte la lista de vuelta a un arreglo y lo devuelve
        return intervalosCombinados.toArray(new int[0][]);
    }
}
