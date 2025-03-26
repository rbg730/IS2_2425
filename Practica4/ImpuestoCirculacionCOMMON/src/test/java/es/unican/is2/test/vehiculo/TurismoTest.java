package es.unican.is2.test.vehiculo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import es.unican.is2.COMMON.TipoMotor;
import es.unican.is2.COMMON.Turismo;

import java.time.LocalDate;

class TurismoTest {

    @Test
    void testTurismo1() {
        Turismo t1 = new Turismo(1, "1234CDD", LocalDate.of(1999, 3, 10), TipoMotor.GASOLINA, 1);
        assertEquals(0, t1.precioImpuesto(), "Impuesto de con 25 años deberia ser 0");
    }
    
    @Test
    void testTurismo2() {
        Turismo t2 = new Turismo(1, "1234CDD", LocalDate.now().minusYears(30), TipoMotor.DIESEL, 1);
        assertEquals(0, t2.precioImpuesto(), "Vehículo con más de 25 años debería tener impuesto 0");
    }
    
    @Test
    void testTurismo3() {
        Turismo t3 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 1);
        assertEquals(25, t3.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 25");
    }
    
    @Test
    void testTurismo4() {
        Turismo t4 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 4);
        assertEquals(25, t4.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 25");
    }
    
    @Test
    void testTurismo5() {
        Turismo t5 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 7);
        assertEquals(25, t5.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 25");
    }
    @Test
    void testTurismo6() {
        Turismo t6 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 8);
        assertEquals(67, t6.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 67");
    }
    
    @Test
    void testTurismo7() {
        Turismo t7 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 10);
        assertEquals(67, t7.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 67");
    }
    
    @Test
    void testTurismo8() {
        Turismo t8 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 11);
        assertEquals(67, t8.precioImpuesto(), "Impuesto de gasolina con 1 de potencia debería ser 67");
    }
    
    @Test
    void testTurismo9() {
        Turismo t9 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 12);
        assertEquals(143, t9.precioImpuesto(), "Impuesto de gasolina con 12 de potencia debería ser 143");
    }
    
    @Test
    void testTurismo10() {
        Turismo t10 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 14);
        assertEquals(143, t10.precioImpuesto(), "Impuesto de gasolina con 14 de potencia debería ser 143");
    }
    
    @Test
    void testTurismo11() {
        Turismo t11 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 15);
        assertEquals(143, t11.precioImpuesto(), "Impuesto de gasolina con 15 de potencia debería ser 143");
    }
    
    @Test
    void testTurismo12() {
        Turismo t12 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 16);
        assertEquals(178, t12.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 178");
    }
    
    @Test
    void testTurismo13() {
        Turismo t13 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 18);
        assertEquals(178, t13.precioImpuesto(), "Impuesto de gasolina con 18 de potencia debería ser 178");
    }
    
    @Test
    void testTurismo14() {
        Turismo t14 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 19);
        assertEquals(178, t14.precioImpuesto(), "Impuesto de gasolina con 19 de potencia debería ser 178");
    }
    
    @Test
    void testTurismo15() {
        Turismo t15 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 20);
        assertEquals(223, t15.precioImpuesto(), "Impuesto de gasolina con 20 de potencia debería ser 223");
    }
    
    @Test
    void testTurismo16() {
        Turismo t16 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.GASOLINA, 200);
        assertEquals(223, t16.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 223");
    }
    
    @Test
    void testTurismo17() {
        Turismo t17 = new Turismo(20, "1234CDD", LocalDate.now(), TipoMotor.ELECTRICO, 200);
        assertEquals(223 * 0.75, t17.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 167.25");
    }
    
    @Test
    void testTurismo18() {
        Turismo t18 = new Turismo(20, "1234CDD", LocalDate.now().minusYears(4), TipoMotor.HIBRIDO, 200);
        assertEquals(223 * 0.75, t18.precioImpuesto(), "Impuesto de hIBRIDO con 200 de potencia debería ser 167.25");
    }
    
    @Test
    void testTurismo19() {
        Turismo t19 = new Turismo(20, "1234CDD", LocalDate.now().minusYears(1), TipoMotor.GAS, 200);
        assertEquals(223 * 0.5, t19.precioImpuesto(), "Impuesto de GAS con 200 de potencia debería ser 111,5");
    }
    
    @Test
    void testTurismo20() {
        Turismo t20 = new Turismo(20, "1234CDD", LocalDate.now().minusYears(24), TipoMotor.GASOLINA, 200);
        assertEquals(223, t20.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 223");
    }
    
    @Test
    void testTurismo21() {
        Turismo t21 = new Turismo(20, "1234CDD", LocalDate.now().minusYears(3), TipoMotor.GASOLINA, 200);
        assertEquals(223, t21.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 223");
    }
    
    @Test
    void testTurismo22() {
        Turismo t22 = new Turismo(20, "1234CDD", LocalDate.now().minusYears(2), TipoMotor.GASOLINA, 200);
        assertEquals(223, t22.precioImpuesto(), "Impuesto de gasolina con 200 de potencia debería ser 223");
    }
    


    

    @Test
    void testTurismoMatriculaFutura() {
        // Intentar crear un Turismo con matrícula del futuro debería lanzar una excepción
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
            new Turismo(1, "1234CDD", LocalDate.now(), TipoMotor.valueOf("AEROPLANO"), 1); // TipoMotor no válido
        });
    }
    
    @Test
    void testTurismoPotenciaNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, -1);
        });
    }
    
    @Test
    void testTurismoIdNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(-3, "1234CDD", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 1);
        });
    }
    
    @Test
    void testMatriculaNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, null, LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 1);
        });
    }

    @Test
    void testTurismoMatriculaMal() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Turismo(1, "AAA", LocalDate.of(2020, 3, 10), TipoMotor.GASOLINA, 1);
        });
    }











}
