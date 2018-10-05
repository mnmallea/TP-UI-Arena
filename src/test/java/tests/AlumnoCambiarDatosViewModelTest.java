package tests;

import domain.Alumno;
import domain.Asignacion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.AlumnoCambiarDatosViewModel;
import ui.NombreException;
import ui.UsuarioGitException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AlumnoCambiarDatosViewModelTest {
    private AlumnoCambiarDatosViewModel alumnoCambiarDatosViewModel;
    private Alumno alumno;

    @Before
    public void setUp() {
        alumno = new Alumno("Gasti", "Gaba", 150000L, "ggabadian");
        alumnoCambiarDatosViewModel = new AlumnoCambiarDatosViewModel(alumno);
    }

    @Test(expected = NombreException.class)
    public void deberiaFallarAlIngresarUnNombreVacio() {
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
