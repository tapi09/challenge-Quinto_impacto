package com.challenge.universidad.service;

import com.challenge.universidad.model.Curso;

import java.util.List;

public interface CursoService {

    Curso guardar(Curso curso);
    List<Curso> listar();
    void eliminar(Long id);
    Curso buscarPorId(Long id);

}
