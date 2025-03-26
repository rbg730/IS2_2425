package es.unican.is2.Business;

import es.unican.is2.COMMON.Contribuyente;
import es.unican.is2.COMMON.DataAccessException;
import es.unican.is2.COMMON.IContribuyentesDAO;
import es.unican.is2.COMMON.IGestionContribuyentes;
import es.unican.is2.COMMON.IGestionVehiculos;
import es.unican.is2.COMMON.IInfoImpuestoCirculacion;
import es.unican.is2.COMMON.IVehiculosDAO;
import es.unican.is2.COMMON.OperacionNoValidaException;
import es.unican.is2.COMMON.Vehiculo;

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
			return null;
		}
		return contribuyente;
	}


	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyente(dni);
		if (contribuyente == null) {
			throw new OperacionNoValidaException("el cliente no existe");
		}
		else if (vehiculoDAO.vehiculoPorMatricula(v.getMatricula()) != null) {
			throw new OperacionNoValidaException("vehiculo ya dado de alta");
		}
		
		this.vehiculoDAO.creaVehiculo(v);
		contribuyente.getVehiculos().add(v);
		contribuyenteDAO.actualizaContribuyente(contribuyente);
		return v;
	}


	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = contribuyente(dni);
		Vehiculo vehiculo = vehiculoDAO.vehiculoPorMatricula(matricula);
		if (vehiculo == null || contribuyente == null) {
			return null;
		}
		if (contribuyente.buscaVehiculo(matricula) == null) {
			throw new OperacionNoValidaException("El vehiculo no pertenece al contribuyente indicado");
		}
		contribuyenteDAO.contribuyente(dni).getVehiculos().remove(vehiculo);
		this.vehiculoDAO.eliminaVehiculo(matricula);
		
		return vehiculo;
	}


	public boolean cambiaTitularVehiculo(String matricula, String dniActual, String dniNuevo)
			throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente1 = contribuyente(dniActual);
		Contribuyente contribuyente2 = contribuyente(dniNuevo);
		Vehiculo vehiculo = vehiculoDAO.vehiculoPorMatricula(matricula);
		
		if (vehiculo == null || contribuyente1 == null || contribuyente2 == null) {
			return false;
		}
		
		else if (contribuyente1.buscaVehiculo(matricula) == null) {
			throw new OperacionNoValidaException("vehiculo no encontrado");

		}
		contribuyente1.getVehiculos().remove(vehiculo);
		contribuyente2.getVehiculos().add(vehiculo);
		contribuyenteDAO.actualizaContribuyente(contribuyente1);
		contribuyenteDAO.actualizaContribuyente(contribuyente2);
		return true;
	}


	public Contribuyente altaContribuyente(Contribuyente c) throws DataAccessException {
		
		Contribuyente contribuyente = this.contribuyenteDAO.contribuyente(c.getDni());
		if (contribuyente != null) {
			return null;
		}
		this.contribuyenteDAO.creaContribuyente(contribuyente);
		return c;
	}


	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValidaException, DataAccessException {
		Contribuyente contribuyente = this.contribuyenteDAO.contribuyente(dni);
		if (contribuyente == null) {
			return null;
		}
		if (contribuyente.getVehiculos() != null) {
			throw new OperacionNoValidaException("ya tiene vehiculos a su nombre");
		}
		this.contribuyenteDAO.eliminaContribuyente(dni);
		return contribuyente;
	}
	

}
