package com.challenge.universidad.dao;

import com.challenge.universidad.entities.Alumno;
import com.challenge.universidad.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
