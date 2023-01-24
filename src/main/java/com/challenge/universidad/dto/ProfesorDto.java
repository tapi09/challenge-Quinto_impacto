package com.challenge.universidad.dto;

import com.challenge.universidad.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDto {

    private Long id;

    private String nombre;
    private String apellido;
    private List<CursoDto> cursos;
}
