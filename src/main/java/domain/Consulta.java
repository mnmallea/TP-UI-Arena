package domain;

import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

import java.util.List;

@Observable
public class Consulta {
	public Alumno alumno;

	public Alumno getAlumno() {
		return new RequestService().getAlumno();
	}
	
}