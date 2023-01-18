package com.challenge.universidad.entities;

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

    private String nombre;
    private String apellido;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Curso> cursos;
}
