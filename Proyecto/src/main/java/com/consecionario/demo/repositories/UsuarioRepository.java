package com.consecionario.demo.repositories;

/**
 *
 * @author sebas
 */
import com.consecionario.demo.domain.Usuario;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Buscar por correo (por ejemplo para login)
    Optional<Usuario> findByCorreo(String correo);

    // Buscar por nombre exacto
    Optional<Usuario> findByNombre(String nombre);

    // Buscar por rol (ej. ADMIN, CLIENTE, etc.)
    List<Usuario> findByRol(String rol);
}
