
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	public IContribuyentesDAO contribuyenteDAO;
	public IVehiculosDAO vehiculoDAO;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentesDAO, IVehiculosDAO vehiculosDao) {
		this.contribuyenteDAO = contribuyentesDAO;
		this.vehiculoDAO = vehiculosDao;
		
	}
	
	public Vehiculo vehiculo(String matricula) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	public Contribuyente contribuyente(String dni) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo)
			throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}


	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
