package repos;

import domain.Alumno;
import domain.Asignacion;
import services.RequestService;

import java.util.List;

public class RepoAlumno {
    private RepoAlumno() {
        this.requestService = new RequestService();
    }

    private static RepoAlumno instance;
    private RequestService requestService;

    public static RepoAlumno getInstance() {
        if(instance == null){
            instance = new RepoAlumno();
        }
        return instance;
    }

    public Alumno getAlumno(){
        Alumno alumno =  requestService.getAlumno();
        List<Asignacion> asignaciones = requestService.getAsignaciones();
        alumno.setAsignaciones(asignaciones);
        return alumno;
    }

    public void updateAlumno(Alumno alumno){
        requestService.putAlumno(alumno);
    }
}
