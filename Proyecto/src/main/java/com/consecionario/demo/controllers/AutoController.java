package com.consecionario.demo.controllers;

import com.consecionario.demo.domain.Auto;
import com.consecionario.demo.services.AutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autos")
@CrossOrigin(origins = "*")
public class AutoController {

    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping
    public List<Auto> obtenerTodos() {
        return autoService.listarAutos();
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
}
