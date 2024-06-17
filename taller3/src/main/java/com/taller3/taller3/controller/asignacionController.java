package com.taller3.taller3.controller;

import com.taller3.taller3.entity.Persona;
import com.taller3.taller3.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asignacionequipos")
public class asignacionController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/{id}")
    public String mostrarAsignacionEquipos(@PathVariable Long id, Model model) {
        // Recuperar la persona con el ID proporcionado
        Persona persona = personaService.obtenerPorId(id);

        // Verificar si la persona existe
        if (persona == null) {
            return "redirect:/personas";
        }

        // Pasar la persona al modelo
        model.addAttribute("persona", persona);

        return "asignacionequipos";
    }
}
