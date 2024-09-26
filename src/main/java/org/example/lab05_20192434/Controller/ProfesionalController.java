package org.example.lab05_20192434.Controller;


import org.example.lab05_20192434.Entity.Fechas;
import org.example.lab05_20192434.Entity.Profesionales;
import org.example.lab05_20192434.Repository.FechasRepository;
import org.example.lab05_20192434.Repository.ProfesionalRepository;
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
    final FechasRepository fechasRepository;

    public ProfesionalController(ProfesionalRepository profesionalRepository, FechasRepository fechasRepository) {
        this.profesionalRepository = profesionalRepository;
        this.fechasRepository = fechasRepository;
    }


    //Lista de profesionales
    @GetMapping("/listar")
    public String listar(Model model ) {

        List<Profesionales> listaProfe = profesionalRepository.findAll();
        model.addAttribute("listaProfe", listaProfe);
        return "Profesionales/list";
    }

    @GetMapping("/reservarCita")
    public String reservarCita(Model model) {
        List<Profesionales> listaProfe = profesionalRepository.findAll();
        List<Fechas> listaFecha = fechasRepository.findAll();
        model.addAttribute("listaProfe", listaProfe);
        model.addAttribute("listaFecha", listaFecha);
        return "Profesionales/form";
    }


}
