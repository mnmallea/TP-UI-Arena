package services;

import com.google.gson.JsonSyntaxException;

public class AlumnoParserException extends RuntimeException {
    public AlumnoParserException(JsonSyntaxException e) {
    }
}
