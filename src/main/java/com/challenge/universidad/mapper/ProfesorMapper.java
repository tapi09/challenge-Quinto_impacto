package com.challenge.universidad.mapper;

import com.challenge.universidad.dto.ProfesorDto;
import com.challenge.universidad.model.Profesor;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface ProfesorMapper {



    Profesor profesorDtoToProfesor(ProfesorDto dto);

    @Named("profesorToProfesorDto")
    ProfesorDto profesorToProfesorDto(Profesor profesor);

    @IterableMapping(qualifiedByName = "profesorToProfesorDto")
    List<ProfesorDto> profesorListToProfesorDtoList(List<Profesor> profesorList);

}
