package com.consecionario.demo.repositories;

/**
 *
 * @author sebas
 */
import com.consecionario.demo.domain.Venta;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    // Buscar ventas por ID de usuario
    List<Venta> findByIdUsuario(Integer idUsuario);

    // Buscar ventas por ID de auto
    List<Venta> findByIdAuto(Integer idAuto);

    // Buscar ventas por fecha
    List<Venta> findByFechaVenta(Date fecha);

    // Buscar ventas entre dos fechas
    List<Venta> findByFechaVentaBetween(Date desde, Date hasta);
}
