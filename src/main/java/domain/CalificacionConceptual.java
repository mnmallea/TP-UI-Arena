package domain;

public class CalificacionConceptual implements Calificacion<String> {

	private static final String CALIFICACION_MALA = "M";
	private String calificacion;

	public CalificacionConceptual(String calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public Boolean estaAprobada() {
		return !calificacion.equals(CALIFICACION_MALA);
	}

	@Override
	public String getCalificacion() {
		return calificacion;
	}
}
