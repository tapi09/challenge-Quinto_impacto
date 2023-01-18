package com.challenge.universidad.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "alumno")
@Getter
@Setter
public class Alumno {
    @Id
    @Column(name = "alumno_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer edad;
    @Temporal(TemporalType.DATE)
    private Date nacimiento;
    private String historia;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "alumno_curso",
            joinColumns = {@JoinColumn(name = "alumno_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
    private List<Curso> cursos;

}
