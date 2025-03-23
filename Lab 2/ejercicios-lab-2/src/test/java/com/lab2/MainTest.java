package com.lab2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MainTest {

    /**
     * Verifica que el programa maneja el formato incorrecto para el Ejercicio 1
     * (sin comillas).
     * Debe mostrar el mensaje "Formato de entrada incorrecto. Usa: 'nota',
     * 'texto'".
     */

    @Test
    public void testFormatoIncorrectoEjercicio1() {

        String input = "1\naa, aab\n0\n"; // Formato incorrecto: falta comilla
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirige la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecuta el método main
        Main.main(new String[] {});

        // Verifica que el programa maneja el formato incorrecto
        String output = outContent.toString();
        assertTrue(output.contains("Formato de entrada incorrecto. Usa: 'nota', 'texto'"));
    }

    /**
     * Test para verificar que el programa maneja correctamente un formato de
     * entrada
     * incorrecto para el Ejercicio 2. Simula la entrada del usuario con un formato
     * que falta una coma en el arreglo, y verifica que la salida indique el error
     * de formato esperado.
     */

    @Test
    public void testFormatoIncorrectoEjercicio2() {

        String input = "2\n [1, 2, 3] 3\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Redirige la salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecuta el método main
        Main.main(new String[] {});

        // Verifica que el programa maneja el formato incorrecto
        String output = outContent.toString();
        assertTrue(output
                .contains("Formato de entrada incorrecto. Usa: [arreglo de números separados por comas], número"));

    }
}
