package com.smartdealercrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("content", "fragments/contenido :: content");
        return "index";
    }

    @GetMapping("/citas")
    public String citas(Model model) {
        model.addAttribute("title", "Agendar Cita");
        return "citas";
    }

    @GetMapping("/citas_programadas_carro")
    public String citasProgramadas(Model model) {
        model.addAttribute("title", "Citas Programadas");
        model.addAttribute("citas", java.util.Collections.emptyList());
        return "citas_programadas_carro";
    }

    @GetMapping("/tipos-carro")
    public String catalogoTemporal(Model model) {
        model.addAttribute("title", "Catálogo de Vehículos");
        model.addAttribute("totalAutos", 6);
        model.addAttribute("content", "fragments/contenido :: content");
        return "tipos-carro";
    }
}
