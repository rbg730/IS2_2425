
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	public IContribuyentesDAO contribuyenteDAO;
	public IVehiculosDAO vehiculoDAO;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentesDAO, IVehiculosDAO vehiculosDao) {
		this.contribuyenteDAO = contribuyentesDAO;
		this.vehiculoDAO = vehiculosDao;
		
	}
	
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		Vehiculo vehiculo = vehiculoDAO.vehiculoPorMatricula(matricula);
		if (vehiculo == null) {
			throw new DataAccessException();
		}
		return vehiculo;
	}


	public Contribuyente contribuyente(String dni) throws DataAccessException {
		Contribuyente contribuyente = contribuyenteDAO.contribuyente(dni);
		if (contribuyente == null) {
			throw new DataAccessException();
		}
		return contribuyente;
	}


	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyente(dni);
		if (contribuyente.buscaVehiculo(v.getMatricula()) != null) {
			throw new OperacionNoValidaException("vehiculo ya dado de alta");
		}
		contribuyente.getVehiculos().add(v);
		this.vehiculoDAO.vehiculos().add(v);
		return v;
	}


	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyente(dni);
		Vehiculo vehiculo = contribuyente.buscaVehiculo(matricula);
		if (vehiculo == null) {
			throw new OperacionNoValidaException("vehiculo no encontrado");
		}
		contribuyente.getVehiculos().remove(vehiculo);
		this.vehiculoDAO.vehiculos().remove(vehiculo);
		
		return vehiculo;
	}


	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo)
			throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente1 = contribuyente(dniActual);
		Contribuyente contribuyente2 = contribuyente(dniNuevo);
		Vehiculo vehiculo = contribuyente1.buscaVehiculo(matricula);
		
		if (vehiculo == null) {
			throw new OperacionNoValidaException("vehiculo no encontrado");
		}
		contribuyente1.getVehiculos().remove(vehiculo);
		contribuyente2.getVehiculos().add(vehiculo);
		return true;
	}


	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
		
		Contribuyente contribuyente = this.contribuyenteDAO.contribuyente(c.getDni());
		if (contribuyente != null) {
			return null;
		}
		this.contribuyenteDAO.contribuyentes().add(c);
		return c;
	}


	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = this.contribuyenteDAO.contribuyente(dni);
		if (contribuyente == null) {
			return null;
		}
		this.contribuyenteDAO.contribuyentes().remove(contribuyente);
		return contribuyente;
	}
	

}
