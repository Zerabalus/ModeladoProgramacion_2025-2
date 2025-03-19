package com.lab2;

import java.util.Scanner;

/**
 * Método principal para el programa. Este método proporciona una interfaz de
 * consola con un menú para ejecutar diferentes ejercicios según la entrada del
 * usuario.
 *
 * Los ejercicios según el pdf de la actividad son: 1. Dadas dos cadenas
 * determinar si se puede generar la primera con el contenido de la segunda. 2.
 * 3. 4.
 *
 * El usuario puede seleccionar una opción del menú y proporcionar la
 * información necesaria para realizar el ejercicio deseado. El programa
 * continúa solicitando al usuario hasta que se selecciona la opción de salida.
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ejercicio1 ejercicio1 = new Ejercicio1();

        while (true) {
            // Menú principal
            System.out.println("=================================");
            System.out.println("Selecciona el ejercicio a ejecutar:");
            System.out.println("1. Determinar si se puede generar una cadena a partir de otra.");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("4. ");
            System.out.println("0. Salir");
            System.out.print("Tu opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Para el salto de línea después de nextInt()

            if (opcion == 0) {
                System.out.println("Saliendo, vuelva pronto...");
                break;
            }

            switch (opcion) {
                case 1:
                    // Ejercicio 1
                    System.out.println("Ingresa la nota y el texto en el formato: 'nota', 'texto'");
                    String entrada = scanner.nextLine();

                    // Extraer los valores de nota y texto
                    String[] partes = entrada.split("'");
                    if (partes.length < 3) {
                        System.out.println("Formato de entrada incorrecto. Usa: 'nota', 'texto'");
                        break;
                    }

                    // La primera cadena entre comillas es nota, la segunda es texto
                    String nota = partes[1];
                    String texto = partes[3];

                    // Llamar al método puedeGenerarse y mostrar el resultado
                    boolean resultado = ejercicio1.puedeGenerarse(nota, texto);
                    System.out.println("Resultado: " + resultado);
                    break;

                case 2:
                    // Ejercicio 2

                case 3:
                    // Ejercicio 3

                case 4:
                    // Ejercicio 4

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;

            }
        }

        scanner.close();
    }
}
