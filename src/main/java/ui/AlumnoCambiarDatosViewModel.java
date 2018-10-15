package ui;

import domain.Alumno;
import org.uqbar.commons.model.annotations.Observable;
import repos.RepoAlumno;

@Observable
public class AlumnoCambiarDatosViewModel {

    private Alumno alumno;

    private String nombre;
    private String apellido;
    private Long legajo;
    private String usuarioGithub;

    public AlumnoCambiarDatosViewModel(Alumno alumno) {
        this.alumno = alumno;
        this.nombre = alumno.getNombre();
        this.legajo = alumno.getLegajo();
        this.apellido = alumno.getApellido();
        this.usuarioGithub = alumno.getUsuarioGithub();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLegajo() {
        return legajo;
    }

    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }

    public String getUsuarioGithub() {
        return usuarioGithub;
    }

    public void setUsuarioGithub(String usuarioGithub) {
        this.usuarioGithub = usuarioGithub;
    }

    public void aplicarCambios() {
        if (this.nombre.trim().isEmpty() || this.apellido.trim().isEmpty())
            throw new NombreException("El nombre no puede estar vacío");
        if (this.usuarioGithub.trim().isEmpty())
            throw new UsuarioGitException("El usuario de github no puede ser vacío");

        alumno.setUsuarioGithub(this.usuarioGithub);
        alumno.setNombre(this.nombre);
        alumno.setApellido(this.apellido);
        RepoAlumno.getInstance().updateAlumno(alumno);
    }
}
