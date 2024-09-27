package org.example.lab05_20192434.Controller;

import org.example.lab05_20192434.Entity.*;
import org.example.lab05_20192434.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitaController {

    final CitaRepository citaRepository;
    final AreasRepository areasRepository;
    final FechaRepository fechaRepository;
    final SedeRepository sedeRepository;
    final RiesgoRepository riesgoRepository;
    final ProfesionalRepository profesionalRepository;
    final PacienteRepository pacienteRepository;


    public CitaController(CitaRepository citaRepository, AreasRepository areasRepository, FechaRepository fechaRepository, SedeRepository sedeRepository, RiesgoRepository riesgoRepository, ProfesionalRepository profesionalRepository, PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.areasRepository = areasRepository;
        this.fechaRepository = fechaRepository;
        this.sedeRepository = sedeRepository;
        this.riesgoRepository = riesgoRepository;
        this.profesionalRepository = profesionalRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping("/reservar")
    public String reservarCita(@ModelAttribute("cita") Citas cita, RedirectAttributes redirectAttributes) {
        // Validar si el profesional coincide con su área
        if (!cita.getProfesionales().getArea().equals(cita.getArea())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El profesional no coincide con su área de especialidad.");
            return "redirect:/citas/reservarCita";
        }

        // Validar si el profesional está disponible en la sede seleccionada
        if (!cita.getProfesionales().getSede().equals(cita.getSede())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El profesional no está disponible en la sede seleccionada.");
            return "redirect:/citas/reservarCita";
        }

        // Validar si el profesional está disponible en la fecha seleccionada
        if (!cita.getProfesionales().getFechasDisponibles().contains(cita.getFecha())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El profesional no está disponible en la fecha seleccionada.");
            return "redirect:/citas/reservarCita";
        }

        // Guardar la cita si todas las validaciones son correctas
        citaRepository.save(cita);
        redirectAttributes.addFlashAttribute("successMessage", "Cita reservada con éxito.");
        return "redirect:/citas/reservarCita";
    }

    @GetMapping("/reservarCita")
    public String mostrarFormulario(Model model) {

        List<Areas>  listaAreas = areasRepository.findAll();
        List<Sedes>  listaSedes = sedeRepository.findAll();
        List<Riesgos>  listaRiesgos = riesgoRepository.findAll();
        List<Profesionales>  listaProfe = profesionalRepository.findAll();
        List<Fechas>  listaFecha = fechaRepository.findAll();
        List<Pacientes> paciente = pacienteRepository.findAll();


        System.out.println("Áreas encontradas: " + listaAreas.size());
        System.out.println("Sedes encontradas: " + listaSedes.size());
        System.out.println("Riesgos encontrados: " + listaRiesgos.size());

        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("listaSedes", listaSedes);
        model.addAttribute("listaRiesgos", listaRiesgos);
        model.addAttribute("listaProfe", listaProfe);
        model.addAttribute("listaFecha", listaFecha);
        model.addAttribute("paciente", paciente);


        return "Citas/form";
    }
}
