package org.example.lab05_20192434.Controller;


import org.example.lab05_20192434.Entity.Areas;
import org.example.lab05_20192434.Entity.Fechas;
import org.example.lab05_20192434.Entity.Profesionales;
import org.example.lab05_20192434.Entity.Sedes;
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
    final AreasRepository areasRepository;
    final FechaRepository fechaRepository;
    final SedeRepository sedeRepository;
    final RiesgoRepository riesgoRepository;


    public ProfesionalController(ProfesionalRepository profesionalRepository, AreasRepository areasRepository, FechaRepository fechaRepository, SedeRepository sedeRepository, RiesgoRepository riesgoRepository) {
        this.profesionalRepository = profesionalRepository;

        this.areasRepository = areasRepository;
        this.fechaRepository = fechaRepository;
        this.sedeRepository = sedeRepository;
        this.riesgoRepository = riesgoRepository;
    }
    //Lista de profesionales
    @GetMapping("/listar")
    public String listar(Model model) {


        List<Profesionales> listaProfe = profesionalRepository.findAll();
        List<Areas> listaAreas = areasRepository.findAll();
        List<Sedes>  listaSedes = sedeRepository.findAll();
        List<Fechas>  listaFecha = fechaRepository.findAll();


        model.addAttribute("listaProfe", listaProfe);
        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("listaSedes", listaSedes);
        model.addAttribute("listaFecha", listaFecha);

        return "Profesionales/list";
    }
}
