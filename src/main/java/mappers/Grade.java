package mappers;

import domain.Calificacion;
import domain.CalificacionConceptual;
import domain.CalificacionNumerica;
import org.apache.commons.lang.StringUtils;

public class Grade {
    private String value;
    private String created_at;
    private String updated_at;

    public Calificacion getCalificacion(){
        if(StringUtils.isNumeric(value))
            return new CalificacionNumerica(Integer.parseInt(value));
        else
            return new CalificacionConceptual(value);
    }

    @Override
    public String toString() {
        return "Value: " + value +"  Created at: " + created_at + "  Updated at: " + updated_at;
    }
}