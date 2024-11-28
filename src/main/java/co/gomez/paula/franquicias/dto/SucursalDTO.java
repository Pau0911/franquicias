package co.gomez.paula.franquicias.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class SucursalDTO {
    private UUID id;
    private UUID idFranquicia;
    private String nombre;
}
