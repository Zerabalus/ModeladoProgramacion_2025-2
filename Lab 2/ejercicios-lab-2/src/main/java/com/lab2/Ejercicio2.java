package com.lab2;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que proporciona un método para determinar si existen dos índices
 * distintos
 * con valores iguales dentro de un rango de k lugares.
 */
public class Ejercicio2 {

    /**
     * Verifica que dado un arreglo de enteros A y un entero k, determina
     * si existen dos índices distintos i y j en el arreglo A, tales que A[i]
     * == A[j] y la diferencia entre i y j es menor o igual a k.
     *
     * @param A el arreglo de enteros a evaluar
     * @param k la distancia máxima permitida entre índices con valores iguales
     * @return true si existen dos índices que cumplen la condición, false en caso
     *         contrario
     */

    public boolean indicesDistintos(int[] A, int k) {
        Map<Integer, Integer> ultimoIndice = new HashMap<>();

        for (int indice = 0; indice < A.length; indice++) {
            int numeroActual = A[indice];

            if (ultimoIndice.containsKey(numeroActual)) {
                int indiceAnterior = ultimoIndice.get(numeroActual);
                if (indice - indiceAnterior <= k) {
                    return true;
                }
            }

            ultimoIndice.put(numeroActual, indice);
        }

        return false;
    }
}
