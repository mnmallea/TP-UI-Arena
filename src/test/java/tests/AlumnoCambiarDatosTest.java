package tests;

import domain.Alumno;
import domain.AsignacionParcial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.AlumnoCambiarDatos;
import ui.NombreException;
import ui.UsuarioGitException;

import java.util.Collections;

public class AlumnoCambiarDatosTest {
	AlumnoCambiarDatos alumnoCambiarDatos;
	Alumno alumno;

	@Before
	public void setUp() {
		alumno = new Alumno("Gasti", 150000L, "ggabadian", Collections.singletonList(new AsignacionParcial("DDS")));
		alumnoCambiarDatos = new AlumnoCambiarDatos(alumno);
	}

	@Test(expected = NombreException.class)
	public void deberiaFallarAlIngresarUnNombreVacio(){
		alumnoCambiarDatos.setNombre(" ");
		alumnoCambiarDatos.aplicarCambios();
	}

	@Test(expected = UsuarioGitException.class)
	public void deberiaFallarAlIngresarUnUsuarioDeGitVacio() {
		alumnoCambiarDatos.setUsuarioGithub("");
		alumnoCambiarDatos.aplicarCambios();
	}

	@Test
	public void cambiarElNombreDeberiaTenerEfectoSobreElAlumnoDelModelo() {
		String NUEVO_NOMBRE = "Holaaa";
		alumnoCambiarDatos.setNombre(NUEVO_NOMBRE);
		alumnoCambiarDatos.aplicarCambios();
		Assert.assertEquals(NUEVO_NOMBRE, alumno.getNombre());
	}
}
