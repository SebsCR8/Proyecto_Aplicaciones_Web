/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.consecionario.demo.services;

import com.consecionario.demo.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listarClientes();
    Usuario obtenerClientePorId(Long id);
    Usuario guardarCliente(Usuario cliente);
    Usuario actualizarCliente(Long id, Usuario cliente);
    void eliminarCliente(Long id);
}
