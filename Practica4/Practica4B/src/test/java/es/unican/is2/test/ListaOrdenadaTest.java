package es.unican.is2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import es.unican.is2.Abstract.ListaOrdenada;
import es.unican.is2.adt.IListaOrdenada;

public class ListaOrdenadaTest {
	private IListaOrdenada<Integer> lista;
	
	@BeforeEach
	void setUp() {
		lista = new ListaOrdenada<Integer>();
	}
	
	@Test
	void testAdd() {
		
		lista.add(7);
		assertEquals(1, lista.size());
		assertEquals(7,lista.get(0));
		
		lista.add(10);
		assertEquals(2, lista.size());
		assertEquals(10,lista.get(1));
		
		lista.add(1);
		assertEquals(3, lista.size());
		assertEquals(1,lista.get(0));
		
		lista.add(5);
		assertEquals(4, lista.size());
		assertEquals(5,lista.get(1));
		
		lista.add(5);
		assertEquals(5, lista.size());
		
		assertEquals(1,lista.get(0));
		assertEquals(5,lista.get(1));
		assertEquals(5,lista.get(2));
		assertEquals(7,lista.get(3));
		assertEquals(10,lista.get(4));
		
		assertThrows(NullPointerException.class, () -> lista.add(null));
}
	@Test
	void testGet() {
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);
		lista.add(50);
		lista.add(60);
		lista.add(70);
		lista.add(80);
		lista.add(90);
		lista.add(100);
		lista.add(110);
		lista.add(120);
		
		assertEquals(12,lista.size());

		assertEquals(10,lista.get(0));
		assertEquals(50,lista.get(4));
		assertEquals(120,lista.get(11));
		
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.get(12));
	}
	
	@Test
	void testRemove() {
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);
		lista.add(50);
		lista.add(60);
		lista.add(70);
		lista.add(80);
		lista.add(90);
		lista.add(100);
		lista.add(110);
		lista.add(120);
		
		assertEquals(12,lista.size());
		
		assertEquals(10,lista.remove(0));
		assertEquals(11,lista.size());
		assertEquals(20,lista.get(0));
		
		assertEquals(50,lista.remove(3));
		assertEquals(10,lista.size());
		assertEquals(60,lista.get(3));
		
		assertEquals(120,lista.remove(lista.size()-1));
		assertEquals(9,lista.size());
		assertEquals(110,lista.get(lista.size()-1));
		
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> lista.remove(12));
		
		
		
	}
	
	@Test
	void testSize() {
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);
		lista.add(50);
		lista.add(60);
		lista.add(70);
		lista.add(80);
		lista.add(90);
		lista.add(100);
		lista.add(110);
		lista.add(120);
		
		assertEquals(12,lista.size());
		
	}
	@Test
	void testClear() {
		lista.add(10);
		lista.add(20);
		lista.add(30);
		lista.add(40);
		lista.add(50);
		lista.add(60);
		lista.add(70);
		lista.add(80);
		lista.add(90);
		lista.add(100);
		lista.add(110);
		lista.add(120);
		
		lista.clear();
		
		assertEquals(0,lista.size());
		
	}

}
