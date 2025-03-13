package es.unican.is2.practica3;

import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo turismo.
 */
public class Turismo extends Vehiculo {

	private double potencia;
	
	public Turismo(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, double potencia) {
		super(id, matricula, fechaMatriculacion, motor);

		// Validación de fecha de matriculación no futura
		if (fechaMatriculacion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("La fecha de matriculación no puede ser futura");
		}

		if (motor == null || !esTipoMotorValido(motor)) {
			throw new IllegalArgumentException("El tipo de motor no es valido: " + motor);
		}

		if (potencia <= 0) {
			throw new IllegalArgumentException("La potencia no puede ser negativa o 0.");
		}

		this.potencia = potencia;
	}

	/**
	 * Retorna la potencia en caballos fiscales del vehiculo.
	 */
	public double getPotencia() {
		return potencia;
	}

	@Override
	public double precioImpuesto() {
		double impuesto = 0;
		
		if (this.potencia < 8) {
			impuesto = 25;
		} else if (this.potencia >= 8 && this.potencia < 12) {
			impuesto = 67;
		} else if (this.potencia >= 12 && this.potencia < 16) {
			impuesto = 143;
		} else if (this.potencia >= 16 && this.potencia < 20) {
			impuesto = 178;
		} else if (this.potencia >= 20) {
			impuesto = 223;
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
