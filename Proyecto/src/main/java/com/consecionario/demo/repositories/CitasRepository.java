package com.consecionario.demo.repositories;

/**
 *
 * @author rosca
 */

import com.consecionario.demo.domain.Citas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Integer> {

    // Consulta para obtener citas con datos completos del usuario y auto
    @Query("SELECT c FROM Citas c JOIN FETCH c.usuario JOIN FETCH c.auto")
    List<Citas> obtenerCitasConDetalles();

    // filtros útiles
    List<Citas> findByUsuarioId(Integer idUsuario);
    List<Citas> findByAutoId(Integer idAuto);
}
