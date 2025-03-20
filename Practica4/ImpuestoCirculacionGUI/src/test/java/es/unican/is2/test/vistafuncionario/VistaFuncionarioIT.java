package es.unican.is2.test.vistafuncionario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import org.fest.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.practica3.IInfoImpuestoCirculacion;
import es.unican.is2.practica3.VistaFuncionario;

public class VistaFuncionarioIT {
	private FrameFixture window;  
	private IInfoImpuestoCirculacion info;

	@BeforeEach
	public void setUp() {
		VistaFuncionario GUI = new VistaFuncionario(info);
		window = new FrameFixture(GUI);
		GUI.setVisible(true);
	}
	
	@AfterEach
	public void tearDown() {
		window.cleanUp();
	}
	
	@Test
	public void test() {
		window.button("btnBuscar").requireText("Buscar");
		window.textBox("txtDniContribuyente").enterText("11111111A");
		window.button("btnBuscar").click();
		window.textBox("txtNombreContribuyente").requireText("Juan Lopez Perez");
	}
	
}
