package services;

import domain.Asignacion;
import domain.CalificacionConceptual;
import domain.CalificacionNumerica;
import org.junit.Before;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AsignacionesParserTest {

    private static final String FILE_NAME = "src/test/resources/assignments.json";
    private String json;

    private List<Asignacion> getAsignaciones() {
        return new AsignacionesParser().parseAssignments(json);
    }

    @Before
    public void setUp() throws Exception{
        json = new String(Files.readAllBytes(Paths.get(FILE_NAME)), StandardCharsets.UTF_8);
    }

    @Test
    public void parseandoAsignaciones() {
        List<Asignacion> asignacionList = getAsignaciones();
        assertEquals("Primer Parcial",asignacionList.get(0).getNombre());
    }

    @Test
    public void laCalificacionDelPrimerParcialEsNumerica() {
        Asignacion asignacion = getAsignaciones().get(0);
        assertEquals(CalificacionNumerica.class, asignacion.getCalificaciones().get(0).getClass());
    }

    @Test
    public void laCalificacionDelTPA1EsConceptual() {
        Asignacion asignacion = getAsignaciones().get(1);
        assertEquals(CalificacionConceptual.class, asignacion.getCalificaciones().get(0).getClass());
    }
}