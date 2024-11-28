package co.gomez.paula.franquicias.controller;

import co.gomez.paula.franquicias.dto.FranquiciaDTO;
import co.gomez.paula.franquicias.dto.SucursalDTO;
import co.gomez.paula.franquicias.service.FranquiciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/franquicias")
public class FranquiciasController {

    private final FranquiciaService franquiciaService;

    public FranquiciasController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @Operation(
            summary = "Crear una franquicia",
            description = "Permite crear una franquicia",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Franquicia creada correctamente"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PostMapping
    public FranquiciaDTO agregarFranquicia(FranquiciaDTO franquiciaDTO) {
        return franquiciaService.crearFranquicia(franquiciaDTO);
    }

    @Operation(
            summary = "Listar franquicias",
            description = "Permite listar las franquicias",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Franquicias obtenidas"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @GetMapping
    public List<FranquiciaDTO> obtenerFranquicias() {
        return franquiciaService.listarFranquicias();
    }

    @Operation(
            summary = "Asociar sucursal a franquicia",
            description = "Permite asociar una sucursal a una franquicia",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Sucursal asociada"),
                    @ApiResponse(responseCode = "404", description = "Franquicia no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PostMapping("{idFranquicia}/sucursales")
    public SucursalDTO asociarSucursal(@PathVariable UUID idFranquicia, @RequestBody SucursalDTO sucursalDTO) {
        return franquiciaService.agregarSucursal(idFranquicia, sucursalDTO);
    }

    @Operation(
            summary = "Actualizar nombre franquicia",
            description = "Permite actualizar el nombre de una franquicia",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Nombre actualizado"),
                    @ApiResponse(responseCode = "400", description = "Nombre inválido"),
                    @ApiResponse(responseCode = "404", description = "Franquicia no encontrada"),
                    @ApiResponse(responseCode = "500", description = "Error interno")


            }
    )
    @PatchMapping("{idFranquicia}")
    public boolean actualizarNombre(@PathVariable UUID idFranquicia, @RequestParam String nuevoNombre) {
        return franquiciaService.actualizarNombre(idFranquicia, nuevoNombre);
    }

}
