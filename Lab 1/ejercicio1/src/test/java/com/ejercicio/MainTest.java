package com.ejercicio;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MainTest {

    /**
     * Prueba unitaria que verifica que se muestre un mensaje de error cuando se
     * proporciona una entrada inválida para el Ejercicio 1 (corchetes mal
     * puestos).
     *
     * En este test, se simula una entrada inválida para el Ejercicio 1 (falta
     * el corchete de cierre externo). Se verifica que se muestre un mensaje de
     * error con el formato correcto.
     */
    @Test
    public void testEjercicio1_EntradaInvalida() {
        // Simula una entrada inválida para el Ejercicio 1 (corchetes mal puestos)
        String input = "1\n[[1,2,3],[2,4,5],[6,7,8]\n0\n"; // Falta el corchete de cierre externo
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Ejecuta el método main
        Main.main(new String[] {});

        // Verifica que se muestre un mensaje de error
        String output = outputStream.toString();
        assertTrue(output.contains("Entrada inválida. Debe ingresar una matriz en el formato [[...],[...]]."));
    }

    /**
     * Prueba unitaria que verifica que se muestre un mensaje de error cuando se
     * proporciona una entrada inválida para el Ejercicio 2 (formato de entrada
     * incorrecto).
     *
     * En este test, se simula una entrada inválida para el Ejercicio 2 Se
     * verifica que se muestre un mensaje de error con el formato correcto.
     */
    @Test
    public void testEjercicio2_EntradaInvalida() {
        String input = "2\n\"flor\", \"floristeria\", \"floreria\"\n0\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Captura la salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Simular entrada y ejecutar Main.main()
        Main.main(new String[] {});
        // Verificar que se muestre el mensaje de error
        String output = outputStream.toString();
        assertTrue(output.contains("Formato de entrada inválido. Debe ser: cadena1, cadena2, ..."));
    }
}
