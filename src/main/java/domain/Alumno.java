package domain;

import java.util.List;

import org.uqbar.commons.model.annotations.TransactionalAndObservable;
import services.RequestService;

@TransactionalAndObservable
public class Alumno {
    private String nombre;
    private Long legajo;
    private String usuarioGithub;
    private List<Asignacion> asignaciones;

    public Alumno(String nombre, Long legajo, String usuarioGithub, List<Asignacion> asignaciones) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.usuarioGithub = usuarioGithub;
        this.asignaciones = asignaciones;
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

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }

    public void setUsuarioGithub(String usuarioGithub) {
        this.usuarioGithub = usuarioGithub;
    }

    public List<Asignacion> getAsignaciones() {
        return new RequestService().getAsignaciones();
    }

    public void agregarAsignacion(Asignacion unaAsignacion) {
        this.asignaciones.add(unaAsignacion);
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
