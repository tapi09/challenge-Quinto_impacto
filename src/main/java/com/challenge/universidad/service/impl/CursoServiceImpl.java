package com.challenge.universidad.service.impl;

import com.challenge.universidad.model.Curso;
import com.challenge.universidad.repository.CursoRepository;
import com.challenge.universidad.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repositorio;
    @Transactional
    @Override
    public Curso guardar(Curso curso) {
        return repositorio.save(curso);
    }

    @Override
    public List<Curso> listar() {
        return repositorio.findAll();
    }
    @Transactional
    @Override
    public void eliminar(Long id) {
        Curso curso = buscarPorId(id);
        repositorio.delete(curso);

    }
    @Override
    public Curso buscarPorId(Long id){
        Optional<Curso> optional = repositorio.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
