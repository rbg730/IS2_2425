package es.unican.is2.BancoUC;

@SuppressWarnings("serial")
public class DatoErroneoException extends RuntimeException {

	public DatoErroneoException (String mensaje) {
		super(mensaje);
	}
}
