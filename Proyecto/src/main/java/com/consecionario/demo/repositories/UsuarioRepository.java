package com.consecionario.demo.repositories;

/**
 *
 * @author sebas
 */
import com.consecionario.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aqui pueden ir metodos personalizados
}
