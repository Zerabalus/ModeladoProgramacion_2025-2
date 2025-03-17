package com.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio2Test {

    /**
     * Unit test que verifica que el prefijo mas grande de un arreglo de cadenas.
     * Salida esperada: "flor"
     */

    @Test
    void testPrefijoComun() {

        Ejercicio2 buscador = new Ejercicio2();
        String[] entrada = { "flor", "flores", "floreria" };
        String resultadoEsperado = "flor";

        String resultado = buscador.prefijoMasGrande(entrada);

        assertEquals(resultadoEsperado, resultado);
    }

    /**
     * Unit test que verifica que el prefijo mas grande de un arreglo de cadenas no
     * exista.
     * Salida esperada: ""
     */

    @Test
    void testSinPrefijoComun() {
        Ejercicio2 buscador = new Ejercicio2();
        String[] entrada = { "flor", "flores", "vape" };
        String resultadoEsperado = "";
        String resultado = buscador.prefijoMasGrande(entrada);
        assertEquals(resultadoEsperado, resultado);
    }
}
