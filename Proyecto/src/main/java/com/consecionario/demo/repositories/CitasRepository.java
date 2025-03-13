package com.consecionario.demo.repositories;

/**
 *
 * @author rosca
 */

import com.consecionario.demo.domain.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CitasRepository extends JpaRepository<Citas, Integer> {

}
