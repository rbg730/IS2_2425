package es.unican.is2.test.vehiculo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import es.unican.is2.COMMON.Motocicleta;
import es.unican.is2.COMMON.TipoMotor;

import java.time.LocalDate;

public class MotocicletaTest {

	 @Test
	    void testMoto1() {
	        Motocicleta m1 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 1);
	        assertEquals(8, m1.precioImpuesto(), "Impuesto de con cilindrada 1 ser 8");
	    }
	 
	 @Test
	    void testMoto2() {
	        Motocicleta m2 = new Motocicleta(30, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 80);
	        assertEquals(8, m2.precioImpuesto(), "Impuesto de con cilindrada 80 ser 8");
	    }
	 
	 @Test
	    void testMoto3() {
	        Motocicleta m3 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 124);
	        assertEquals(8, m3.precioImpuesto(), "Impuesto de con cilindrada 124 ser 8");
	    }
	 
	 @Test
	    void testMoto4() {
	        Motocicleta m1 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 125);
	        assertEquals(15, m1.precioImpuesto(), "Impuesto de con cilindrada 125 ser 15");
	    }
	 
	 @Test
	    void testMoto5() {
	        Motocicleta m5 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 222);
	        assertEquals(15, m5.precioImpuesto(), "Impuesto de con cilindrada 222 ser 15");
	    }
	 
	 @Test
	    void testMoto6() {
	        Motocicleta m6 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 249);
	        assertEquals(15, m6.precioImpuesto(), "Impuesto de con cilindrada 249 ser 15");
	    }
	 
	 @Test
	    void testMoto7() {
	        Motocicleta m7 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 250);
	        assertEquals(30, m7.precioImpuesto(), "Impuesto de con cilindrada 250 ser 30");
	    }
	 
	 @Test
	    void testMoto8() {
	        Motocicleta m8 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 300);
	        assertEquals(30, m8.precioImpuesto(), "Impuesto de con cilindrada 300 ser 30");
	    }
	 
	 @Test
	    void testMoto9() {
	        Motocicleta m9 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 499);
	        assertEquals(30, m9.precioImpuesto(), "Impuesto de con cilindrada 499 ser 30");
	    }
	 
	 @Test
	    void testMoto10() {
	        Motocicleta m10 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 500);
	        assertEquals(60, m10.precioImpuesto(), "Impuesto de con cilindrada 500 ser 60");
	    }
	 
	 @Test
	    void testMoto11() {
	        Motocicleta m11 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 750);
	        assertEquals(60, m11.precioImpuesto(), "Impuesto de con cilindrada 750 ser 60");
	    }
	 
	 @Test
	    void testMoto12() {
	        Motocicleta m12 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 750);
	        assertEquals(60, m12.precioImpuesto(), "Impuesto de con cilindrada 750 ser 60");
	    }
	 
	 @Test
	    void testMoto13() {
	        Motocicleta m13 = new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 1000);
	        assertEquals(120, m13.precioImpuesto(), "Impuesto de con cilindrada 1000 ser 120");
	    }
	 
	 @Test
	    void testMoto14() {
	        Motocicleta m14 = new Motocicleta(1, "1234CDD", LocalDate.of(1999, 3, 10), TipoMotor.GASOLINA, 1000);
	        assertEquals(0, m14.precioImpuesto(), "Impuesto de con 25 años deberia ser 0");
	    }
	 
	 @Test
	    void testMoto15() {
	        Motocicleta m15 = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(4), TipoMotor.HIBRIDO, 1000);
	        assertEquals(120 * 0.75, m15.precioImpuesto(), "Impuesto de con 4 años HIBRIDO deberia ser 90");
	    }
	 
	 @Test
	    void testMoto16() {
	        Motocicleta m16 = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(1), TipoMotor.GAS, 1000);
	        assertEquals(120 * 0.5, m16.precioImpuesto(), "Impuesto de con 1 años GAS deberia ser 0");
	    }
	 
	 @Test
	    void testMoto17() {
	        Motocicleta m17 = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(24), TipoMotor.ELECTRICO, 1000);
	        assertEquals(120 * 0.75, m17.precioImpuesto(), "Impuesto de con 24 años HIBRIDO deberia ser 90");
	    }
	 
	 @Test
	    void testMoto18() {
	        Motocicleta m18 = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(3), TipoMotor.GASOLINA, 1000);
	        assertEquals(120, m18.precioImpuesto(), "Impuesto de con cilindrada 1000 ser 120");
	    }
	 
	 @Test
	    void testMoto19() {
	        Motocicleta m19 = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(2), TipoMotor.DIESEL, 1000);
	        assertEquals(120, m19.precioImpuesto(), "Impuesto de con cilindrada 1000 ser 120");
	    }
	 
	 
	 

    @Test
    void testIdInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(-3, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, 500);
        });
    }

    @Test
    void testMatriculaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(1, "1234AEE", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, 500);
        });
    }

    @Test
    void testFechaFutura() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(1, "1234CDD", LocalDate.now().plusDays(1), TipoMotor.GASOLINA, 500);
        });
    }
    @Test
    void testCilindradaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, -1);
        });
    }
    
    @Test
    void testTipoMotorNoValido() {
        // Verifica que al pasar un tipo de motor no válido, se lanza una excepción
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(1, "1234CDD", LocalDate.now(), null, 1); // TipoMotor nulo
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(1, "1234CDD", LocalDate.now(), TipoMotor.valueOf("AEROPLANO"), 1); // TipoMotor no válido
        });
    }
}

