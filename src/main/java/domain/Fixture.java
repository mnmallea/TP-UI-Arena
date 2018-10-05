package domain;

import java.util.Arrays;

public class Fixture {

	public static void setUp(){
		// Martin Mallea
		Asignacion parcialMartin = new Asignacion("Parcial DDS");
		parcialMartin.agregarCalificacion(new CalificacionNumerica(6));
		Asignacion tpMartin = new Asignacion("TP UI Arena");
		tpMartin.agregarCalificacion(new CalificacionConceptual("M"));
		tpMartin.agregarCalificacion(new CalificacionConceptual("R"));
		Alumno martin = new Alumno("Martin Mallea", 1590935L, "mnmallea", Arrays.asList(parcialMartin, tpMartin));


		//Gaston Gabadian
		Asignacion parcialGaston = new Asignacion("Parcial DDS");
		parcialGaston.agregarCalificacion(new CalificacionNumerica(2));
		Asignacion tpGaston = new Asignacion("TP UI Arena");
		tpGaston.agregarCalificacion(new CalificacionConceptual("M"));
		tpGaston.agregarCalificacion(new CalificacionConceptual("M"));
		Alumno gaston = new Alumno("Gaston Gabadian", 1590807L, "ggabadian", Arrays.asList(parcialGaston, tpGaston));

		//Albert Einstein
		Asignacion parcialEinstein = new Asignacion("Parcial Teoria de la Relatividad");
		parcialEinstein.agregarCalificacion(new CalificacionNumerica(14));
		Asignacion tpEinstein = new Asignacion("TP MRUV");
		tpEinstein.agregarCalificacion(new CalificacionConceptual("MB+++++++++++++++++++++++++++++++"));
		Asignacion tpEinstein2 = new Asignacion("TP Funcion Lineal");
		tpEinstein2.agregarCalificacion(new CalificacionConceptual("B+++++++"));
		Alumno einstein = new Alumno("Albert Einstein", 1L, "soyElDelBuffet", Arrays.asList(parcialEinstein, tpEinstein,tpEinstein2));

		RepoAlumnos.instancia.agregarAlumno(martin);
		RepoAlumnos.instancia.agregarAlumno(gaston);
		RepoAlumnos.instancia.agregarAlumno(einstein);
	}
}
