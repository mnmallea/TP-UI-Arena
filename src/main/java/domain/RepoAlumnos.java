package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RepoAlumnos {
	
	public static RepoAlumnos instancia = new RepoAlumnos();
	
	private RepoAlumnos() {
		
	}
	
	public List<Alumno> getAlumnos(){
		// Martin Mallea
		AsignacionParcial parcialMartin = new AsignacionParcial("Parcial DDS");
		parcialMartin.agregarCalificacion(new CalificacionNumerica(6));
		AsignacionTP tpMartin = new AsignacionTP("TP UI Arena");
		tpMartin.agregarCalificacion(new CalificacionConceptual("M"));
		tpMartin.agregarCalificacion(new CalificacionConceptual("R"));
		Alumno martin = new Alumno("Martin Mallea", 1590935L, "mnmallea", Arrays.asList(parcialMartin, tpMartin));
		
		
		//Gaston Gabadian
		AsignacionParcial parcialGaston = new AsignacionParcial("Parcial DDS");
		parcialGaston.agregarCalificacion(new CalificacionNumerica(2));
		AsignacionTP tpGaston = new AsignacionTP("TP UI Arena");
		tpGaston.agregarCalificacion(new CalificacionConceptual("M"));
		tpGaston.agregarCalificacion(new CalificacionConceptual("M"));
		Alumno gaston = new Alumno("Gaston Gabadian", 1590807L, "ggabadian", Arrays.asList(parcialGaston, tpGaston));
		
		//Albert Einstein
		AsignacionParcial parcialEinstein = new AsignacionParcial("Parcial Teoria de la Relatividad");
		parcialEinstein.agregarCalificacion(new CalificacionNumerica(14));
		AsignacionTP tpEinstein = new AsignacionTP("TP MRUV");
		tpEinstein.agregarCalificacion(new CalificacionConceptual("MB+++++++++++++++++++++++++++++++"));
		AsignacionTP tpEinstein2 = new AsignacionTP("TP Funcion Lineal");
		tpEinstein2.agregarCalificacion(new CalificacionConceptual("B+++++++"));
		Alumno einstein = new Alumno("Albert Einstein", 0000001L, "soyElDelBuffet", Arrays.asList(parcialEinstein, tpEinstein,tpEinstein2));
		
		return Arrays.asList(martin,gaston,einstein);
	}
}
