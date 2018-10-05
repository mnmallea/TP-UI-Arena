package domain;

import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

@Observable
public class Consulta {
    public Alumno getAlumno(){
        return new RequestService().getAlumno();
    }
}