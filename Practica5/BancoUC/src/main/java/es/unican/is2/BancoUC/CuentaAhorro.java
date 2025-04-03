package es.unican.is2.BancoUC;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> Movimientos;
	private LocalDate caducidadDebito;
	private LocalDate caducidadCredito;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta)  throws datoErroneoException { //WMC +1
		super(numCuenta);
		Movimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	public void ingresar(double x) throws datoErroneoException { //WMC + 1
		if (x <= 0) //WMC + 1 //CCog +1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Ingreso en efectivo");
		m.setI(x);
		this.Movimientos.add(m);
	}

	public void retirar(double x) throws saldoInsuficienteException, datoErroneoException { //WMC + 1
		if (x <= 0) //WMC + 1 //CCog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		if (getSaldo() < x) //WMC + 1 //CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Retirada de efectivo");
		m.setI(-x);
		this.Movimientos.add(m);
	}

	public void ingresar(String concepto, double x) throws datoErroneoException { //WMC + 1
		if (x <= 0) //WMC + 1 //CCog +1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(x);
		this.Movimientos.add(m);
	}

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException { //WMC + 1
		if (getSaldo() < x) //WMC + 1 //CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0) //WMC + 1 //CCog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(-x);
		this.Movimientos.add(m);
	}

	public double getSaldo() { //WMC + 1
		double r = 0.0;
		for (int i = 0; i < this.Movimientos.size(); i++) { //WMC + 1 //CCog +1
			Movimiento m = (Movimiento) Movimientos.get(i);
			r += m.getI();
		}
		return r;
	}

	public void addMovimiento(Movimiento m) { //WMC + 1
		Movimientos.add(m);
	}

	public List<Movimiento> getMovimientos() { //WMC + 1
		return Movimientos;
	}

	public LocalDate getCaducidadDebito() { //WMC + 1
		return caducidadDebito;
	}

	public void setCaducidadDebito(LocalDate caducidadDebito) { //WMC + 1
		this.caducidadDebito = caducidadDebito;
	}

	public LocalDate getCaducidadCredito() { //WMC + 1
		return caducidadCredito;
	}

	public void setCaducidadCredito(LocalDate caducidadCredito) { //WMC + 1
		this.caducidadCredito = caducidadCredito;
	}

	public double getLimiteDebito() { //WMC + 1
		return limiteDebito;
	}

}