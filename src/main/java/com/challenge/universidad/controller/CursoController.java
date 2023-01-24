package com.challenge.universidad.controller;

import com.challenge.universidad.dto.CursoDto;
import com.challenge.universidad.mapper.CursoMapper;
import com.challenge.universidad.model.Curso;
import com.challenge.universidad.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoMapper mapper;
    private final CursoService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<CursoDto> cursos = mapper.cursoListToCursoDtoList(service.listar());
        model.addAttribute("cursos", cursos);
        return "curso";
    }
    @PostMapping("/guardar")
    public String guardar(CursoDto dto){
        Curso curso = mapper.cursoDtoToCurso(dto);
        service.guardar(curso);
        return "";
    }

    @PostMapping("/eliminar")
    public String eliminar(Long id){
        service.eliminar(id);
        return "";
    }

}
