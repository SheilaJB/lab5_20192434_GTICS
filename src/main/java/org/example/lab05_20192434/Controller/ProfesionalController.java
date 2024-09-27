package org.example.lab05_20192434.Controller;


import org.example.lab05_20192434.Entity.Profesionales;
import org.example.lab05_20192434.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalController {

    //Repositorios
    final ProfesionalRepository profesionalRepository;


    public ProfesionalController(ProfesionalRepository profesionalRepository) {
        this.profesionalRepository = profesionalRepository;

    }
    //Lista de profesionales
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Profesionales> listaProfe = profesionalRepository.findAll();
        model.addAttribute("listaProfe", listaProfe);
        return "Profesionales/list";
    }
}
