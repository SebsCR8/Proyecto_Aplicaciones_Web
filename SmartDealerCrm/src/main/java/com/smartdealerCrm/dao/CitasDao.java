package com.smartdealerCrm.dao;

/**
 *
 * @author rosca
 */

import com.smartdealerCrm.domain.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CitasDao extends JpaRepository<Citas, Integer> {

}
