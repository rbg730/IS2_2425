package es.unican.is2.BancoUC;
import java.time.LocalDateTime;
import java.util.List;


public class Credito extends Tarjeta {
	
	private double creditoI;
	private List<Movimiento> movimientosMensuales;
	private List<Movimiento> historicoMovimientos;
	private static final double COMISION = 0.05;

	public Credito(String numero, String titular, String cvc,
			CuentaAhorro cuentaAsociada, double credito) { //WMC +1
		super(numero, titular, cvc, cuentaAsociada);
		this.creditoI = credito;
	}

	/**
	 * Retirada de dinero en cajero con la tarjeta
	 * @param x Cantidad a retirar. Se aplica una comisi�n del 5%.
	 * @throws SaldoInsuficienteException
	 * @throws DatoErroneoException
	 */
	@Override
	public void retirar(double x) throws SaldoInsuficienteException, DatoErroneoException { //WMC +1
		if (x<0) // WMC +1 //CCog +1
			throw new DatoErroneoException("No se puede retirar una cantidad negativa");
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Retirada en cajero");
		x += x * COMISION; // Comision por operacion con tarjetas credito
		m.setI(-x);
		
		if (getGastosAcumulados()+x > creditoI) // WMC +1 //CCog +1
			throw new SaldoInsuficienteException("Credito insuficiente");
		else { //CCog +1
			movimientosMensuales.add(m);
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws SaldoInsuficienteException, DatoErroneoException { // WMC +1
		if (x<0) // WMC +1 //CCog +1
			throw new DatoErroneoException("No se puede retirar una cantidad negativa");
		
		if (getGastosAcumulados() + x > creditoI) // WMC +1 //CCog +1
			throw new SaldoInsuficienteException("Saldo insuficiente");
		
		Movimiento m = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		m.setF(now);
		m.setC("Compra a credito en: " + datos);
		m.setI(-x);
		movimientosMensuales.add(m);
	}
	
    private double getGastosAcumulados() { // WMC +1
		double r = 0.0;
		for (int i = 0; i < this.movimientosMensuales.size(); i++) { // WMC +1 //CCog +1
			Movimiento m = movimientosMensuales.get(i);
			r += m.getI();
		}
		return r;
	}

	/**
	 * Metodo que se invoca automaticamente el dia 1 de cada mes
	 */
	public void liquidar() { // WMC +1
		Movimiento liq = new Movimiento();
		LocalDateTime now = LocalDateTime.now();
		liq.setF(now);
		liq.setC("Liquidacion de operaciones tarjeta credito");
		double r = 0.0;
		for (int i = 0; i < this.movimientosMensuales.size(); i++) { // WMC +1 //CCog +1
			Movimiento m = movimientosMensuales.get(i);
			r += m.getI();
		}
		liq.setI(-r);
	
		if (r != 0) // WMC +1 //CCog +1
			cuentaAsociada.addMovimiento(liq);
		
		historicoMovimientos.addAll(movimientosMensuales);
		movimientosMensuales.clear();
	}

	public List<Movimiento> getMovimientosMensuales() { // WMC +1
		return movimientosMensuales;
	}
	
	public List<Movimiento> getMovimientos() { // WMC +1
		return historicoMovimientos;
	}

}