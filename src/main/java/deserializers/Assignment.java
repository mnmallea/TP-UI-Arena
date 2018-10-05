package deserializers;

import domain.Asignacion;
import domain.Calificacion;

import java.util.List;
import java.util.stream.Collectors;

public class Assignment {
    private Long id;
    private String title;
    private String description;
    private List<Grade> grades;

    @Override
    public String toString() {
        return "Id:" + id + "  Title: " + title + "  Description: " + description + " Grades: " + grades.toString();
    }
    private List<Calificacion> getGradesAsCalificaciones(){
        return grades.stream().map(Grade::getCalificacion).collect(Collectors.toList());
    }

    public Asignacion getAsignacion(){
        return new Asignacion(title, this.getGradesAsCalificaciones());
    }
}
