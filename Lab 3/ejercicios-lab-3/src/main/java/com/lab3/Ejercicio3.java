package com.lab3;

public class Ejercicio3 {

    public static class NodoLigado {
        int valor;
        NodoLigado siguiente;

        NodoLigado(int x) {
            valor = x;
            siguiente = null;
        }
    }

    public boolean hasCycle(NodoLigado cabeza) {
        if (cabeza == null || cabeza.siguiente == null) {
            return false;
        }

        NodoLigado i = cabeza;
        NodoLigado j = cabeza.siguiente;
        while (j != i) {
            if (j == null || j.siguiente == null) {
                return false;
            }
            i = i.siguiente;
            j = j.siguiente.siguiente;
        }
        return true;
    }
}