package com.challenge.universidad.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
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
    @Column(name = "alumno_nombre")
    private String nombre;
    @Column(name = "alumno_edad")
    private Integer edad;
    @Column(name = "alumno_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date nacimiento;
    @Column(name = "alumno_historia")
    private String historia;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "alumnos_curso",
            joinColumns = {@JoinColumn(name = "alumno_id")},
            inverseJoinColumns = {@JoinColumn(name = "curso_id")}
    )
    @ToString.Exclude
    private List<Curso> cursos = new ArrayList<>();


}
