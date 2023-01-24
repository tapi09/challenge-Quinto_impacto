package com.challenge.universidad.service.impl;

import com.challenge.universidad.model.Alumno;
import com.challenge.universidad.repository.AlumnoRepository;
import com.challenge.universidad.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository repository;
    @Transactional
    @Override
    public Alumno guardar(Alumno alumno){
        return repository.save(alumno);
    }
    @Transactional
    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Alumno buscarPorId(Long id)  {
        Optional<Alumno> optional= repository.findById(id);
        if (optional.isPresent()){
            Alumno alumno = optional.get();
            return alumno;
        }else{
            return null;
        }
    }

    @Override
    public List<Alumno> buscar(String cadena) {
        cadena = "%"+ cadena + "%";
        List<Alumno> encontrados = repository.buscarCadena(cadena);
        System.out.println(encontrados);
        return encontrados;
    }

    @Override
    public List<Alumno> listar() {
        return repository.findAll();
    }


}
