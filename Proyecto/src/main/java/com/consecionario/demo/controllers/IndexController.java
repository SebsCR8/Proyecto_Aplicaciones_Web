package com.consecionario.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("/index")
    public String inicio(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }

}