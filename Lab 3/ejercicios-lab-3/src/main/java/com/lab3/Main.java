package com.lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Método principal para el programa. Este método proporciona una interfaz de
 * consola con un menú para ejecutar diferentes ejercicios según la entrada del
 * usuario.
 *
 * Los ejercicios según el pdf de la actividad son:
 * 1. Dada una matriz si una celda tiene valor cero convertir su fila y columna
 * en 0s.
 * 2. Dado un arreglo de intervalos combinar los sobrepuestos regresando loas
 * que no se sobreponen también.
 * 3. Dada una lista ligada determinar si esta contiene un ciclo o no.
 * 4. Dado un arreglo de enteros todos los valores aparecen dos veces a
 * excepción d uno, regresa el valor
 * que aparece solamente una vez.
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
            System.out.println("1. Convierte a ceros si hay alguno");
            System.out.println("2. Combina intervalos superpuestos");
            System.out.println("3. Determina si una lista tiene un ciclo");
            System.out.println("4. Encuentra el valor que aparece una vez en un arreglo");
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
                    // Ejercicio 1: Convierte a ceros
                    System.out.println("Ejercicio 1: Convierte a ceros si hay alguno");
                    System.out.println(
                            "Ingresa la matriz en formato [[a,b,c],[d,e,f],[g,h,i]]");
                    String inputMatriz = scanner.nextLine().trim();

                    // Procesar la entrada para extraer la matriz
                    try {
                        // Eliminar los corchetes exteriores y dividir en filas
                        String filasStr = inputMatriz.substring(1, inputMatriz.length() - 1);
                        String[] filasArray = filasStr.split("],\\s*\\[");

                        int filas = filasArray.length;
                        int columnas = filasArray[0].split(",\\s*").length;
                        int[][] matriz = new int[filas][columnas];

                        for (int i = 0; i < filas; i++) {
                            // Limpiar cada fila eliminando corchetes y espacios
                            String fila = filasArray[i].replaceAll("\\[|\\]", "").trim();
                            String[] elementos = fila.split(",\\s*");
                            for (int j = 0; j < columnas; j++) {
                                matriz[i][j] = Integer.parseInt(elementos[j]);
                            }
                        }

                        ejercicio1.convertirCeros(matriz);
                        System.out.println("Matriz resultante:");
                        for (int[] fila : matriz) {
                            for (int elemento : fila) {
                                System.out.print(elemento + " ");
                            }
                            System.out.println();
                        }
                    } catch (Exception e) {
                        System.out
                                .println("Formato no válido. Intenta de nuevo.");
                    }
                    break;

                case 2:
                    // Ejercicio 2: Combina intervalos superpuestos
                    System.out.println("Ejercicio 2: Combina intervalos superpuestos");
                    System.out.println("Ingresa los intervalos en formato [[a,b],[c,d],[e,f]]");
                    String inputIntervalos = scanner.nextLine().trim();

                    // Procesa la entrada para extraer los intervalos
                    try {
                        // Elimina los corchetes exteriores y dividir en intervalos
                        String intervalosStr = inputIntervalos.substring(1, inputIntervalos.length() - 1);
                        String[] intervalosArray = intervalosStr.split("],\\s*\\[");

                        int n = intervalosArray.length;
                        int[][] intervalos = new int[n][2];

                        for (int i = 0; i < n; i++) {
                            // Limpia cada intervalo eliminando corchetes y espacios
                            String intervalo = intervalosArray[i].replaceAll("\\[|\\]", "").trim();
                            String[] elementos = intervalo.split(",\\s*");
                            intervalos[i][0] = Integer.parseInt(elementos[0]);
                            intervalos[i][1] = Integer.parseInt(elementos[1]);
                        }

                        int[][] resultado = ejercicio2.combinar(intervalos);
                        System.out.println("Intervalos combinados:");
                        for (int[] intervalo : resultado) {
                            System.out.println(intervalo[0] + " " + intervalo[1]);
                        }
                    } catch (Exception e) {
                        System.out.println("Formato no válido. Intenta de nuevo.");
                    }
                    break;

                case 3:
                    // Ejercicio 3: Determina si una lista tiene un ciclo
                    System.out.println("Ejercicio 3: Determina si una lista tiene un ciclo");
                    System.out.println(
                            "Ingresa los valores de los nodos separados por comas.");
                    String inputNodos = scanner.nextLine().trim();

                    try {
                        String[] valores = inputNodos.split("\\s*,\\s*");
                        if (valores.length == 0) {
                            System.out.println("Debes ingresar al menos un valor.");
                            break;
                        }

                        Ejercicio3.NodoLigado cabeza = null;
                        Ejercicio3.NodoLigado actual = null;
                        Ejercicio3.NodoLigado[] listaNodos = new Ejercicio3.NodoLigado[valores.length];

                        // Crear la lista ligada
                        for (int i = 0; i < valores.length; i++) {
                            int valor = Integer.parseInt(valores[i].trim());
                            Ejercicio3.NodoLigado nuevoNodo = new Ejercicio3.NodoLigado(valor);
                            listaNodos[i] = nuevoNodo;
                            if (cabeza == null) {
                                cabeza = nuevoNodo;
                                actual = cabeza;
                            } else {
                                actual.siguiente = nuevoNodo;
                                actual = actual.siguiente;
                            }
                        }

                        // Pregunta si se desea crear un ciclo
                        System.out.print("¿Desea crear un ciclo? (s/n): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            System.out.print("Ingresa el índice del nodo al que desea apuntar el último nodo (0-"
                                    + (valores.length - 1) + "): ");
                            int indice = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            if (indice >= 0 && indice < valores.length) {
                                actual.siguiente = listaNodos[indice];
                            } else {
                                System.out.println("Índice no válido. No se creará ciclo.");
                            }
                        }

                        boolean tieneCiclo = ejercicio3.hasCycle(cabeza);
                        System.out.println("La lista " + (tieneCiclo ? "tiene" : "no tiene") + " un ciclo.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Uno de los valores ingresados no es un número válido.");
                    } catch (Exception e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Ejercicio 4: Encontrar número único
                    System.out.println("Ejercicio 4: Encuentra el valor que aparece una vez en un arreglo");
                    System.out.println("Ingresa los números en formato [a,b,c,d,e]");
                    String inputNumeros = scanner.nextLine().trim();

                    // Procesa la entrada para extraer los números
                    try {
                        // Elimina los corchetes exteriores
                        String numerosStr = inputNumeros.substring(1, inputNumeros.length() - 1);
                        String[] elementos = numerosStr.split(",\\s*");

                        int tamano = elementos.length;
                        int[] numeros = new int[tamano];

                        for (int i = 0; i < tamano; i++) {
                            numeros[i] = Integer.parseInt(elementos[i]);
                        }

                        int unico = ejercicio4.encontrarNumeroUnico(numeros);
                        System.out.println("El número único es: " + unico);
                    } catch (Exception e) {
                        System.out.println("Formato no válido. Intenta de nuevo.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}
