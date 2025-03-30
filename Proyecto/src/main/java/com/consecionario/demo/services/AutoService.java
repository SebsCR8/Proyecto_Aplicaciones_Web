/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consecionario.demo.services;

import com.consecionario.demo.domain.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> listarAutos();
    Auto obtenerAutoPorId(Long id);
    Auto guardarAuto(Auto auto);
    Auto actualizarAuto(Long id, Auto auto);
    void eliminarAuto(Long id);

   
}
