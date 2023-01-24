package com.challenge.universidad.mapper;

import com.challenge.universidad.dto.AlumnoDto;
import com.challenge.universidad.model.Alumno;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface AlumnoMapper {

    Alumno alumnoDtoToAlumno(AlumnoDto dto);
    @Named("alumnoToAlumnoDto")
    AlumnoDto alumnoToAlumnoDto(Alumno alumno);

    @IterableMapping(qualifiedByName = "alumnoToAlumnoDto")
    List<AlumnoDto> alumnoListToAlumnoDtoList(List<Alumno> alumnos);
}
