package es.unican.is2.Main;

import es.unican.is2.Business.GestionImpuestoCirculacion;
import es.unican.is2.DAOH2.ContribuyentesDAO;
import es.unican.is2.DAOH2.VehiculosDAO;
import es.unican.is2.GUI.VistaFuncionario;

/**
 * Clase principal que construye la aplicacion de tres capas y lanza su ejecucion
 */
public class Runner {

	public static void main(String[] args) {
		// Componentes capa DAO
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaFuncionario vista = new VistaFuncionario(negocio);
		
		// Lanza ejecucion
		vista.setVisible(true);
	}

}
