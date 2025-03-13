package com.consecionario.demo.controllers;

import com.consecionario.demo.domain.Citas;
import com.consecionario.demo.services.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CitasController {
    
    @Autowired
    private CitasService citasService;
    
    @GetMapping("/citas_programadas_carro")
    public String mostrarFormularioCitas(Model model) {
        var citas = citasService.getCitas(true);
        
        model.addAttribute("citas", citas);
        return "citas_programadas_carro"; // Nombre de la vista HTML
    }
    
    @PostMapping("/solicitar_carro")
    public String solicitarCita(@RequestParam String marca, 
                            @RequestParam String modelo, 
                            @RequestParam String año, 
                            @RequestParam String placa, 
                            @RequestParam String telefono_contacto, 
                            @RequestParam String motivo,
                            RedirectAttributes redirectAttributes) {

        Citas nuevaCitas = new Citas();
        nuevaCitas.setMarca(marca);
        nuevaCitas.setModelo(modelo);
        nuevaCitas.setAño(año);
        nuevaCitas.setPlaca(placa);
        nuevaCitas.setTelefonoContacto(telefono_contacto); // Método corregido
        nuevaCitas.setNotas(motivo); // Se usa "notas" porque no hay "motivo" en Citas

        citasService.guardarCitas(nuevaCitas); // Corrección de variable

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:citas_programadas_carro";
    }
}


