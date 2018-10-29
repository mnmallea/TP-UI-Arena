package ui;

import domain.Alumno;
import domain.Asignacion;
import org.uqbar.commons.model.annotations.Observable;
import repos.RepoAlumno;

import java.util.List;

@Observable
public class AlumnoViewModel {
    private Alumno alumno;

    public AlumnoViewModel(){
        this.alumno = RepoAlumno.getInstance().getAlumno();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public String getApellido() {
        return alumno.getApellido();
    }

    public String getNombre() {
        return alumno.getNombre();
    }

    public Long getLegajo() {
        return alumno.getLegajo();
    }

    public String getUsuarioGithub() {
        return alumno.getUsuarioGithub();
    }

    public List<Asignacion> getAsignaciones(){
        return alumno.getAsignaciones();
    }
}
