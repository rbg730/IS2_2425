package es.unican.is2.BancoUC;

public class Debito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public Debito(String numero, String titular, String cvc, CuentaAhorro cuentaAsociada) { //WMC +1
		super(numero, titular, cvc, cuentaAsociada);
		saldoDiarioDisponible = cuentaAsociada.getLimite();
	}

	@Override
	public void retirar(double x) throws SaldoInsuficienteException, DatoErroneoException { //WMC +1
		if (saldoDiarioDisponible<x) { //WMC +1 //CCgo +1
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		this.cuentaAsociada.retirar("Retirada en cajero", x);
		saldoDiarioDisponible-=x;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws SaldoInsuficienteException, DatoErroneoException { //WMC +1
		if (saldoDiarioDisponible<x) { //WMC +1 //CCgo +1
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		this.cuentaAsociada.retirar("Compra en : " + datos, x);
		saldoDiarioDisponible-=x;
	}
	
	
	
	/**
	 * Metodo invocado automaticamente a las 00:00 de cada dia
	 */
	public void restableceSaldo() { //WMC +1
		saldoDiarioDisponible = cuentaAsociada.getLimite();
	}

}