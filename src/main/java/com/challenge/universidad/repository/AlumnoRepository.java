package com.challenge.universidad.repository;

import com.challenge.universidad.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query("SELECT a FROM alumno a WHERE UPPER(a.nombre) LIKE UPPER(:cadena)")
    List<Alumno> buscarCadena(@Param("cadena") String cadena);
}
