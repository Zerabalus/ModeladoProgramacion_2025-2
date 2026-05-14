package com.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio3Test {

    /**
     * Prueba unitaria de la conversión del número romano "LVIII" a su valor
     * decimal.
     * Verifica que el resultado sea "58".
     */
    @Test
    void testRomanoLVIII() {
        Ejercicio3 conversor = new Ejercicio3();
        String entrada = "LVIII";
        int salidaEsperada = 58;
        assertEquals(salidaEsperada, conversor.convertirRomanoADecimal(entrada));
    }

    /**
     * Prueba unitaria de la conversión del número romano "MCMXCIV" a su valor
     * decimal.
     * Verifica que el resultado sea "1994".
     */
    @Test
    void testRomanoMCMXCIV() {
        Ejercicio3 conversor = new Ejercicio3();
        String entrada = "MCMXCIV";
        int salidaEsperada = 1994;
        assertEquals(salidaEsperada, conversor.convertirRomanoADecimal(entrada));
    }
}
