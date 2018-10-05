package deserializers;

import domain.Asignacion;

import java.util.List;

public class Assignment {
    private Long id;
    private String title;
    private String description;
    private List<Grade> grades;

    @Override
    public String toString() {
        return "Id:" + id + "  Title: " + title + "  Description: " + description + " Grades: " + grades.toString();
    }

    public Asignacion getAsignacion(){
        return new Asignacion(title);
    }
}
