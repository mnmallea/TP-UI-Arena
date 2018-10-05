package domain;

public class CalificacionNumerica implements Calificacion {

	private Integer nota;

	public CalificacionNumerica(Integer nota) {
		this.nota = nota;
	}

	@Override
	public Boolean estaAprobada() {
		return this.nota >= 6;
	}

	@Override
	public String getNota() {
		return this.nota.toString();
	}
}
