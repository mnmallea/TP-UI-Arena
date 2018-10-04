package deserializers;

import com.google.gson.*;
import domain.Alumno;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AlumnoDeserializer implements JsonDeserializer<Alumno> {
    @Override
    public Alumno deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String nombre = jsonObject.get("first_name").getAsString();
        String apellido = jsonObject.get("last_name").getAsString();
        Long legajo = jsonObject.get("code").getAsLong();
        String githubUser = jsonObject.get("github_user").getAsString();
        return new Alumno(nombre + " " + apellido, legajo, githubUser, new ArrayList<>());
    }
}
