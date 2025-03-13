package es.unican.is2.test.vehiculo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import es.unican.is2.practica3.TipoMotor;
import es.unican.is2.practica3.Turismo;

class TurismoTest {

    @Test
    void testPrecioImpuesto() {
    	
    	
        Turismo t1 = new Turismo(1, "1234ABC", LocalDate.now(), TipoMotor.GASOLINA, 7.9);
        assertEquals(25, t1.precioImpuesto());

        Turismo t2 = new Turismo(2, "5678DEF", LocalDate.now(), TipoMotor.GASOLINA, 8);
        assertEquals(75, t2.precioImpuesto());

        Turismo t3 = new Turismo(3, "9012GHI", LocalDate.now(), TipoMotor.GASOLINA, 12);
        assertEquals(143, t3.precioImpuesto());

        Turismo t4 = new Turismo(4, "3456JKL", LocalDate.now(), TipoMotor.GASOLINA, 16);
        assertEquals(178, t4.precioImpuesto());

        Turismo t5 = new Turismo(5, "7890MNO", LocalDate.now(), TipoMotor.GASOLINA, 20);
        assertEquals(223, t5.precioImpuesto());
    }

    @Test
    void testPrecioImpuesto_Electrico() {
        Turismo t6 = new Turismo(6, "1357PQR", LocalDate.now(), TipoMotor.ELECTRICO, 10);
        assertEquals(75, TipoMotor.ELECTRICO.descuentoImpuesto, t6.precioImpuesto());
    }

    @Test
    void testPrecioImpuesto_DescuentoPorAntiguedad() {
        Turismo t7 = new Turismo(7, "2468STU", LocalDate.now().minusYears(26), TipoMotor.GASOLINA, 15);
        assertEquals(0, t7.precioImpuesto());
    }
}
