package domain.alumnos;

import domain.materias.Materia;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private Integer legajo;
    private String nombre;
    private String apellido;

    @Getter
    private List<Materia> materiasAprobadas;


    public void agregarMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public boolean cumpleCorrelativas(Materia materia) {
        for (Materia correlativa: materia.getCorrelativas()){
            if (!this.getMateriasAprobadas().contains(correlativa)){
                return false;
            }
        }
        return true;
    }
    public Alumno(List<Materia> materiasAprobadas, String nombre, String apellido, Integer legajo) {
        this.materiasAprobadas = (materiasAprobadas == null) ? new ArrayList<>() : materiasAprobadas;
    }
}
