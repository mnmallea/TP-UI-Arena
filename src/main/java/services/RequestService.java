package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import deserializers.AlumnoDeserializer;
import deserializers.Assignments;
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
        WebResource resource = client.resource(API_NOTITAS).path(STUDENT_RESOURCE);
        WebResource.Builder resurceWithHeader = resource.header("Authorization", "Bearer " + TOKEN);
        WebResource.Builder builder = resurceWithHeader.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        String json = response.getEntity(String.class);
        Gson gson = new GsonBuilder().registerTypeAdapter(Alumno.class, new AlumnoDeserializer()).create();
        System.out.println(json);
        return gson.fromJson(json, Alumno.class);
    }

    public List<Asignacion> getAsignaciones() {
        WebResource resource = client.resource(API_NOTITAS).path(STUDENT_RESOURCE + "/" + ASSIGNMENTS_RESOURCE);
        WebResource.Builder builder = resource.header("Authorization", "Bearer " + TOKEN).accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        String json = response.getEntity(String.class);
        return new AsignacionesParser().parseAssignments(json);
    }

    public static void main(String[] args) {
        System.out.println(new RequestService().getAsignaciones());
    }
}
