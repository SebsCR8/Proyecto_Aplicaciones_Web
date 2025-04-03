package com.consecionario.demo.repositories;

/**
 *
 * @author sebas
 */
import com.consecionario.demo.domain.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long> {
   @Query("SELECT a FROM Auto a WHERE a.tipo = :tipo AND a.marca.nombreMarca = :marca AND a.precio <= :precioMax")
List<Auto> filtrarVehiculos(@Param("tipo") String tipo,
                            @Param("marca") String marca,
                            @Param("precioMax") Double precioMax);
}

