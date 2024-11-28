package co.gomez.paula.franquicias.repository;

import co.gomez.paula.franquicias.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductoRepository extends JpaRepository<Producto, UUID> {

    @Modifying
    @Query("UPDATE Producto p SET p.stock = :nuevoStock WHERE p.id = :idProducto")
    int modificarStock(@Param("id") UUID idProducto, @Param("nuevoStock") int nuevoStock);

    @Modifying
    @Query("UPDATE Producto p SET p.nombre= :nuevoNombre WHERE p.id = :idProducto")
    int actualizarNombre(UUID idProducto, String nuevoNombre);
}
