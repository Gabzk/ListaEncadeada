package org.gabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaEncadeadaTest {

    @Test
    void testAdd() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        assertEquals(3, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
        assertEquals("C", lista.get(2));
    }

    @Test
    void testRemoveInicio() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        String removido = lista.remove(0);

        assertEquals("A", removido);
        assertEquals(2, lista.size());
        assertEquals("B", lista.get(0));
        assertEquals("C", lista.get(1));
    }

    @Test
    void testRemoveMeio() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        String removido = lista.remove(1);

        assertEquals("B", removido);
        assertEquals(2, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("C", lista.get(1));
    }

    @Test
    void testRemoveFinal() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        String removido = lista.remove(2);

        assertEquals("C", removido);
        assertEquals(2, lista.size());
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
    }

    @Test
    void testRemoveUnicoElemento() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.add("A");

        String removido = lista.remove(0);

        assertEquals("A", removido);
        assertEquals(0, lista.size());
        assertTrue(lista.isEmpty());
    }

    @Test
    void testIsEmpty() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        assertTrue(lista.isEmpty());

        lista.add(1);

        assertFalse(lista.isEmpty());
    }

    @Test
    void testGet() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.add(10);
        lista.add(20);
        lista.add(30);

        assertEquals(10, lista.get(0));
        assertEquals(20, lista.get(1));
        assertEquals(30, lista.get(2));
    }

    @Test
    void testToString() {
        ListaEncadeada<String> lista = new ListaEncadeada<>();
        lista.add("A");
        lista.add("B");
        lista.add("C");

        String esperado = "No {Conteudo = A} ->\n" +
                "No {Conteudo = B} ->\n" +
                "No {Conteudo = C} ->\n" +
                "null";

        assertEquals(esperado, lista.toString());
    }

    @Test
    void testIndiceInvalido() {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.add(1);
        lista.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(3));
    }
}
