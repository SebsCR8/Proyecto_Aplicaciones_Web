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
    @Query(value = "SELECT * FROM Auto a JOIN Marca m ON a.ID_Marca = m.ID_Marca " +
               "WHERE a.Tipo = :tipo AND m.NombreMarca = :marca AND a.Precio <= :precioMax", nativeQuery = true)
List<Auto> filtrarVehiculos(@Param("tipo") String tipo,
                            @Param("marca") String marca,
                            @Param("precioMax") String precioMax); 

}

