package es.unican.is2.BancoUC;


public class Direccion {
	
	private String calle;
	private String zip;
	private String localidad;
	
	public Direccion(String calle, String zip, String localidad) { //WMC +1
		this.calle = calle;
		this.zip = zip;
		this.localidad = localidad;
	}

	public String getCalle() { //WMC +1
		return calle;
	}

	public String getZip() { //WMC +1
		return zip;
	}


	public String getLocalidad() { //WMC +1
		return localidad;
	}
	

}
