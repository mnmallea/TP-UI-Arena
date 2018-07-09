package domain;

public class CalificacionNumerica implements Calificacion<Integer> {

	private Integer calificacion;

	public CalificacionNumerica(Integer calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public Boolean estaAprobada() {
		return this.calificacion >= 6;
	}

	@Override
	public Integer getCalificacion() {
		return this.calificacion;
	}
}
