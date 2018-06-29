package ui;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

import domain.Alumno;

@Observable
public class AlumnoViewModel {

	private Alumno alumno;

	public AlumnoViewModel(Alumno alumno) {
		this.alumno = alumno;
	}

	public String getNombre(){
		return alumno.getNombre();
	}

	public Long getLegajo(){
		return alumno.getLegajo();
	}

	public String getUsuarioGithub(){
		return alumno.getUsuarioGithub();
	}

	public void setNombre(String nombre) {
		alumno.setNombre(nombre);
	}

	public void setLegajo(Long legajo) {
		alumno.setLegajo(legajo);
	}

	public void setUsuarioGithub(String usuarioGithub) {
		alumno.setUsuarioGithub(usuarioGithub);
	}

}
