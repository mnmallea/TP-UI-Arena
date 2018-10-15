package domain;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

import java.util.List;

@Observable
public class Alumno {
    private List<Asignacion> asignaciones;

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

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        return this.getNombre() + this.getApellido();
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
