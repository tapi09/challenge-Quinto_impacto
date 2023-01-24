package com.challenge.universidad.service;

import com.challenge.universidad.model.Alumno;

import java.util.List;

public interface AlumnoService {
    Alumno guardar(Alumno alumno);
    void eliminar(Long id) ;
    Alumno buscarPorId(Long id) ;
    List<Alumno> buscar(String cadena);
    List<Alumno> listar();
}
