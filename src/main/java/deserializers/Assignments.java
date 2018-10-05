package deserializers;

import domain.Asignacion;

import java.util.List;
import java.util.stream.Collectors;

public class Assignments {
    private List<Assignment> assignments;

    @Override
    public String toString() {
        return this.assignments.toString();
    }

    public List<Asignacion> getAsignaciones(){
         return this.assignments.stream().map(Assignment::getAsignacion).collect(Collectors.toList());
    }
}