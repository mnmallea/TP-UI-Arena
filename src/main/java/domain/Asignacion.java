package domain;

import org.uqbar.commons.model.annotations.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public abstract class Asignacion<T extends Calificacion> {
	private List<T> calificaciones;
	private String nombre;

	public Asignacion(String nombre) {
		this.nombre = nombre;
		this.calificaciones = new ArrayList<>();
	}

	public void agregarCalificacion(T unaCalificacion) {
		calificaciones.add(unaCalificacion);
	}

	public Boolean getEstaAprobada() {
		return this.calificacionFinal().estaAprobada();
	}

	public String getNotaFinal() {
		return this.calificacionFinal().getCalificacion().toString();
	}

	public String getNombre() {
		return this.nombre;
	}

	private Calificacion calificacionFinal() {
		return this.calificaciones.get(calificaciones.size() - 1);
	}

	public List<T> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<T> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
