/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consecionario.demo.seviceimp;

import com.consecionario.demo.domain.Auto;
import com.consecionario.demo.repositories.AutoRepository;
import org.springframework.stereotype.Service;
import com.consecionario.demo.services.AutoService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AutoServiceImp implements AutoService {
    private final AutoRepository autoRepository;

    public AutoServiceImp(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    @Override
    public List<Auto> listarAutos() {
        return autoRepository.findAll();
    }

    @Override
    public Auto obtenerAutoPorId(Long id) {
        return autoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Auto no encontrado con ID: " + id));
    }

    @Override
    public Auto guardarAuto(Auto auto) {
        return autoRepository.save(auto);
    }

    @Override
    public Auto actualizarAuto(Long id, Auto auto) {
        if (!autoRepository.existsById(id)) {
            throw new EntityNotFoundException("Auto no encontrado con ID: " + id);
        }
        auto.setId(id);
        return autoRepository.save(auto);
    }

    @Override
    public void eliminarAuto(Long id) {
        if (!autoRepository.existsById(id)) {
            throw new EntityNotFoundException("Auto no encontrado con ID: " + id);
        }
        autoRepository.deleteById(id);
    }
}
