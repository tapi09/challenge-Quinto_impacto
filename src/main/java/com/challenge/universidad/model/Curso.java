package com.challenge.universidad.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "curso")
@Getter
@Setter
public class Curso {

    @Id
    @Column(name = "curso_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "curso_nombre")
    private String nombre;
    @ManyToOne( fetch = FetchType.LAZY)
    private Profesor profesor;
    @Column(name = "curso_turno")
    private String turno;
    @Column(name = "curso_horario")
    private String horario;
    @Column(name = "curso_alumnos")
    @ManyToMany(mappedBy = "cursos")
    @ToString.Exclude
    private List<Alumno> alumnos= new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return getId().equals(curso.getId()) && Objects.equals(getNombre(), curso.getNombre()) && Objects.equals(getProfesor(), curso.getProfesor()) && Objects.equals(getTurno(), curso.getTurno()) && Objects.equals(getHorario(), curso.getHorario()) && Objects.equals(getAlumnos(), curso.getAlumnos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getProfesor(), getTurno(), getHorario(), getAlumnos());
    }
}
