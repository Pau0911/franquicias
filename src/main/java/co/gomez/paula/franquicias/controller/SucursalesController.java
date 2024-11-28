package co.gomez.paula.franquicias.controller;

import co.gomez.paula.franquicias.dto.ProductoDTO;
import co.gomez.paula.franquicias.dto.StockDTO;
import co.gomez.paula.franquicias.dto.SucursalDTO;
import co.gomez.paula.franquicias.service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/sucursales")
public class SucursalesController {

    private final SucursalService sucursalService;

    public SucursalesController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @Operation(
            summary = "Agregar producto",
            description = "Permite agregar un producto a una sucursal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto agregado"),
                    @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PostMapping("{idSucursal}/productos")
    public ProductoDTO asociarProducto(@PathVariable UUID idSucursal, @RequestBody ProductoDTO productoDTO) {
        return sucursalService.agregarProducto(idSucursal, productoDTO);
    }

    @Operation(
            summary = "Eliminar producto",
            description = "Permite eliminar un producto de una sucursal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto eliminado"),
                    @ApiResponse(responseCode = "404", description = "Sucursal/Producto no encontrados"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @DeleteMapping("{idSucursal}/productos/{idProducto}")
    public boolean eliminarProducto(@PathVariable UUID idSucursal, @PathVariable UUID idProducto) {
        return sucursalService.eliminarProducto(idSucursal, idProducto);
    }


    @Operation(
            summary = "Listar sucursales",
            description = "Permite listar las sucursales",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Sucursales obtenidas"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @GetMapping
    public List<SucursalDTO> findAll() {
        return sucursalService.listarSucursales();
    }

    @Operation(
            summary = "Listar productos con mayor stock por sucursal",
            description = "Permite listar los productos con mayor cantidad de stock por sucursal asociada a una franquicia específica",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Productos con mayor stock obtenidos"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @GetMapping("/mayor-stock/franquicias/{idFranquicia}/")
    public List<StockDTO> listarProductosMayorStockxSucursal(@PathVariable UUID idFranquicia) {
        return sucursalService.listarProductosMayorStockxSucursal(idFranquicia);
    }

    @Operation(
            summary = "Actualizar nombre sucursal",
            description = "Permite actualizar el nombre de una sucursal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Nombre actualizado"),
                    @ApiResponse(responseCode = "400", description = "Nombre inválido"),
                    @ApiResponse(responseCode = "404", description = "Sucursal no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno")


            }
    )
    @PatchMapping("{idSucursal}")
    public boolean actualizarNombre(@PathVariable UUID idSucursal, @RequestParam String nuevoNombre) {
        return sucursalService.actualizarNombre(idSucursal, nuevoNombre);
    }

}
