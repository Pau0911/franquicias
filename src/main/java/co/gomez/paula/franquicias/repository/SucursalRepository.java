package co.gomez.paula.franquicias.repository;

import co.gomez.paula.franquicias.dto.StockDTO;
import co.gomez.paula.franquicias.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SucursalRepository extends JpaRepository<Sucursal, UUID> {

    @Query(""" 
            SELECT new co.gomez.paula.franquicias.dto.StockDTO(s.id, s.nombre, p.id, p.nombre, p.stock)  
            FROM Producto p JOIN p.sucursal s 
            WHERE s.idFranquicia= :idFranquicia
            AND p.stock = (
              SELECT MAX(p2.stock)
              FROM Producto p2
              WHERE p2.idSucursal = p.idSucursal
            )
            """)
    List<StockDTO> listarProductosMayorStockxSucursal(UUID idFranquicia);

    @Modifying
    @Query("UPDATE Sucursal s SET s.nombre= :nuevoNombre WHERE s.id = :idSucursal")
    int actualizarNombre(UUID idSucursal, String nuevoNombre);
}
