package com.lab3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Ejercicio3Test {

    @Test
    void testListaConCiclo() {

        Ejercicio3.NodoLigado nodo3 = new Ejercicio3.NodoLigado(3);
        Ejercicio3.NodoLigado nodo2 = new Ejercicio3.NodoLigado(2);
        Ejercicio3.NodoLigado nodo0 = new Ejercicio3.NodoLigado(0);
        Ejercicio3.NodoLigado nodo4 = new Ejercicio3.NodoLigado(-4);

        nodo3.siguiente = nodo2;
        nodo2.siguiente = nodo0;
        nodo0.siguiente = nodo4;
        nodo4.siguiente = nodo2; // Ciclo: -4 apunta de vuelta a 2

        Ejercicio3 ejercicio = new Ejercicio3();
        assertTrue(ejercicio.hasCycle(nodo3), "Debería detectar el ciclo");
    }

    @Test
    void testListaSinCiclo() {

        Ejercicio3.NodoLigado nodo1 = new Ejercicio3.NodoLigado(1);

        Ejercicio3 ejercicio = new Ejercicio3();
        assertFalse(ejercicio.hasCycle(nodo1), "No debería detectar ciclo");
    }

    @Test
    void testListaVacia() {
        Ejercicio3 ejercicio = new Ejercicio3();
        assertFalse(ejercicio.hasCycle(null), "Lista vacía no debería tener ciclo");
    }

}
