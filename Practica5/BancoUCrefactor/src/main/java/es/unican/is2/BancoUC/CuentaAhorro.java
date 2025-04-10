package es.unican.is2.BancoUC;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class CuentaAhorro extends Cuenta {

	private List<Movimiento> Movimientos;
	private LocalDate caducidadTarjeta;
	private double limiteDebito;

	public CuentaAhorro(String numCuenta)  throws datoErroneoException { //WMC +1
		super(numCuenta);
		Movimientos = new LinkedList<Movimiento>();
		limiteDebito = 1000;
	}

	

	public void ingresar(String concepto, double x) throws datoErroneoException { //WMC + 1
		if (x <= 0) //WMC + 1 //CCog +1
			throw new datoErroneoException("No se puede ingresar una cantidad negativa");
		if (concepto == null) { //WMC + 1 //CCog +1
			concepto = "Ingreso en efectivo";
		}
		realizaMovimiento(concepto, x);
	}

	public void retirar(String concepto, double x) throws saldoInsuficienteException, datoErroneoException { //WMC + 1
		if (getSaldo() < x) //WMC + 1 //CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		if (x <= 0) //WMC + 1 //CCog +1
			throw new datoErroneoException("No se puede retirar una cantidad negativa");
		
		if (concepto == null) { //WMC + 1 //CCog +1
			concepto = "Retirada de efectivo";
		}
		realizaMovimiento(concepto, -x);
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

	public void setCaducidad(LocalDate caducidadTarjeta) { //WMC + 1
		this.caducidadTarjeta = caducidadTarjeta;
	}

	public LocalDate getCaducidad() { //WMC + 1
		return caducidadTarjeta;
	}

	public double getLimite() { //WMC + 1
		return limiteDebito;
	}
	
	public void realizaMovimiento(String concepto, double Cantidad) { //WMC + 1
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC(concepto);
		m.setI(Cantidad);
		this.Movimientos.add(m);
		
		
	}

}