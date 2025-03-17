package com.ejercicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio4Test {

    private final Ejercicio4 ejercicio = new Ejercicio4();

    /**
     * Prueba unitaria de la conversión del número decimal 3749 a su
     * representación romana.
     * Verifica que el resultado sea "MMMDCCXLIX".
     */
    @Test
    public void testConvertirDecimalARomano_3749() {
        int entrada = 3749;
        String salidaEsperada = "MMMDCCXLIX";
        String resultado = ejercicio.convertirDecimalARomano(entrada);
        assertEquals(salidaEsperada, resultado);
    }

    /**
     * Prueba unitaria de la conversión del número decimal 58 a su
     * representación romana.
     * Verifica que el resultado sea "LVIII".
     */
    @Test
    public void testConvertirDecimalARomano_58() {
        int entrada = 58;
        String salidaEsperada = "LVIII";
        String resultado = ejercicio.convertirDecimalARomano(entrada);
        assertEquals(salidaEsperada, resultado);
    }
}
