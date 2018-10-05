package domain;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

import java.util.List;

@Observable
public class Alumno {
    private final List<Asignacion> asignaciones;
    private String nombre;
    private String apellido;
    private Long legajo;
    private String usuarioGithub;

    public static Alumno traerAlumno() {
        return new RequestService().getAlumno();
    }

    public Alumno(String nombre, String apellido, Long legajo, String usuarioGithub) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.usuarioGithub = usuarioGithub;
        this.asignaciones = new RequestService().getAsignaciones();
    }

    @Dependencies({"refresh"})
    public String getApellido() {
        return apellido;
    }

    @Dependencies({"refresh"})
    public String getNombre() {
        return nombre;
    }

    @Dependencies({"refresh"})
    public Long getLegajo() {
        return legajo;
    }

    @Dependencies({"refresh"})
    public String getUsuarioGithub() {
        return usuarioGithub;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuarioGithub(String usuarioGithub) {
        this.usuarioGithub = usuarioGithub;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public void postearCambios() {
        new RequestService().updateAlumno(this);
    }

    //Fix para que Arena refresque
    private boolean refresh;

    public void coerceToRefresh() {
        this.refresh = true;
        this.refresh = false;
    }

    public boolean getRefresh() {
        return refresh;
    }
    //
}
