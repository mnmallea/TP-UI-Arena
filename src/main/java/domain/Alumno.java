package domain;

import org.uqbar.commons.model.annotations.TransactionalAndObservable;

import java.util.List;

@TransactionalAndObservable
public class Alumno {
	private String nombre;
	private Long legajo;
	private String usuarioGithub;
	private List<Asignacion> asignaciones;

	public Alumno(String nombre, Long legajo, String usuarioGithub) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.usuarioGithub = usuarioGithub;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getLegajo() {
		return legajo;
	}

	public String getUsuarioGithub() {
		return usuarioGithub;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLegajo(Long legajo) {
		this.legajo = legajo;
	}

	public void setUsuarioGithub(String usuarioGithub) {
		this.usuarioGithub = usuarioGithub;
	}


}
