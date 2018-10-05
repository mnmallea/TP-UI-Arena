package domain;

import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;
import services.RequestService;

import java.util.List;

@Observable
public class Alumno {
    private String nombre;
    private String apellido;
    private Long legajo;
    private String usuarioGithub;
    private boolean refresh;

    public static Alumno traerAlumno(){
        return new RequestService().getAlumno();
    }

    public Alumno(String nombre, String apellido, Long legajo, String usuarioGithub) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.usuarioGithub = usuarioGithub;
    }

    @Dependencies({"refresh"})
    public String getApellido() {
        System.out.println("USE EL GETTER DE APELLIDO");
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @Dependencies({"refresh"})
    public String getNombre() {

        System.out.println("USE EL GETTER DE NOMBRE");
        return nombre;
    }
    @Dependencies({"refresh"})
    public Long getLegajo() {
        return legajo;
    }
    @Dependencies({"refresh"})
    public String getUsuarioGithub() {

        System.out.println("USE EL GETTER DE GIT");
        return usuarioGithub;
    }

    public void setNombre(String nombre) {
        System.out.println("TE ESTOY HACIENDO UN SET DESPERTATE");
        this.nombre = nombre;
    }

    public void setUsuarioGithub(String usuarioGithub) {
        this.usuarioGithub = usuarioGithub;
    }

    public List<Asignacion> getAsignaciones() {

        System.out.println("USE EL GETTER DE aSIGNCIONE");
        return new RequestService().getAsignaciones();
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public void postearCambios() {
        new RequestService().updateAlumno(this);
    }

    public void coerceToRefresh() {
        this.refresh = true;
        this.refresh = false;
    }

    public boolean getRefresh() {
        return refresh;
    }
}
