package services;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import mappers.Student;
import domain.Alumno;
import domain.Asignacion;

import javax.ws.rs.core.MediaType;
import java.util.List;


public class RequestService {
    private Client client;
    private static final String API_NOTITAS = "http://notitas.herokuapp.com";
    private static final String STUDENT_RESOURCE = "student";
    private static final String ASSIGNMENTS_RESOURCE = "assignments";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    public RequestService() {
        this.client = Client.create();
    }

    public Alumno getAlumno() {
        ClientResponse response = getResourceBuilder(STUDENT_RESOURCE).get(ClientResponse.class);
        String json = response.getEntity(String.class);
        Student student = new Gson().fromJson(json, Student.class);
        return student.getAlumno();
    }

    private WebResource.Builder getResourceBuilder(String path) {
        WebResource resource = client.resource(API_NOTITAS).path(path);
        return resource.header("Authorization", "Bearer " + TOKEN).accept(MediaType.APPLICATION_JSON);
    }

    public List<Asignacion> getAsignaciones() {
        ClientResponse response = getResourceBuilder(STUDENT_RESOURCE + "/" + ASSIGNMENTS_RESOURCE).get(ClientResponse.class);
        String json = response.getEntity(String.class);

        return new AsignacionesParser().parseAssignments(json);
    }

    public void updateAlumno(Alumno alumno) {
        String json = new Gson().toJson(new Student(alumno));
        WebResource.Builder resource = getResourceBuilder(STUDENT_RESOURCE);
        ClientResponse response = resource.put(ClientResponse.class, json);
        if(response.getStatus() != 201)
            throw new RuntimeException("No se pudo postearCambios el alumno");
    }
}
