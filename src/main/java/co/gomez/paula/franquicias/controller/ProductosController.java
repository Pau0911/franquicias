package co.gomez.paula.franquicias.controller;

import co.gomez.paula.franquicias.dto.ProductoDTO;
import co.gomez.paula.franquicias.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/productos")
public class ProductosController {

    private final ProductoService productoService;

    public ProductosController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @Operation(
            summary = "Modificar stock",
            description = "Permite modificar el stock de un producto",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Stock modificado"),
                    @ApiResponse(responseCode = "400", description = "Nuevo stock inválido"),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PutMapping("{idProducto}")
    public boolean modificarStock(@PathVariable UUID idProducto, @RequestParam Integer nuevoStock) {
        return productoService.modificarStock(idProducto, nuevoStock);
    }

    @Operation(
            summary = "Listar productos",
            description = "Permite listar productos",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Productos obtenidos"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @GetMapping
    List<ProductoDTO> findAll() {
        return productoService.listarProductos();
    }

    @Operation(
            summary = "Actualizar nombre producto",
            description = "Permite actualizar el nombre de un producto",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Nombre de producto actualizado"),
                    @ApiResponse(responseCode = "400", description = "Nombre inválido"),
                    @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PatchMapping("{idProducto}")
    public boolean actualizarNombre(@PathVariable UUID idProducto, @RequestParam String nuevoNombre) {
        return productoService.actualizarNombre(idProducto, nuevoNombre);
    }
}
