package services;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import deserializers.Assignments;
import domain.Asignacion;

import java.util.List;

public class AsignacionesParser {
    public List<Asignacion> parseAssignments(String json) {
        Assignments assignments;
        try {
            assignments = new Gson().fromJson(json, Assignments.class);
        } catch (JsonSyntaxException e) {
            throw new AsignacionesParserException(e);
        }
        System.out.println(assignments);
        return assignments.getAsignaciones();
    }
}
