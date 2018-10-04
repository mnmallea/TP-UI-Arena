package tests;

import domain.Alumno;
import domain.AsignacionParcial;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.AlumnoCambiarDatosViewModel;
import ui.NombreException;
import ui.UsuarioGitException;

import java.util.Collections;

public class AlumnoCambiarDatosViewModelTest {
	AlumnoCambiarDatosViewModel alumnoCambiarDatosViewModel;
	Alumno alumno;

	@Before
	public void setUp() {
		alumno = new Alumno("Gasti", 150000L, "ggabadian", Collections.singletonList(new AsignacionParcial("DDS")));
		alumnoCambiarDatosViewModel = new AlumnoCambiarDatosViewModel(alumno);
	}

	@Test(expected = NombreException.class)
	public void deberiaFallarAlIngresarUnNombreVacio(){
		alumnoCambiarDatosViewModel.setNombre(" ");
		alumnoCambiarDatosViewModel.aplicarCambios();
	}

	@Test(expected = UsuarioGitException.class)
	public void deberiaFallarAlIngresarUnUsuarioDeGitVacio() {
		alumnoCambiarDatosViewModel.setUsuarioGithub("");
		alumnoCambiarDatosViewModel.aplicarCambios();
	}

	@Test
	public void cambiarElNombreDeberiaTenerEfectoSobreElAlumnoDelModelo() {
		String NUEVO_NOMBRE = "Holaaa";
		alumnoCambiarDatosViewModel.setNombre(NUEVO_NOMBRE);
		alumnoCambiarDatosViewModel.aplicarCambios();
		Assert.assertEquals(NUEVO_NOMBRE, alumno.getNombre());
	}
}
