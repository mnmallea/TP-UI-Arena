package mappers;

import domain.Alumno;

public class Student {
    private String code;
    private String first_name;
    private String last_name;
    private String github_user;

    public Alumno getAlumno(){
        return new Alumno(first_name, last_name, Long.parseLong(code), github_user);
    }

    public Student(Alumno alumno) {
        this.code = alumno.getLegajo().toString();
        this.first_name = alumno.getNombre();
        this.last_name = alumno.getApellido();
        this.github_user = alumno.getUsuarioGithub();
    }
}