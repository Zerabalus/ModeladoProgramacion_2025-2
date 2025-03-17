package com.ejercicio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicio1 ejercicio1 = new Ejercicio1();
        Ejercicio2 ejercicio2 = new Ejercicio2();
        Ejercicio3 ejercicio3 = new Ejercicio3();
        Ejercicio4 ejercicio4 = new Ejercicio4();

        while (true) {
            // Menú principal
            System.out.println("=================================");
            System.out.println("Selecciona el ejercicio a ejecutar:");
            System.out.println("1. Encontrar número repetido y faltante en una matriz.");
            System.out.println("2. Encontrar el prefijo más grande común entre cadenas.");
            System.out.println("3. Convertir un número romano a decimal.");
            System.out.println("4. Convertir un número decimal a romano.");
            System.out.println("0. Salir");
            System.out.print("Tu opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                break;
            }

            switch (opcion) {
                case 1:
                    // Ejercicio 1
                    System.out.println("Ejercicio 1: Encontrar número repetido y faltante en una matriz.");
                    System.out.print(
                            "Ingrese el tamaño de la matriz (n x n), con 2 <= n <= 50; entre corchetes y separados por comas: ");

                    String input = scanner.nextLine();

                    // Procesa la entrada eliminando espacios y corchetes externos
                    input = input.replaceAll("\\s+", ""); // Elimina espacios en blanco
                    if (input.length() > 1) {
                        input = input.substring(1, input.length() - 1); // Elimina los corchetes de afuera
                    } else {
                        System.out.println("Entrada inválida. Debe ingresar una matriz en el formato.");
                        break;
                    }

                    // Dividir por filas
                    String[] filas = input.split("\\],\\[");

                    int tamaño = filas.length;
                    int[][] matriz = new int[tamaño][tamaño];

                    for (int i = 0; i < tamaño; i++) {
                        // Eliminar cualquier corchete restante y dividir por comas
                        String[] numeros = filas[i].replaceAll("\\[|\\]", "").split(",");
                        for (int j = 0; j < tamaño; j++) {
                            matriz[i][j] = Integer.parseInt(numeros[j]);
                        }
                    }

                    // Pasar la matriz a Ejercicio1
                    int[] resultado = ejercicio1.encontrarValores(matriz);
                    System.out.println("Número repetido: " + resultado[0]);
                    System.out.println("Número faltante: " + resultado[1]);
                    break;

                case 2:
                    // Ejercicio 2
                    System.out.println("Ejercicio 2: Encontrar el prefijo más grande común entre cadenas.");
                    System.out.print("Ingrese las cadenas en formato [\"cadena1\", \"cadena2\", ...]: ");
                    String inputCadenas = scanner.nextLine();

                    // Procesa la entrada
                    inputCadenas = inputCadenas.trim(); // Elimina espacios al inicio y final
                    if (inputCadenas.startsWith("[") && inputCadenas.endsWith("]")) {
                        inputCadenas = inputCadenas.substring(1, inputCadenas.length() - 1); // Elimina corchetes
                    } else {
                        System.out.println("Formato de entrada inválido. Debe ser: [\"cadena1\", \"cadena2\", ...]");
                        break;
                    }

                    // Divide las cadenas por comas y elimina comillas y espacios
                    String[] cadenas = inputCadenas.split(",");
                    for (int i = 0; i < cadenas.length; i++) {
                        cadenas[i] = cadenas[i].trim().replace("\"", ""); // Elimina comillas y espacios
                    }

                    // Llama al método para encontrar el prefijo más grande
                    String resultado2 = ejercicio2.prefijoMasGrande(cadenas);
                    System.out.println("Prefijo más grande: " + resultado2);
                    break;

                case 3:
                    // Ejercicio 3
                    System.out.println("Ejercicio 3: Convertir un número romano a decimal.");
                    String numeroRomano;
                    while (true) {
                        System.out.print("Ingrese un número romano (1 a 3999): ");
                        numeroRomano = scanner.next(); // Entrada como cadena

                        // Valida que el número romano esté dentro del rango permitido y no exceda 15
                        // caracteres
                        if (numeroRomano.length() <= 15 && numeroRomano.matches("^[IVXLCDM]+$")
                                && ejercicio3.convertirRomanoADecimal(numeroRomano) >= 1
                                && ejercicio3.convertirRomanoADecimal(numeroRomano) <= 3999) {
                            break; // Si el número romano es válido y está en el rango, sale del bucle
                        } else {
                            System.out.println(
                                    "Número romano fuera de rango, inválido o excede el límite de 15 caracteres. "
                                            + "Ingresa un número entre 1 a 3999 con máximo 15 caracteres.");
                        }
                    }

                    int resultado3 = ejercicio3.convertirRomanoADecimal(numeroRomano);
                    System.out.println("Número decimal: " + resultado3);
                    break;

                case 4:
                    // Ejercicio 4
                    System.out.println("Ejercicio 4: Convertir un número decimal a romano.");
                    int numeroDecimal;
                    while (true) {
                        System.out.print("Ingrese un número decimal (1 a 3999): ");
                        if (scanner.hasNextInt()) { // Verificar si la entrada es un número entero
                            numeroDecimal = scanner.nextInt();
                            if (numeroDecimal >= 1 && numeroDecimal <= 3999) { // Verificar si está dentro del rango
                                break; // Sale del bucle si el número es válido
                            } else {
                                System.out.println("El número debe estar en el rango [1, 3999]. Intente de nuevo.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Debe ingresar un número entero. Intente de nuevo.");
                            scanner.next(); // Descarta la entrada no válida
                        }
                    }

                    // Pasa a Ejercicio4 para convertir el número decimal a romano
                    String resultado4 = ejercicio4.convertirDecimalARomano(numeroDecimal);
                    System.out.println("Número romano: " + resultado4);
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}
