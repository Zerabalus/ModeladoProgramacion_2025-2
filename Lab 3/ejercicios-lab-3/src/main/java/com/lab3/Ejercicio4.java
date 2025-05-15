package com.lab3;

import java.util.Arrays;

public class Ejercicio4 {

    /**
     * Encuentra el número único en un arreglo donde todos los demás números
     * aparecen dos veces excepto por uno.
     * 
     * @param nums Arreglo de números enteros
     * @return El número que aparece una sola vez
     */
    public int encontrarNumeroUnico(int[] nums) {
        // Ordena el arreglo
        Arrays.sort(nums);

        // Recorre el arreglo de dos en dos
        for (int i = 0; i < nums.length - 1; i += 2) {
            // Si los números consecutivos no son iguales, ya encontramos el que es único
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}
