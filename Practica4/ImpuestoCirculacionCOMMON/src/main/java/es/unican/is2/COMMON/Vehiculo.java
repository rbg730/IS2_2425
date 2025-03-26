package es.unican.is2.COMMON;


import java.time.LocalDate;

/**
 * Clase abstracta que representa un vehiculo. 
 * Cada vehiculo tiene una matricula unica.
 */
public abstract class Vehiculo {

	// Clave primaria autogenerada
	private long id;

	private String matricula;
	private LocalDate fechaMatriculacion;
	private TipoMotor motor;

	// TODO
	public Vehiculo(long id, String matricula, LocalDate fechaMatriculacion, TipoMotor motor) {
		
		if (id < 0) {
	        throw new IllegalArgumentException("El ID no puede ser negativo");
	    }
		
		if (matricula == null || matricula.length() != 7) {
	        throw new IllegalArgumentException("La matrícula debe tener exactamente 7 caracteres");
	    }
		
		this.id = id;
		this.matricula = matricula;
		this.fechaMatriculacion = fechaMatriculacion;
		this.motor = motor;
	}

	/**
	 * Retorna la matricula del vehiculo.
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorna la fecha de primera matriculacion del vehiculo.
	 */
	public LocalDate getFechaMatriculacion() {
		return fechaMatriculacion;
	}

	/**
	 * Retorna el tipo de motor del vehiculo.
	 */
	public TipoMotor getMotor() {
		return motor;
	}

	/**
	 * Retorna el identificador del vehiculo.
	 */
	public long getId() {
		return id;
	}

	// TODO
	public abstract double precioImpuesto();

}
