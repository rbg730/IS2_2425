package es.unican.is2.BancoUC;

import java.time.LocalDate;

public abstract class Tarjeta {
	
	protected String numero, titular, cvc;		
	protected CuentaAhorro cuentaAsociada;

	public Tarjeta(String numero, String titular, String cvc,
			CuentaAhorro cuentaAsociada) { //WMC +1
		this.numero = numero;
		this.titular = titular;
		this.cvc = cvc;
		this.cuentaAsociada = cuentaAsociada;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. 
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	public abstract void retirar(double x) throws saldoInsuficienteException, datoErroneoException; //WMC +1

	/**
	 * Pago en establecimiento con la tarjeta
	 * @param datos Concepto del pago
	 * @param x Cantidada a pagar
	 * @throws saldoInsuficienteException
	 * @throws datoErroneoException
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x) //WMC +1
			throws saldoInsuficienteException, datoErroneoException;
	
	public LocalDate getCaducidad() { //WMC +1
		return this.cuentaAsociada.getCaducidad();
	}
	
	public CuentaAhorro getCuentaAsociada() { // WMC +1
		return cuentaAsociada;
	}
	
}