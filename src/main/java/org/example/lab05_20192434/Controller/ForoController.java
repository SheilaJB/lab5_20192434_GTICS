package org.example.lab05_20192434.Controller;

import org.example.lab05_20192434.Entity.Foro;
import org.example.lab05_20192434.Repository.ForoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/foro")
public class ForoController {

    //Repositorios
    final ForoRepository foroRepository;

    public ForoController(ForoRepository foroRepository) {
        this.foroRepository = foroRepository;
    }


    //Vista principal
    @GetMapping("/comunidad")
    public String foro(Model model) {
        List<Foro> comentarios = foroRepository.findAll();
        model.addAttribute("comentarios", comentarios);

        return "Foro/foro";
    }

    @GetMapping("/nuevoComentario")
    public String nuevoComentario() {
        return "Foro/nuevoM";
    }

    @PostMapping("/enviarComentario")
    public String enviarComentario(
            @RequestParam("nombrePersona") String nombrePersona,
            @RequestParam("edad") int edad,
            @RequestParam("comentario") String comentario,
            RedirectAttributes redirectAttributes) {

        // Crear un nuevo objeto Foro
        Foro nuevoComentario = new Foro();
        List<Foro> comentarios = foroRepository.findAll();
        int newId= comentarios.size() +1;

        nuevoComentario.setIdForo(newId);
        nuevoComentario.setNombrePersona(nombrePersona);
        nuevoComentario.setEdad(edad);
        nuevoComentario.setComentario(comentario);

        // Guardar el comentario en la base de datos
        foroRepository.save(nuevoComentario);

        // Agregar un mensaje de éxito
        redirectAttributes.addAttribute("successMessage", "Comentario enviado con éxito!");
        return "redirect:/foro/nuevoComentario";
    }
}
