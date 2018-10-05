package domain;

import org.uqbar.commons.model.annotations.Observable;

import java.util.ArrayList;
import java.util.List;

@Observable
public class Asignacion{
	private List<Calificacion> calificaciones;
	private String nombre;

	public Asignacion(String nombre) {
		this.nombre = nombre;
		this.calificaciones = new ArrayList<>();
	}

	public void agregarCalificacion(Calificacion unaCalificacion) {
		calificaciones.add(unaCalificacion);
	}

	private Calificacion calificacionFinal() {
		return calificaciones.isEmpty()? new SinCalificacion(): calificaciones.get(calificaciones.size() - 1);
	}
	
	public Boolean getEstaAprobada() {
		return this.calificacionFinal().estaAprobada();
	}

	public String getNotaFinal() {
		return this.calificacionFinal().getNota();
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
}
