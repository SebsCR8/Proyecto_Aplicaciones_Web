package com.consecionario.demo.controllers;


import com.consecionario.demo.domain.Citas;
import com.consecionario.demo.domain.Usuario;
import com.consecionario.demo.domain.Auto;
import com.consecionario.demo.services.CitasService;
import com.consecionario.demo.services.UsuarioService;
import com.consecionario.demo.services.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class CitasController {

    @Autowired
    private CitasService citasService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutoService autoService;

   
    @GetMapping("/citas_programadas_carro")
    public String mostrarFormularioCitas(Model model) {
       
        var citas = citasService.getCitas(true);

        model.addAttribute("citas", citas);
        return "citas_programadas_carro";
    }

    @PostMapping("/solicitar_carro")
    public String solicitarCita(
            @RequestParam Integer idUsuario,
            @RequestParam Integer idAuto,  
            @RequestParam String enganche,  
            @RequestParam String tasaInteres, 
            @RequestParam Integer plazo,    
            @RequestParam String pagoMensual, 
            @RequestParam Date fechaCita,  
            RedirectAttributes redirectAttributes) {

        Usuario usuario = usuarioService.obtenerClientePorId(Long.MIN_VALUE);
        Auto auto = autoService.obtenerAutoPorId(Long.MIN_VALUE);

        if (usuario == null || auto == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario o Auto no encontrado.");
            return "redirect:/citas_programadas_carro";
        }

       
        Citas nuevaCita = new Citas();
        nuevaCita.setUsuario(usuario);
        nuevaCita.setAuto(auto);
        nuevaCita.setEnganche(enganche);
        nuevaCita.setTasaInteres(tasaInteres);
        nuevaCita.setPlazo(plazo);
        nuevaCita.setPagoMensual(pagoMensual);
        nuevaCita.setFechaCita(fechaCita);

       
        citasService.guardarCitas(nuevaCita);

        redirectAttributes.addFlashAttribute("success", "Cita programada exitosamente.");
        return "redirect/citas_programadas_carro";
    }
}