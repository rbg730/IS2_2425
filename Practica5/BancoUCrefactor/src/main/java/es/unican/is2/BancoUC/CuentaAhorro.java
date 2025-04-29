package es.unican.is2.BancoUC;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> movimientos;
	private LocalDate caducidadTarjeta;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta)  throws DatoErroneoException { //WMC +1
		super(numCuenta);
		movimientos = new LinkedList<>();
		limiteDebito = 1000;
	}

	

	public void ingresar(String concepto, double x) throws DatoErroneoException { //WMC + 1
		if (x <= 0) //WMC + 1 //CCog +1
			throw new DatoErroneoException("No se puede ingresar una cantidad negativa");
		if (concepto == null) { //WMC + 1 //CCog +1
			concepto = "Ingreso en efectivo";
		}
		realizaMovimiento(concepto, x);
	}

	public void retirar(String concepto, double x) throws SaldoInsuficienteException, DatoErroneoException { //WMC + 1
		if (getSaldo() < x) //WMC + 1 //CCog +1
			throw new SaldoInsuficienteException("Saldo insuficiente");
		if (x <= 0) //WMC + 1 //CCog +1
			throw new DatoErroneoException("No se puede retirar una cantidad negativa");
		
		if (concepto == null) { //WMC + 1 //CCog +1
			concepto = "Retirada de efectivo";
		}
		realizaMovimiento(concepto, -x);
	}

	public double getSaldo() { //WMC + 1
		double r = 0.0;
		for (int i = 0; i < this.movimientos.size(); i++) { //WMC + 1 //CCog +1
			Movimiento m = movimientos.get(i);
			r += m.getI();
		}
		return r;
	}

	public void addMovimiento(Movimiento m) { //WMC + 1
		movimientos.add(m);
	}

	public List<Movimiento> getMovimientos() { //WMC + 1
		return movimientos;
	}

	public void setCaducidad(LocalDate caducidadTarjeta) { //WMC + 1
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public LocalDate getCaducidad() { //WMC + 1
		return caducidadTarjeta;
	}

	public double getLimite() { //WMC + 1
		return limiteDebito;
	}
	
	public void realizaMovimiento(String concepto, double cantidad) { //WMC + 1
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(cantidad);
		this.movimientos.add(m);
		
		
	}

}