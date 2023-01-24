package com.challenge.universidad.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "profesor")
@Getter
@Setter
public class Profesor {

    @Id
    @Column(name = "profesor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "profesor_nombre")
    private String nombre;
    @Column(name = "profesor_apellido")
    private String apellido;
    @Column(name = "cursos")
    @OneToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, targetEntity = Curso.class)
    private List<Curso> cursos;
}
