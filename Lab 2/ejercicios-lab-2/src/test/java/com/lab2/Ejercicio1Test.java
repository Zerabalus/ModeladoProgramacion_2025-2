package com.lab2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Ejercicio1Test {

    /**
     * Verifica que el método puedeGenerarse regrese false cuando la nota "aa"
     * no puede ser generada con el texto "ab".
     */

    @Test
    public void testPuedeGenerarse_Ejemplo1() {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        String nota = "aa";
        String texto = "ab";
        boolean resultado = ejercicio1.puedeGenerarse(nota, texto);
        assertFalse(resultado);
    }

    /**
     * Verifica que el método puedeGenerarse regrese true cuando la nota "aa"
     * puede ser generada con el texto "aba".
     */

    @Test
    public void testPuedeGenerarse_Ejemplo2() {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        String nota = "aa";
        String texto = "aba";
        boolean resultado = ejercicio1.puedeGenerarse(nota, texto);
        assertTrue(resultado);
    }
}
