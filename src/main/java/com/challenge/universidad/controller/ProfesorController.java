package com.challenge.universidad.controller;

import com.challenge.universidad.dto.ProfesorDto;
import com.challenge.universidad.mapper.CursoMapper;
import com.challenge.universidad.mapper.ProfesorMapper;

import com.challenge.universidad.model.Curso;
import com.challenge.universidad.model.Profesor;
import com.challenge.universidad.service.CursoService;
import com.challenge.universidad.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {

        private final ProfesorService service;
        private final ProfesorMapper mapper;
        private final CursoService cursoService;
        private final CursoMapper cursoMapper;


        @GetMapping("/listar")
        public String listar(Model model, @RequestParam(required = false) Long id){
        List<Profesor> profesores = service.listarTodos();
        List<ProfesorDto> listDto= mapper.profesorListToProfesorDtoList(profesores);
        model.addAttribute("profesores", listDto);
        model.addAttribute("cursos", cursoService.listar());
                if(id != null){
                        model.addAttribute("profesor", service.buscarPorId(id));
                }

        return "profesor";
        }

        @PostMapping("/guardar")
        public String guardar(ProfesorDto dto, @RequestParam(required = false) List<Long> listId){
                System.out.println(listId);

            Profesor profesor = mapper.profesorDtoToProfesor(dto);
                if(listId != null){
                        List <Curso> cursos = listId.stream()
                                .map(
                                        id -> {
                                                Curso curso = cursoService.buscarPorId(id);
                                                return curso;
                                        }).collect(Collectors.toList());
                        profesor.setCursos(cursos);
                }
            service.guardar(profesor);
            return "redirect:/profesor/listar";
        }
        @PostMapping("/eliminar/{id}")
        public String eliminar(@PathVariable(name = "id") Long id){
                service.eliminar(id);
                return "redirect:/profesor/listar";
        }


}
