package domain;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

import java.sql.Array;

@Observable
public class Consulta {

    private Alumno alumno;
    private Boolean actualizar;

    public Consulta(){
        refresh();
    }

    public void setActualizar(Boolean actualizar) {
        this.actualizar = actualizar;
    }

    public void refresh(){
        actualizar = true;
        alumno = new RequestService().getAlumno();
        System.out.println("REFRESQUE");
        actualizar = false;
    }

    @Dependencies({"postearCambios"})
    public Alumno getAlumno(){
        System.out.println("USE EL GETTER");
        return alumno;
    }
}