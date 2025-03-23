package es.unican.is2.test;

import es.unican.is2.practica3.*;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class VistaFuncionarioIT {

    private FrameFixture window;
    private IInfoImpuestoCirculacion info;
    private VistaFuncionario GUI;

    @BeforeEach
    public void setUp() throws Exception {

        // Crear los DAOs y la implementación de la lógica de negocio
        IContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
        IVehiculosDAO vehiculosDAO = new VehiculosDAO();
        info = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);



        SwingUtilities.invokeAndWait(() -> {

            GUI = new VistaFuncionario(info);
            GUI.setVisible(true);
        });

        window = new FrameFixture(GUI);
    }

    @AfterEach
    public void tearDown() {
       if (window != null) {
           window.cleanUp();
       }
    }
    @Test
    public void testBuscarButton() {
        JButtonFixture btnBuscar = window.button("btnBuscar"); // Busca el botón por su nombre
        btnBuscar.requireVisible(); // Verifica que el botón sea visible
        btnBuscar.click(); // Simula un clic en el botón
    }

    @Test
    public void testBuscarContribuyente() {
        // Verificar que el botón de búsqueda tiene el texto correcto
        window.button("btnBuscar").requireText("Buscar");

        // Introducir el DNI de un contribuyente existente en la base de datos
        window.textBox("txtDniContribuyente").enterText("11111111A");
        window.button("btnBuscar").click();

        // Verificar que se muestra la información correcta del contribuyente
        assertThat(window.textBox("txtNombreContribuyente").text())
                .isEqualTo("Juan Lopez Perez");
    }
}
