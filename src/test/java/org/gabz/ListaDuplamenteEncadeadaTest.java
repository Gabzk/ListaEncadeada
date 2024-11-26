package org.gabz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDuplamenteEncadeadaTest {

    ListaDuplamenteEncadeada<Object> lista;

    @BeforeEach
    void setUp() {
        lista = new ListaDuplamenteEncadeada<>();
    }

    @Test
    void testAddNoFinal() {

        lista.add("A");
        lista.add("B");
        lista.add("C");

        assertEquals(3, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
        assertEquals("C", lista.get(2));
    }

    @Test
    void testAddComIndice() {

        lista.add("A");
        lista.add("C");
        lista.add("B", 1); // Insere "B" na posição 1

        assertEquals(3, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
        assertEquals("C", lista.get(2));
    }

    @Test
    void testAddNoInicio() {

        lista.add(2);
        lista.add(3);
        lista.add(1, 0); // Insere 1 na posição inicial

        assertEquals(3, lista.size());
        assertEquals(1, lista.get(0));
        assertEquals(2, lista.get(1));
        assertEquals(3, lista.get(2));
    }

    @Test
    void testRemoveNoInicio() {

        lista.add("A");
        lista.add("B");
        lista.add("C");

        lista.remove(0); // Remove o primeiro nó

        assertEquals(2, lista.size());
        assertEquals("B", lista.get(0));
        assertEquals("C", lista.get(1));
    }

    @Test
    void testRemoveNoFinal() {

        lista.add("A");
        lista.add("B");
        lista.add("C");

        lista.remove(2); // Remove o último nó

        assertEquals(2, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
    }

    @Test
    void testRemoveNoMeio() {

        lista.add("A");
        lista.add("B");
        lista.add("C");

        lista.remove(1); // Remove o nó do meio

        assertEquals(2, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("C", lista.get(1));
    }

    @Test
    void testRemoveUnicoElemento() {

        lista.add("A");

        lista.remove(0); // Remove o único elemento

        assertEquals(0, lista.size());
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(0));
    }

    @Test
    void testIndiceInvalido() {

        lista.add(1);
        lista.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.add(3, 4));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(3));
    }
}