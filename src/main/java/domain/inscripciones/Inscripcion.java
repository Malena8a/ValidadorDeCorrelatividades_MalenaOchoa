package domain.inscripciones;

import domain.alumnos.Alumno;
import domain.materias.Materia;

import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }
    public boolean aprobada(){
        for (Materia materia : materias) {
            if (!alumno.cumpleCorrelativas(materia))
                return false;
        }
        return true;
    }

}
