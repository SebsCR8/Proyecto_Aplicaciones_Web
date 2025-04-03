package com.consecionario.demo.repositories;

/**
 *
 * @author rosca
 */

import com.consecionario.demo.domain.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CitasRepository extends JpaRepository<Citas, Integer> {
    // Consulta para obtener citas con datos completos del usuario y auto
    @Query("SELECT c FROM Citas c JOIN FETCH c.usuario JOIN FETCH c.auto")
    List<Citas> obtenerCitasConDetalles();

    
    List<Citas> findByUsuarioId(Integer idUsuario);
    List<Citas> findByAutoId(Integer idAuto);

}
