package domain;

import java.util.ArrayList;
import java.util.List;


public class RepoAlumnos {

	public static final RepoAlumnos instancia = new RepoAlumnos();

	private List<Alumno> alumnos;

	private RepoAlumnos() {
		alumnos = new ArrayList<>();
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
}
