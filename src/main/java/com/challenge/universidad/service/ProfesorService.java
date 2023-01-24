package com.challenge.universidad.service;

import com.challenge.universidad.model.Profesor;

import java.util.List;

public interface ProfesorService {
    Profesor guardar(Profesor profesor);
    List<Profesor> listarTodos();
    void eliminar(Long id);
    Profesor buscarPorId(Long id);
}
