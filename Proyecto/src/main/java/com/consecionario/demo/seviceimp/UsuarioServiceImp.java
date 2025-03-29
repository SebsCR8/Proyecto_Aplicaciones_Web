/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.consecionario.demo.seviceimp;

import com.consecionario.demo.domain.Usuario;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import com.consecionario.demo.repositories.UsuarioRepository;
import com.consecionario.demo.services.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
    private final UsuarioRepository clienteRepository;

    public UsuarioServiceImp(UsuarioRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Usuario> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Usuario obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con ID: " + id));
    }

    @Override
    public Usuario guardarCliente(Usuario cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Usuario actualizarCliente(Long id, Usuario cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente no encontrado con ID: " + id);
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Cliente no encontrado con ID: " + id);
        }
        clienteRepository.deleteById(id);
    }
}
