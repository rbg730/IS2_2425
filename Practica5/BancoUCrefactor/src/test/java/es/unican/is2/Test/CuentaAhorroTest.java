package es.unican.is2.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.BancoUC.CuentaAhorro;
import es.unican.is2.BancoUC.Movimiento;
import es.unican.is2.BancoUC.DatoErroneoException;
import es.unican.is2.BancoUC.SaldoInsuficienteException;



class CuentaAhorroTest {
	private CuentaAhorro sut;
	private static Movimiento m1, m2, m3;
	
	@BeforeAll
	 static void inicializaAuxiliares() {
		m1 = new Movimiento();
		m1.setI(100);
		m1.setC("Concepto1");
		m1.setF(LocalDateTime.now());
		m2 = new Movimiento();
		m2.setI(200);
		m2.setC("Concepto2");
		m2.setF(LocalDateTime.now());
		m3 = new Movimiento();
		m3.setI(1500);
		m3.setC("Concepto3");
		m3.setF(LocalDateTime.now());
	}

	@BeforeEach
	 void inicializa() {
		sut = new CuentaAhorro("794311");
	}

	@Test
	 void testConstructor() {
		assertEquals(1000, sut.getLimite());
		assertEquals(0, sut.getMovimientos().size());
		assertEquals("794311", sut.getNumCuenta());
		assertNull(sut.getCaducidad());		
	}
	
	@Test
	 void testSetGetFechasCaducidad() {
		LocalDate today = LocalDate.now();
		sut.setCaducidad(today);
		assertEquals(today, sut.getCaducidad());	
	}
	
	@Test
	 void testGetSaldoYAddMovimiento() {
		assertEquals(0,sut.getSaldo());

		sut.addMovimiento(m1);
		assertEquals(100, sut.getSaldo());
		assertEquals(1, sut.getMovimientos().size());
		
		sut.addMovimiento(m2);
		sut.addMovimiento(m3);
		assertEquals(1800, sut.getSaldo());
		assertEquals(3, sut.getMovimientos().size());
	}
	
	@Test
	 void testRetirarSinConcepto() {
		
		try {
			sut.retirar(null, -10);
			fail("Debe lanzar DatoErroneoException");
		} catch (DatoErroneoException e) {
			 assertTrue(true); 
		} catch (SaldoInsuficienteException e) {
			fail("Debe lanzar DatoErroneoException");
		}
		
		sut.addMovimiento(m1);
		
		try {
			sut.retirar(null, 50);
			assertEquals(50, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			assertEquals("Retirada de efectivo", sut.getMovimientos().get(1).getC());
		} catch (DatoErroneoException e) {
			fail("No debe lanzar DatoErroneoException");
		} catch (SaldoInsuficienteException e) {
			fail("No debe lanzar SaldoInsuficienteException");
		}
		
		
		try {
			sut.retirar(null, 100);
			fail("Debe lanzar SaldoInsuficienteException");
		} catch (DatoErroneoException e) {
			fail("Debe lanzar SaldoInsuficienteException");
		} catch (SaldoInsuficienteException e) { 
			 assertTrue(true); 

		}
	
	}
	
	@Test
	 void testIngresarSinConcepto () {
	
		try {
			sut.ingresar(null, -1);
			fail("Debe lanzar DatoErroneoException");
		} catch (DatoErroneoException e) {
			 assertTrue(true); 

		}

		try {
			sut.ingresar(null, 0.01);
			assertEquals(0.01, sut.getSaldo());
			assertEquals(1, sut.getMovimientos().size());
			assertEquals("Ingreso en efectivo", sut.getMovimientos().get(0).getC());

			
			sut.ingresar(null, 100);
			assertEquals(100.01, sut.getSaldo(), 0.0001);
			assertEquals(2, sut.getMovimientos().size());

			
		} catch (DatoErroneoException e) {
			fail("No debe lanzar la excepci�n");
		}
		
	}
	
	
	@Test
	 void testIngresarConConcepto () {
	
		// Test ingresar negativo
		try {
			sut.ingresar("Ingreso", -1);
			fail("Debe lanzar DatoErroneoException");
		} catch (DatoErroneoException e) {
			 assertTrue(true); 

		}

		// Test ingresar el limite
		try {
			sut.ingresar("Ingreso1", 0.01);
			assertEquals(0.01, sut.getSaldo());
			assertEquals(1, sut.getMovimientos().size());
			assertEquals("Ingreso1", sut.getMovimientos().get(0).getC());

			
			sut.ingresar("Ingreso2", 100);
			assertEquals(100.01, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			assertEquals("Ingreso2", sut.getMovimientos().get(1).getC());

			
		} catch (DatoErroneoException e) {
			fail("No debe lanzar la excepci�n");
		}
		
	}
	
	@Test
	 void testRetirarConConcepto() {
		
		try {
			sut.retirar("Retirada", -10);
			fail("Debe lanzar DatoErroneoException");
		} catch (DatoErroneoException e) {
			 assertTrue(true); 

		} catch (SaldoInsuficienteException e) {
			fail("Deber�a lanzar DatoErroneoException");
		}
		
		sut.addMovimiento(m1);
		
		try {
			sut.retirar("Retirada1", 50);
			assertEquals(50, sut.getSaldo());
			assertEquals(2, sut.getMovimientos().size());
			assertEquals("Retirada1", sut.getMovimientos().get(1).getC());

		} catch (DatoErroneoException e) {
			fail("No debe lanzar DatoErroneoException");
		} catch (SaldoInsuficienteException e) {
			fail("No debe lanzar SaldoInsuficienteException");
		}
		
		
		try {
			sut.retirar("Retirada2", 100);
			fail("Debe lanzar SaldoInsuficienteException");
		} catch (DatoErroneoException e) {
			fail("Debe lanzar SaldoInsuficienteException");
		} catch (SaldoInsuficienteException e) {
			 assertTrue(true); 

			
		}
	
	}

	
}
