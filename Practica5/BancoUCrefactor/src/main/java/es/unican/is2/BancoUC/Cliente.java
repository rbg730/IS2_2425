package es.unican.is2.BancoUC;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	public String nombre;
	public String telefono;
	public Direccion direccion;
	public String dni;
	
    private List<Cuenta> Cuentas = new LinkedList<Cuenta>(); 
    
    private List<Tarjeta> tarjetas = new LinkedList<Tarjeta>(); 
 	public Cliente(String titular, Direccion direccion, 
 			String telefono, String dni) {   //WMC +1
		this.nombre = titular;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}
	
	public void cambiaDireccion(Direccion direccionCambio) { // WMC + 1 CCog 0
		this.direccion = direccionCambio;
	}
	
	public void anhadeCuenta(Cuenta c) { // WMC +1 CCgo 0
		Cuentas.add(c);
	}
	
	public void anhadeTarjeta(Tarjeta t) { // WMC +1
		tarjetas.add(t);
		t.getCuentaAsociada().setCaducidad(t.getCaducidad());
	}
	
	public double getSaldoTotal() { //WMC +1
		double total = 0.0;
		for (Cuenta c: Cuentas) { // WMC + 1  CCgo +1 
			if (c instanceof CuentaAhorro) { //WMC +1 CCgo +2
				total += ((CuentaAhorro) c).getSaldo();
			} else if (c instanceof CuentaValores)  { // WMC +1 CCgo +2
				for (Valor v: ((CuentaValores) c).getValores()) { //WMC +1 CCgo +3
					total += v.getCotizacion()*v.getNumValores();
				}
			}
		}
		return total;
	}
	
	public String getNombre() { //WMC +1
		return nombre;
	}
	
	public Direccion getDireccion() { //WMC +1
		return direccion;
	}

	public String getTelefono() { //WMC +1
		return telefono;
	}

	public String getDni() { //WMC +1
		return dni;
	}
	
	
	
}