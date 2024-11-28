package co.gomez.paula.franquicias.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductoDTO {
    private UUID id;
    private UUID idSucursal;
    private String nombre;
    private Integer stock;
}
