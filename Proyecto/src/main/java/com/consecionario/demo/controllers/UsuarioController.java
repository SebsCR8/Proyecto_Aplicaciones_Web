
package com.consecionario.demo.controllers;

/**
 *
 * @author sebas
 */
import com.consecionario.demo.domain.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.consecionario.demo.services.UsuarioService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class UsuarioController {
    private final UsuarioService clienteService;

    public UsuarioController(UsuarioService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerClientePorId(id);
    }

    @PostMapping
    public Usuario agregarCliente(@RequestBody Usuario cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Usuario actualizarCliente(@PathVariable Long id, @RequestBody Usuario cliente) {
        return clienteService.actualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}