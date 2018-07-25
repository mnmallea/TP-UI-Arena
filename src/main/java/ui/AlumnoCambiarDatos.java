package ui;

import domain.Alumno;
import org.uqbar.commons.model.annotations.Observable;

@Observable
public class AlumnoCambiarDatos {

	private Alumno alumno;

	private String nombre;
	private Long legajo;
	private String usuarioGithub;

	public AlumnoCambiarDatos(Alumno alumno) {
		this.alumno = alumno;
		this.nombre = alumno.getNombre();
		this.legajo = alumno.getLegajo();
		this.usuarioGithub = alumno.getUsuarioGithub();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getLegajo() {
		return legajo;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public String getUsuarioGithub() {
		return usuarioGithub;
	}

	public void setUsuarioGithub(String usuarioGithub) {
		this.usuarioGithub = usuarioGithub;
	}

	public void aplicarCambios() {
		if(this.nombre.trim().equals(""))
			throw new RuntimeException("El nombre no puede estar vacío");
		if(this.usuarioGithub.trim().equals(""))
			throw new RuntimeException("El usuario de github no puede ser vacío");

		alumno.setUsuarioGithub(this.usuarioGithub);
		alumno.setNombre(this.nombre);
		alumno.setLegajo(this.legajo);
	}
}
