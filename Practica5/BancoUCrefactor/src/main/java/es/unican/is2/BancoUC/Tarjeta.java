package es.unican.is2.BancoUC;

import java.time.LocalDate;

public abstract class Tarjeta {
	
	protected String numero;		
	protected String  titular;
	protected String  cvc;
	protected CuentaAhorro cuentaAsociada;

	protected Tarjeta(String numero, String titular, String cvc,
			CuentaAhorro cuentaAsociada) { //WMC +1
		this.numero = numero;
		this.titular = titular;
		this.cvc = cvc;
		this.cuentaAsociada = cuentaAsociada;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. 
	 * @throws SaldoInsuficienteException
	 * @throws DatoErroneoException
	 */
	public abstract void retirar(double x) throws SaldoInsuficienteException, DatoErroneoException; //WMC +1

	/**
	 * Pago en establecimiento con la tarjeta
	 * @param datos Concepto del pago
	 * @param x Cantidada a pagar
	 * @throws SaldoInsuficienteException
	 * @throws DatoErroneoException
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x) //WMC +1
			throws SaldoInsuficienteException, DatoErroneoException;
	
	public LocalDate getCaducidad() { //WMC +1
		return this.cuentaAsociada.getCaducidad();
	}
	
	public CuentaAhorro getCuentaAsociada() { // WMC +1
		return cuentaAsociada;
	}
	
}