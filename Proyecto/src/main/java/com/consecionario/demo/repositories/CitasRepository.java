package com.consecionario.demo.repositories;

/**
 *
 * @author rosca
 */

import com.consecionario.demo.domain.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CitasRepository extends JpaRepository<Citas, Integer> {
   
    @Query("SELECT c FROM Citas c WHERE c.usuario.id = :idUsuario")
    List<Citas> findByUsuario(@Param("idUsuario") Integer idUsuario);

    
    @Query("SELECT c FROM Citas c WHERE c.auto.id = :idAuto")
    List<Citas> findByAuto(@Param("idAuto") Integer idAuto);

    
    @Query("SELECT c FROM Citas c WHERE c.enganche >= :minEnganche")
    List<Citas> findByEngancheMayorA(@Param("minEnganche") Double minEnganche);
}
