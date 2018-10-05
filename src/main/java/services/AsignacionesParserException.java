package services;

import com.google.gson.JsonSyntaxException;
import domain.Asignacion;

import java.util.List;

public class AsignacionesParserException extends RuntimeException {
    public AsignacionesParserException(JsonSyntaxException e) {
        super(e);
    }
}
