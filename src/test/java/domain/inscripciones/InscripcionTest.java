package domain.inscripciones;

import domain.alumnos.Alumno;
import domain.materias.Materia;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    Materia algoritmos = new Materia("Algoritmos", new ArrayList<>());
    Materia discreta = new Materia("Discreta", new ArrayList<>());
    Materia paradigmas = new Materia("Paradigmas", new ArrayList<>());
    Materia sintaxis = new Materia("Sintaxis", new ArrayList<>());
    Materia diseno = new Materia("Diseño", new ArrayList<>());
    Materia arquitectura = new Materia("Arquitectura", new ArrayList<>());
    Materia operativos = new Materia("Sistemas Operativos", new ArrayList<>());

    {
        paradigmas.getCorrelativas().add(algoritmos);
        sintaxis.getCorrelativas().add(algoritmos);
        sintaxis.getCorrelativas().add(discreta);
        diseno.getCorrelativas().add(algoritmos);
        operativos.getCorrelativas().add(arquitectura);
    }

    @Test
    void inscripcionMateriaSinCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose", "Perez", 2087716);

        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(algoritmos);
        materiasInscripcion.add(discreta);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertTrue(inscripcion.aprobada());
    }

    @Test
    void inscripcionSinMateriasAprobadas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose","Perez",2087716);

        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(paradigmas);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertFalse(inscripcion.aprobada());
        //No podria ya que no tiene algoritmos
    }
    @Test
    void inscripcionConMateriasAprobadas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose","Perez",2087716);
        alumno.agregarMateriaAprobada(discreta);
        alumno.agregarMateriaAprobada(algoritmos);

        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(paradigmas);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertTrue(inscripcion.aprobada());
        //Si podria ya que tiene algoritmos
    }
    @Test
    void inscripcionConAlgunasCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose","Perez",2087716);
        alumno.agregarMateriaAprobada(discreta);

        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(sintaxis);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertFalse(inscripcion.aprobada());
        //No podria ya que no tiene algoritmos
    }

    @Test
    void inscripcionConVariasCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose","Perez",2087716);
        alumno.agregarMateriaAprobada(discreta);
        alumno.agregarMateriaAprobada(algoritmos);

        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertTrue(inscripcion.aprobada());
    }
    @Test
    void inscripcionMuchasMateriasConAlgunasCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose","Perez",2087716);
        alumno.agregarMateriaAprobada(algoritmos);

        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(diseno);
        materiasInscripcion.add(sintaxis);
        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertFalse(inscripcion.aprobada());
        //No podria ya que solo tiene algoritmos
    }

    @Test
    void inscripcionMuchasMateriasConCorrelativas() {
        Alumno alumno = new Alumno(new ArrayList<>(), "Jose","Perez",2087716);
        alumno.agregarMateriaAprobada(algoritmos);
        alumno.agregarMateriaAprobada(discreta);
        alumno.agregarMateriaAprobada(arquitectura);


        ArrayList<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(diseno);
        materiasInscripcion.add(sintaxis);
        materiasInscripcion.add(operativos);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        assertTrue(inscripcion.aprobada());
    }

}