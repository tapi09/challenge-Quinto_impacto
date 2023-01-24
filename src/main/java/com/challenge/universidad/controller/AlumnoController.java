package com.challenge.universidad.controller;

import com.challenge.universidad.dto.AlumnoDto;
import com.challenge.universidad.mapper.AlumnoMapper;
import com.challenge.universidad.model.Alumno;
import com.challenge.universidad.service.AlumnoService;
import com.challenge.universidad.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/alumno")
public class AlumnoController {

    private final AlumnoService service;
    private final AlumnoMapper mapper;
    private final CursoService cursoService;

    @PostMapping("/crear")
    public String crear(Model model, AlumnoDto dto){
        try {
            Alumno alumno = mapper.alumnoDtoToAlumno(dto);
            service.guardar(alumno);
        }catch (Exception e){
            model.addAttribute("error", e.getMessage());
        }

        return "redirect:/alumno/listartodos";
    }
    @GetMapping("/listartodos")
    public String listar(Model model, @RequestParam(required = false) Long id ){
        List<Alumno> alumnos = service.listar();
        List<AlumnoDto> lista = mapper.alumnoListToAlumnoDtoList(alumnos);
        model.addAttribute("alumnos", lista);
        model.addAttribute("cursos", cursoService.listar());
        if(id != null){
            model.addAttribute("alumno", service.buscarPorId(id));
        }
        return "alumnos";
    }
    @GetMapping("/buscar")
    public String buscar(String cadena, Model model) {
        System.out.println(cadena);
        List<Alumno> coincidencias = service.buscar(cadena);
        List<AlumnoDto> listDto = mapper.alumnoListToAlumnoDtoList(coincidencias);
        model.addAttribute("alumnos", listDto);
        return "alumnos";
    }
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(name = "id") Long id){
        service.eliminar(id);
        return "redirect:/alumno/listartodos";
    }
}
