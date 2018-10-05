package domain;

public class SinCalificacion implements Calificacion {
    @Override
    public Boolean estaAprobada() {
        return false;
    }

    @Override
    public String getNota() {
        return "Sin calificar";
    }
}
