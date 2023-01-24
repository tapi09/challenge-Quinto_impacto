package com.challenge.universidad.mapper;

import com.challenge.universidad.dto.CursoDto;
import com.challenge.universidad.model.Curso;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface CursoMapper {

    Curso cursoDtoToCurso(CursoDto dto);

    @Named("cursoToCursoDto")
    CursoDto cursoToCursoDto(Curso curso);

    @IterableMapping(qualifiedByName = "cursoToCursoDto")
    List<CursoDto> cursoListToCursoDtoList(List<Curso> cursos);
}
