package es.unican.is2.practica3;

import java.time.LocalDate;

/**
 * Clase que representa un vehiculo de tipo motocicleta
 */
public class Motocicleta extends Vehiculo {

	private int cilindrada;

	public Motocicleta(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor, int cilindrada) {
		super(id, matricula, fechaMatriculacion, motor);
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
	

}
