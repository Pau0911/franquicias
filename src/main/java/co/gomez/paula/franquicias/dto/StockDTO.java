package co.gomez.paula.franquicias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class StockDTO {
    private UUID idSucursal;
    private String nombreSucursal;
    private UUID idProducto;
    private String nombreProducto;
    private Integer stock;
}
