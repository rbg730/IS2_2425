package es.unican.is2.practica3;

import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo motocicleta
 */
public class Motocicleta extends Vehiculo {

	private int cilindrada;

	public Motocicleta(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, int cilindrada) {
		super(id, matricula, fechaMatriculacion, motor);

		// Validación de ID (debe ser mayor que 0)
		if (id <= 0) {
			throw new IllegalArgumentException("El ID debe ser mayor que 0");
		}

		// Validación de matrícula (Ejemplo válido: "1234BCD", inválido: "1234AEE")
		if (!matricula.matches("\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}")) {
			throw new IllegalArgumentException("Matrícula inválida: " + matricula);
		}

		// Validación de fecha de matriculación no futura
		if (fechaMatriculacion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de matriculación no puede ser futura");
		}

		// Validación del tipo de motor
		if (motor == null || !esTipoMotorValido(motor)) {
			throw new IllegalArgumentException("El tipo de motor no es válido: " + motor);
		}

		// Validación de cilindrada
		if (cilindrada <= 0) {
			throw new IllegalArgumentException("La cilindrada no puede ser negativa o 0.");
		}

		this.cilindrada = cilindrada;
	}


	/**
	 * Retorna la cilindrada en CC de la motocicleta.
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	@Override
	public double precioImpuesto() {
double impuesto = 0;
		
		if (this.cilindrada < 125) {
			impuesto = 8;
		} else if (this.cilindrada >= 125 && this.cilindrada < 250) {
			impuesto = 15;
		} else if (this.cilindrada >= 250 && this.cilindrada < 500) {
			impuesto = 30;
		} else if (this.cilindrada >= 500 && this.cilindrada < 1000) {
			impuesto = 60;
		} else if (this.cilindrada >= 1000) {
			impuesto = 120;
		}
		
		if (getFechaMatriculacion().isBefore(LocalDate.now().minusYears((25)))) {
			impuesto = 0;
		}
		if (getMotor() == TipoMotor.ELECTRICO) {
			impuesto = impuesto * getMotor().descuentoImpuesto;
		}
		if (getFechaMatriculacion().isBefore(LocalDate.now().minusYears(4)) && getMotor() == TipoMotor.HIBRIDO) {
			impuesto = impuesto * 0.75;
		}
		if (getFechaMatriculacion().isBefore(LocalDate.now().minusYears(1)) && getMotor() == TipoMotor.GAS) {
			impuesto = impuesto * getMotor().descuentoImpuesto;
		}
		return impuesto;
	}
	
	private boolean esTipoMotorValido(TipoMotor motor) {
		try {
			TipoMotor.valueOf(motor.name());  // Si el tipo de motor es válido, no lanza excepción
			return true;
		} catch (IllegalArgumentException e) {
			return false;  // Si el tipo de motor no es válido, lanza una excepción
		}
	}

}
