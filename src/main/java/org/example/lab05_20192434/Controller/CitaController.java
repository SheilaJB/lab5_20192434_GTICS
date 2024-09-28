package org.example.lab05_20192434.Controller;

import org.example.lab05_20192434.Entity.*;
import org.example.lab05_20192434.Repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.awt.geom.Area;
import java.util.ArrayList;
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

    //Vista principal
    @GetMapping("/lista")
    public String listarCitas(Model model) {
        List<Citas> listaCitas = citaRepository.findAll();
        List<Areas> listaAreas = areasRepository.findAll();
        List<Sedes>  listaSedes = sedeRepository.findAll();
        List<Riesgos>  listaRiesgos = riesgoRepository.findAll();
        List<Profesionales>  listaProfe = profesionalRepository.findAll();
        List<Fechas>  listaFecha = fechaRepository.findAll();


        model.addAttribute("listaCitas", listaCitas);
        model.addAttribute("listaAreas", listaAreas);
        model.addAttribute("listaSedes", listaSedes);
        model.addAttribute("listaRiesgos", listaRiesgos);
        model.addAttribute("listaProfe", listaProfe);
        model.addAttribute("listaFecha", listaFecha);


        return "Citas/listaCitas";
    }

    @GetMapping("/estadistica")
    public String estadistica(Model model) {
        // Obtener número de citas por sede
        List<Object[]> citasPorSede = citaRepository.obtenerCitasPorSede();
        // Obtener número de citas por especialidad
        List<Object[]> citasPorEspecialidad = citaRepository.obtenerCitasPorEspecialidad();
        // Obtener número de citas por profesional
        List<Object[]> citasPorProfesional = citaRepository.obtenerCitasPorProfesional();

        model.addAttribute("citasPorSede", citasPorSede);
        model.addAttribute("citasPorEspecialidad", citasPorEspecialidad);
        model.addAttribute("citasPorProfesional", citasPorProfesional);
        return "Citas/infoC";

    }





    @PostMapping("/reservar")
    public String reservarCita(@ModelAttribute("cita") Citas cita, RedirectAttributes redirectAttributes, @RequestParam("nombrePaciente") String nombrePaciente,
                                                                                            @RequestParam("dni") String dni, @RequestParam("edad") int edad ) {
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
        if (!cita.getProfesionales().getIdProfesionales().equals(cita.getFecha().getProfesionales().getIdProfesionales())) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error: El profesional no está disponible en la fecha seleccionada.");

            return "redirect:/citas/reservarCita";
        }

        // Guardar la cita si todas las validaciones son correctas
        //List<Pacientes> totalPacientes = pacienteRepository.findAll();
        //int newId= totalPacientes.size() + 1;
        Pacientes newPaciente = new Pacientes();
        newPaciente.setNombrePaciente(nombrePaciente);
        newPaciente.setDni(dni);
        newPaciente.setEdad(edad);
        //newPaciente.setIdPacientes(newId);
        pacienteRepository.save(newPaciente);

        cita.setPaciente(newPaciente);
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
