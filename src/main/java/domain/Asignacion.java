package domain;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class Asignacion {
	private Tarea tarea;

	public Boolean getEstaAprobada() {
		return true;
	}

	public Integer getNotaFinal() {
		return 6;
	}

}
