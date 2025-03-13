package es.unican.is2.test.vehiculo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import es.unican.is2.practica3.TipoMotor;
import es.unican.is2.practica3.Turismo;

class TurismoTest {

    @Test
    void testTurismo1() {
        Turismo t1 = new Turismo(1, "1234CDD", LocalDate.of(1999, 3, 10), TipoMotor.GASOLINA, 1);
        assertEquals(0, t1.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 0");
    }

    @Test
    void testTurismo2() {
        Turismo t2 = new Turismo(20, "1234CDD", LocalDate.of(1999, 3, 10), TipoMotor.GASOLINA, 1);
        assertEquals(0, t2.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 25");
    }

    @Test
    void testTurismo3() {
        Turismo t3 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(26), TipoMotor.GASOLINA, 1);
        assertEquals(0, t3.precioImpuesto(), "Vehículo con más de 25 años debería tener impuesto 0");
    }

    @Test
    void testTurismo4() {
        Turismo t4 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(30), TipoMotor.GASOLINA, 1);
        assertEquals(0, t4.precioImpuesto(), "Vehículo con más de 25 años debería tener impuesto 0");
    }

    @Test
    void testTurismo5() {
        Turismo t5 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(24), TipoMotor.GASOLINA, 1);
        assertEquals(25, t5.precioImpuesto(), "Vehículo de menos de 25 años con 1 de potencia debería tener impuesto 25");
    }

    @Test
    void testTurismo6() {
        Turismo t6 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(3), TipoMotor.GASOLINA, 1);
        assertEquals(25, t6.precioImpuesto(), "Vehículo de menos de 4 años con 1 de potencia debería tener impuesto 25");
    }

    @Test
    void testTurismo7() {
        Turismo t7 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(19), TipoMotor.GASOLINA, 1);
        assertEquals(25, t7.precioImpuesto(), "Vehículo de 19 años debería tener impuesto 25");
    }

    @Test
    void testTurismo8() {
        Turismo t8 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(3), TipoMotor.GASOLINA, 1);
        assertEquals(25, t8.precioImpuesto(), "Vehículo de 3 años con gasolina y 1 de potencia debería tener impuesto 25");
    }

    @Test
    void testTurismo9() {
        Turismo t9 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(2), TipoMotor.GASOLINA, 1);
        assertEquals(25, t9.precioImpuesto(), "Vehículo de 2 años con gasolina y 1 de potencia debería tener impuesto 25");
    }

    @Test
    void testTurismo10() {
        Turismo t10 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 1);
        assertEquals(25, t10.precioImpuesto(), "Vehículo con gasolina y 1 de potencia debería tener impuesto 25");
    }

    @Test
    void testTurismo11() {
        Turismo t11 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.ELECTRICO, 1);
        assertEquals(25 * 0.75, t11.precioImpuesto(), "Impuesto de eléctrico con 1 de potencia debería tener un 25% de descuento sobre 67");
    }

    @Test
    void testTurismo12() {
        Turismo t12 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.HIBRIDO, 1);
        assertEquals(25 * 0.75, t12.precioImpuesto(), "Impuesto de híbrido con 1 de potencia debería tener un 50% de descuento sobre 67");
    }

    @Test
    void testTurismo13() {
        Turismo t13 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.DIESEL, 1);
        assertEquals(25, t13.precioImpuesto(), "Impuesto de diésel con 1 de potencia debería ser 67");
    }

    @Test
    void testTurismo14() {
        Turismo t14 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GAS, 1);
        assertEquals(25 * 0.50, t14.precioImpuesto(), "Impuesto de gas con 1 de potencia debería tener un 50% de descuento sobre 67");
    }

    @Test
    void testTurismo15() {
        Turismo t15 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 1);
        assertEquals(25, t15.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 25");
    }

    @Test
    void testTurismo16() {
        Turismo t16 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 4);
        assertEquals(25, t16.precioImpuesto(), "Impuesto de gasolina con 4 de potencia debería ser 67");
    }

    @Test
    void testTurismo17() {
        Turismo t17 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 7);
        assertEquals(25, t17.precioImpuesto(), "Impuesto de gasolina con 7 de potencia debería ser 67");
    }

    @Test
    void testTurismo18() {
        Turismo t18 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 8);
        assertEquals(67, t18.precioImpuesto(), "Impuesto de gasolina con 8 de potencia debería ser 143");
    }

    @Test
    void testTurismo19() {
        Turismo t19 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 10);
        assertEquals(67, t19.precioImpuesto(), "Impuesto de gasolina con 10 de potencia debería ser 143");
    }

    @Test
    void testTurismo20() {
        Turismo t20 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 11);
        assertEquals(67, t20.precioImpuesto(), "Impuesto de gasolina con 11 de potencia debería ser 178");
    }

    @Test
    void testTurismo21() {
        Turismo t21 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 12);
        assertEquals(143, t21.precioImpuesto(), "Impuesto de gasolina con 12 de potencia debería ser 178");
    }

    @Test
    void testTurismo22() {
        Turismo t22 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 14);
        assertEquals(143, t22.precioImpuesto(), "Impuesto de gasolina con 14 de potencia debería ser 178");
    }

    @Test
    void testTurismo23() {
        Turismo t23 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 15);
        assertEquals(143, t23.precioImpuesto(), "Impuesto de gasolina con 15 de potencia debería ser 223");
    }

    @Test
    void testTurismo24() {
        Turismo t24 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 16);
        assertEquals(178, t24.precioImpuesto(), "Impuesto de gasolina con 16 de potencia debería ser 223");
    }

    @Test
    void testTurismo25() {
        Turismo t25 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 18);
        assertEquals(178, t25.precioImpuesto(), "Impuesto de gasolina con 18 de potencia debería ser 223");
    }

    @Test
    void testTurismo26() {
        Turismo t26 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 19);
        assertEquals(178, t26.precioImpuesto(), "Impuesto de gasolina con 19 de potencia debería ser 223");
    }

    @Test
    void testTurismo27() {
        Turismo t27 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 20);
        assertEquals(223, t27.precioImpuesto(), "Impuesto de gasolina con 20 de potencia debería ser 223");
    }

    @Test
    void testTurismo28() {
        Turismo t28 = new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 200);
        assertEquals(223, t28.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 223");
    }

    @Test
    void testTurismo44() {
        // Intentar crear un Turismo con matrícula reciente debería lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, "1234CDD", LocalDate.of(2026, 3, 10), TipoMotor.GASOLINA, 1);
        });
    }


    @Test
    void testTipoMotorNoValido() {
        // Verifica que al pasar un tipo de motor no válido, se lanza una excepción
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, "1234CDD", LocalDate.now(), null, 1); // TipoMotor nulo
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, "1234CDD", LocalDate.now(), TipoMotor.valueOf("TRISCON"), 1); // TipoMotor no válido
        });
    }
    @Test
    void testTurismo46() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, -1);
        });
    }









}
