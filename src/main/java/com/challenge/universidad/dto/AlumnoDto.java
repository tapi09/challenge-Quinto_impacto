package com.challenge.universidad.dto;

import com.challenge.universidad.model.Curso;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDto {

    private Long id;
    private String nombre;
    private Integer edad;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nacimiento;
    private String historia;
    private List<CursoDto> cursos;
}
