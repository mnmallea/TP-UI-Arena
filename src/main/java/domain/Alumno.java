package domain;

import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

import java.util.List;

@Observable
public class Alumno {
    private String nombre;
    private String apellido;
    private Long legajo;
    private String usuarioGithub;

    public Alumno(String nombre, String apellido, Long legajo, String usuarioGithub) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.usuarioGithub = usuarioGithub;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getLegajo() {
        return legajo;
    }

    public String getUsuarioGithub() {
        return usuarioGithub;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuarioGithub(String usuarioGithub) {
        this.usuarioGithub = usuarioGithub;
    }

    public List<Asignacion> getAsignaciones() {
        return new RequestService().getAsignaciones();
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public void actualizar() {
        new RequestService().updateAlumno(this);
    }
}
