package ui;

import org.uqbar.commons.model.annotations.Observable;

@Observable
public class ErrorMessage {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "Ha ocurrido un error al realizar la operación: " + message;
    }
}
