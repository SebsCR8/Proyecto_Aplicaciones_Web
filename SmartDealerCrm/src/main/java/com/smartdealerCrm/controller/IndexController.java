package com.smartdealerCrm.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String inicio(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }

    @RequestMapping("/citas")
    public String citas(Model model) {
        model.addAttribute("attribute", "value");
        return "solicitud_de_citas";
    }

    @RequestMapping("/tipos-carros")
    public String tiposCarros(Model model) {
        model.addAttribute("attribute", "value");
        return "tipos-carros";
    }

    @RequestMapping("/acerca-de-nosotros")
    public String acercaDeNosotros(Model model) {
        model.addAttribute("attribute", "value");
        return "informacion";
    }

    @RequestMapping("/contactenos")
    public String contactenos(Model model) {
        model.addAttribute("attribute", "value");
        return "contactenos";
    }

//    @RequestMapping("/login")
//    public String login(Model model) {
//        model.addAttribute("attribute", "value");
//        return "login";
//    }
}

