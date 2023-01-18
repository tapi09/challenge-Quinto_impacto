package com.challenge.universidad.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "curso")
@Getter
@Setter
public class Curso {

    @Id
    @Column(name = "curso_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    @OneToOne(fetch = FetchType.LAZY)
    private Profesor profesor;
    private String turno;
    private String horario;
    @ManyToMany(mappedBy = "cursos")
    private List<Alumno> alumnos;
}
