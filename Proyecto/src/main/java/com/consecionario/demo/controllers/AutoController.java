package com.consecionario.demo.controllers;

import com.consecionario.demo.domain.Auto;
import com.consecionario.demo.services.AutoService;
import com.consecionario.demo.seviceimp.FirebaseStorageServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/autos")
@CrossOrigin(origins = "*")
public class AutoController {

    @Autowired
    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/tipos-carros")
    public String obtenerTodos(Model model) {
        var autos = autoService.listarAutos();
        model.addAttribute("totalAutos", obtenerTodos(model));
        return "/auto/tipos-carro";
    }

    @GetMapping("/{id}")
    public Auto obtenerPorId(@PathVariable Long id) {
        return autoService.obtenerAutoPorId(id);
    }

    @PostMapping
    public Auto agregarAuto(@RequestBody Auto auto) {
        return autoService.guardarAuto(auto);
    }

    @PutMapping("/{id}")
    public Auto actualizarAuto(@PathVariable Long id, @RequestBody Auto auto) {
        return autoService.actualizarAuto(id, auto);
    }

    @DeleteMapping("/{id}")
    public void eliminarAuto(@PathVariable Long id) {
        autoService.eliminarAuto(id);
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    /*@PostMapping("/guardar")
    public String autoGuardar(Auto auto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            autoService.guardarAuto(auto);
            auto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                           auto.getIdAuto()));
        }
        autoService.guardarAuto(auto);
        return "redirect:/categoria/listado";
    }
*/
    @GetMapping("/eliminar/{idCategoria}")
    public String autoEliminar(Auto auto) {
        autoService.eliminarAuto(Long.MIN_VALUE);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idCategoria}")
    public String autoModificar(Auto auto, Model model) {
        auto = autoService.obtenerAutoPorId(Long.MIN_VALUE);
        model.addAttribute("Auto", auto);
        return "/categoria/modifica";
    }
}
