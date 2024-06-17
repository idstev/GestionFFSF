package com.taller3.taller3.controller;

import com.taller3.taller3.entity.Persona;
import com.taller3.taller3.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    @GetMapping
    public String listarPersonas(Model model){
        List<Persona> personas = personaService.obtenerTodas();
        model.addAttribute("listaPersonas",personas);
        return "listar";
    }
    @GetMapping("/nueva")
    public String mostrarFormularioDeNuevaPersona(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("accion","/personas/nueva");
        return "formulario";
    }
    @PostMapping("/nueva")
    public String guardarNuevaPersona(@ModelAttribute Persona persona){
        personaService.crearPersona(persona);
        return "redirect:/personas";
    }
    @GetMapping("editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        // Recuperar la persona con el ID proporcionado
        Persona persona = personaService.obtenerPorId(id);

        // Verificar si la persona existe
        if (persona == null) {
            // Manejar el caso en el que la persona no existe
            // Por ejemplo, redirigiendo a una página de error o mostrando un mensaje adecuado
            return "redirect:/personas"; // Redirigir a la lista de personas
        }

        // Pasar la persona al modelo
        model.addAttribute("persona", persona);
        model.addAttribute("accion", "/personas/editar/" + id);

        return "formulario";
    }

    @PostMapping("editar/{id}")
    public String actualizarPersona(@PathVariable Long id, @ModelAttribute Persona persona){
        personaService.actualizarPersona(id,persona);
        return "redirect:/personas";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return "redirect:/personas";
    }
}
