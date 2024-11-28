package co.gomez.paula.franquicias.repository;

import co.gomez.paula.franquicias.model.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface FranquiciaRepository extends JpaRepository<Franquicia, UUID> {

    @Modifying
    @Query("UPDATE Franquicia f SET f.nombre= :nuevoNombre WHERE f.id = :idFranquicia")
    int actualizarNombre(UUID idFranquicia, String nuevoNombre);
}
