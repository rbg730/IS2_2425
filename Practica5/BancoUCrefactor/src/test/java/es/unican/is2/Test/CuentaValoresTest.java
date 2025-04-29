package es.unican.is2.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.BancoUC.CuentaValores;
import es.unican.is2.BancoUC.Valor;

 class CuentaValoresTest {
	
	 CuentaValores sut;
	
	@BeforeEach
	 void inicializa() {
		sut = new CuentaValores("794311");
	}
	
	@Test
	 void testConstructor() {
		assertEquals("794311", sut.getNumCuenta());
		assertEquals(0, sut.getValores().size());

	}
	
	@Test
	 void testAnhadeValor() {
		// CASOS VALIDOS
		Valor v = new Valor("Telepizza", 25, 1.05);
		assertEquals(true, sut.anhadeValor(v));
		assertEquals(1, sut.getValores().size());

		assertEquals(sut.getValores().get(0), v);
		
		v = new Valor("BancoSantander", 100, 200);
		assertEquals(true, sut.anhadeValor(v));
		assertEquals(2, sut.getValores().size());

		assertEquals(sut.getValores().get(1), v);
		
		// CASOS NO VALIDOS
		assertFalse(sut.anhadeValor(new Valor("Telepizza", 10, 2.5)));
		
	}
}
