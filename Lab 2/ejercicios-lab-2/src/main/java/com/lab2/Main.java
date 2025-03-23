package com.lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Método principal para el programa. Este método proporciona una interfaz de
 * consola con un menú para ejecutar diferentes ejercicios según la entrada del
 * usuario.
 *
 * Los ejercicios según el pdf de la actividad son:
 * 1. Dadas dos cadenas determinar si se puede generar la primera con el
 * contenido de la segunda.
 * 2. Verificar si existen dos índices distintos con valores iguales dentro de
 * una
 * distancia k.
 * 3. Determinar si un número es feliz.
 * 4. Encontrar el índice de la primera ocurrencia de una subcadena en una
 * cadena.
 *
 * El usuario puede seleccionar una opción del menú y proporcionar la
 * información necesaria para realizar el ejercicio deseado. El programa
 * continúa solicitando al usuario hasta que se selecciona la opción de salida.
 */

public class Main {

    /**
     * @param args
     */
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
            System.out.println("1. Determina si se puede generar una cadena a partir de otra.");
            System.out.println("2. Existencia de índices distintos con valores iguales");
            System.out.println("3. Determina si un número es feliz");
            System.out.println("4. Encontrar el índice de la primera ocurrencia de una subcadena en una cadena.");
            System.out.println("0. Salir");
            System.out.print("Tu opción: ");

            int opcion = -1; // Valor inicial para la opción
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Para el salto de línea después de nextInt()
            } catch (InputMismatchException e) {
                // Si el usuario ingresa algo que no es un número
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                scanner.nextLine(); // Limpia
                continue; // Vuelve al inicio del bucle
            }

            if (opcion == 0) {
                System.out.println("Saliendo, vuelva pronto...");
                break;
            }

            switch (opcion) {
                case 1:
                    // Ejercicio 1
                    System.out.println("Ingresa la nota y el texto en el formato: 'nota', 'texto'");
                    String entrada = scanner.nextLine();

                    // Extrae los valores de nota y texto
                    String[] partes = entrada.split("'");
                    if (partes.length < 3) {
                        System.out.println("Formato de entrada incorrecto. Usa: 'nota', 'texto'");
                        break;
                    }

                    // La primera cadena entre comillas es nota, la segunda es texto
                    String nota = partes[1];
                    String texto = partes[3];

                    // Llamar al método puedeGenerarse de Ejercicio1 y nos da el resultado
                    boolean resultado = ejercicio1.puedeGenerarse(nota, texto);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 2:
                    // Ejercicio 2
                    System.out.println(
                            "Ingresa el arreglo de números y el valor de k en el formato: [arreglo de números separados por comas], número");
                    String entradaEjercicio2 = scanner.nextLine();

                    try {
                        // Extrae el arreglo y el valor de k
                        String[] partesEjercicio2 = entradaEjercicio2.split("],");
                        if (partesEjercicio2.length < 2) {
                            System.out.println(
                                    "Formato de entrada incorrecto. Usa: [arreglo de números separados por comas], número");
                            break;
                        }

                        // Extrae el arreglo de números
                        String arregloStr = partesEjercicio2[0].replace("[", "").replace(" ", "");
                        String[] numerosStr = arregloStr.split(",");
                        int[] arreglo = new int[numerosStr.length];
                        for (int i = 0; i < numerosStr.length; i++) {
                            arreglo[i] = Integer.parseInt(numerosStr[i]);
                        }

                        // Extrae el valor de k
                        int k = Integer.parseInt(partesEjercicio2[1].trim());

                        // Llama al método indicesDistintos de Ejercicio2 y nos da el resultado
                        boolean resultadoEjercicio2 = ejercicio2.indicesDistintos(arreglo, k);
                        System.out.println("Resultado: " + resultadoEjercicio2);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Formato de entrada incorrecto. Asegúrate de que el arreglo y k sean números válidos.");
                    }
                    break;

                case 3:
                    // Ejercicio 3
                    System.out.println("Ingresa un número para verificar si es feliz:");
                    String entradaEjercicio3 = scanner.nextLine();

                    try {
                        // Valida que la entrada sea un número sin símbolos adicionales
                        int numero = Integer.parseInt(entradaEjercicio3.trim());

                        // Llama al método esFeliz de Ejercicio3 y nos da el resultado
                        boolean resultadoEjercicio3 = ejercicio3.esFeliz(numero);
                        System.out.println("Resultado: " + resultadoEjercicio3);
                    } catch (NumberFormatException e) {
                        System.out.println(
                                "Formato de entrada incorrecto. Solo se aceptan números sin símbolos adicionales.");
                    }
                    break;

                case 4:
                    // Ejercicio 4
                    System.out.println("Ingresa las cadenas en el formato: cadena1, cadena2");
                    String entradaEjercicio4 = scanner.nextLine();

                    // Extrae las cadenas
                    String[] partesEjercicio4 = entradaEjercicio4.split(",");
                    if (partesEjercicio4.length < 2) {
                        System.out.println("Formato de entrada incorrecto. Usa: cadena1, cadena2");
                        break;
                    }

                    // Elimina espacios en blanco alrededor de las cadenas
                    String cadena1 = partesEjercicio4[0].trim();
                    String cadena2 = partesEjercicio4[1].trim();

                    // Llama al método indiceOcurrencia de Ejercicio4 y nos da el resultado
                    int resultadoEjercicio4 = ejercicio4.indiceOcurrencia(cadena1, cadena2);
                    System.out.println("Resultado: " + resultadoEjercicio4);
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
