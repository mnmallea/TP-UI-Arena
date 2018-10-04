package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import deserializers.AlumnoDeserializer;
import domain.Alumno;

import javax.ws.rs.core.MediaType;


public class RequestService {
    private Client client;
    private static final String API_NOTITAS = "http://notitas.herokuapp.com";
    private static final String RESOURCE = "student";
    private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

    //Inicializacion del cliente.
    public RequestService() {
        this.client = Client.create();
        //En la documentacion se puede ver como al cliente agregarle un ClientConfig
        //para agregarle filtros en las respuestas (por ejemplo, para loguear).
    }

    public Alumno getAlumno(){
        WebResource resource = client.resource(API_NOTITAS).path(RESOURCE);
        WebResource.Builder resurceWithHeader = resource.header("Authorization", "Bearer " + TOKEN);
        WebResource.Builder builder = resurceWithHeader.accept(MediaType.APPLICATION_JSON);
        ClientResponse response = builder.get(ClientResponse.class);
        String json = response.getEntity(String.class);
        Gson gson = new GsonBuilder().registerTypeAdapter(Alumno.class, new AlumnoDeserializer()).create();
        System.out.println(json);
        Alumno alumno = gson.fromJson(json, Alumno.class);
        return alumno;
    }
}
