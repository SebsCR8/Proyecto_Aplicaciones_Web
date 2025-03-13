/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consecionario.demo.services;

import com.consecionario.demo.domain.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> listarVentas();
    Venta obtenerVentaPorId(Long id);
    Venta registrarVenta(Venta venta);
    Venta actualizarVenta(Long id, Venta venta);
    void eliminarVenta(Long id);
}