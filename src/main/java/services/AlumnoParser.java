package services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import domain.Alumno;
import mappers.Student;

public class AlumnoParser {
    public Alumno parseStudent(String json){

        Student student;
        try {
            student = new Gson().fromJson(json, Student.class);
        } catch (JsonSyntaxException e) {
            throw new AlumnoParserException(e);
        }

        return student.getAlumno();
    }
}
