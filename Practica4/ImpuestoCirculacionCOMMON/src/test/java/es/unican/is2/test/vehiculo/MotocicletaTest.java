package es.unican.is2.test.vehiculo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import es.unican.is2.practica3.TipoMotor;
import es.unican.is2.practica3.Motocicleta;

public class MotocicletaTest {

    @Test
    void testMotocicletaValida() {
        Motocicleta moto = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, 500);
        assertEquals(60, moto.precioImpuesto());
    }

    @Test
    void testIdInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(0, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, 500);
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
    void testExentaImpuestoPorAntiguedad() {
        Motocicleta moto = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(26), TipoMotor.GASOLINA, 500);
        assertEquals(0, moto.precioImpuesto());
    }

    @Test
    void testMotorElectrico() {
        Motocicleta moto = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.ELECTRICO, 500);
        assertEquals(60 * TipoMotor.ELECTRICO.descuentoImpuesto, moto.precioImpuesto());
    }

    @Test
    void testMotorHibridoConDescuento() {
        Motocicleta moto = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.HIBRIDO, 500);
        assertEquals(60 * 0.75, moto.precioImpuesto());
    }

    @Test
    void testCilindradaAlta() {
        Motocicleta moto = new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, 1250);
        assertEquals(120, moto.precioImpuesto());
    }

    @Test
    void testCilindradaInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Motocicleta(1, "1234CDD", LocalDate.now().minusYears(5), TipoMotor.GASOLINA, -50);
        });
    }
}

