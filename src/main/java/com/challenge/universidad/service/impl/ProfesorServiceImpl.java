package com.challenge.universidad.service.impl;

import com.challenge.universidad.model.Profesor;
import com.challenge.universidad.repository.ProfesorRepository;
import com.challenge.universidad.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository repositorio;
    @Transactional
    @Override
    public Profesor guardar(Profesor profesor) {
        return repositorio.save(profesor);
    }

    @Override
    public List<Profesor> listarTodos() {
        return repositorio.findAll();
    }
    @Transactional
    @Override
    public void eliminar(Long id) {
        Profesor profesor = buscarPorId(id);
        repositorio.delete(profesor);
    }

    public Profesor buscarPorId(Long id) {
        Optional<Profesor> optional= repositorio.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
