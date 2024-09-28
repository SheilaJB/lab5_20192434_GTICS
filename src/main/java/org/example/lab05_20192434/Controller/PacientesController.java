package org.example.lab05_20192434.Controller;

import org.example.lab05_20192434.Entity.Citas;
import org.example.lab05_20192434.Entity.Pacientes;
import org.example.lab05_20192434.Repository.CitaRepository;
import org.example.lab05_20192434.Repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacientesController {

    //repositorios
    final PacienteRepository pacienteRepository;
    final CitaRepository citaRepository;

    public PacientesController(PacienteRepository pacienteRepository, CitaRepository citaRepository) {
        this.pacienteRepository = pacienteRepository;
        this.citaRepository = citaRepository;
    }

    //vista principal
    @GetMapping("/listaP")
    public String listaP(Model model) {
        List<Pacientes> pacientes = pacienteRepository.findAll();
        List<Citas> citas = citaRepository.findAll();
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("citas", citas);

        List<Object[]> pacientesPorRiesgo = citaRepository.obtenerNumeroPacientesPorRiesgo();
        model.addAttribute("pacientesPorRiesgo", pacientesPorRiesgo);

        return "Pacientes/listaP";

    }


}
