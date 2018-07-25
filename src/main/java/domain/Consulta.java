package domain;

import org.uqbar.commons.model.annotations.Observable;

import java.util.List;

@Observable
public class Consulta {
	public Alumno alumno;
	public RepoAlumnos repoAlumnos;
	
	public Consulta(){
		this.repoAlumnos = RepoAlumnos.instancia;
	}
	
	public List<Alumno> getAlumnos(){
		return repoAlumnos.getAlumnos();
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}