package org.example.lab05_20192434.Controller;

import org.example.lab05_20192434.Repository.CancionesRepository;
import org.example.lab05_20192434.Repository.FrasesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recursos")
public class RecursosController {

    //repositorios
    final CancionesRepository cancionesRepository;
    final FrasesRepository frasesRepository;

    public RecursosController(CancionesRepository cancionesRepository, FrasesRepository frasesRepository) {
        this.cancionesRepository = cancionesRepository;
        this.frasesRepository = frasesRepository;
    }


    //vista principal
    @GetMapping("")
    public String recursos(Model model) {

        List<String> listaTipo0 = cancionesRepository.findByTipoCancion0();
        List<String> listaTipo1 = cancionesRepository.findByTipoCancion1();
        List<String> listaTipo2 = cancionesRepository.findByTipoCancion2();
        List<String> listaFrases = frasesRepository.findByFrases();

        // Calcular el número de canciones por tipo
        int countTipo0 = listaTipo0.size();
        int countTipo1 = listaTipo1.size();
        int countTipo2 = listaTipo2.size();


        model.addAttribute("listaTipo0", listaTipo0);
        model.addAttribute("listaTipo1", listaTipo1);
        model.addAttribute("listaTipo2", listaTipo2);
        model.addAttribute("listaFrases", listaFrases);
        model.addAttribute("countTipo0", countTipo0);
        model.addAttribute("countTipo1", countTipo1);
        model.addAttribute("countTipo2", countTipo2);

        return "Recursos/listaRecursos";
    }

}
