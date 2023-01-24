package com.challenge.universidad.dto;

import com.challenge.universidad.model.Alumno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {


    private Long id;
    private String nombre;
    private String turno;
    private String horario;
    private ProfesorDto profesor;
    private List<AlumnoDto> alumnos;

}
