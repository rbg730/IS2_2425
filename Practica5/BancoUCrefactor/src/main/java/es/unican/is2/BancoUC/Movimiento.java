package es.unican.is2.BancoUC;

import java.time.LocalDateTime;
import java.util.Objects;

public class Movimiento {
	private String concepto;
	private LocalDateTime fecha;
	private double importe;

	public double getI() { //WMC +1
		return importe;
	}

	public void setI(double newMImporte) { //WMC +1
		importe = newMImporte;
	}
	
	public String getC() { //WMC +1
		return concepto;
	}

	public void setC(String newMConcepto) { //WMC +1
		concepto = newMConcepto;
	}

	public LocalDateTime getF() { //WMC +1
		return fecha;
	}

	public void setF(LocalDateTime newMFecha) { //WMC +1
		fecha = newMFecha;
	}

	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Movimiento)) return false;

	    Movimiento other = (Movimiento) obj;
	    return Double.compare(other.importe, importe) == 0 &&
	           java.util.Objects.equals(concepto, other.concepto) &&
	           java.util.Objects.equals(fecha, other.fecha);
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(concepto, fecha, importe);
    }
	
}