package domain;

public class CalificacionConceptual implements Calificacion<String> {

	private static final String NOTA_MALA = "M";
	private String nota;

	public CalificacionConceptual(String nota) {
		this.nota = nota;
	}

	@Override
	public Boolean estaAprobada() {
		return !nota.equals(NOTA_MALA);
	}

	@Override
	public String getNota() {
		return nota;
	}
}
