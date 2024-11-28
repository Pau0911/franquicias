package co.gomez.paula.franquicias.service;

import co.gomez.paula.franquicias.dto.ProductoDTO;
import co.gomez.paula.franquicias.exception.DatosNoEncontradosException;
import co.gomez.paula.franquicias.mapper.ProductoMapper;
import co.gomez.paula.franquicias.model.Producto;
import co.gomez.paula.franquicias.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoService(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }

    public List<ProductoDTO> listarProductos() {
        return productoMapper.aDto(productoRepository.findAll());
    }

    @Transactional
    public boolean modificarStock(UUID idProducto, Integer nuevoStock) {
        if (nuevoStock < 0) {
            throw new IllegalArgumentException("No se puede modificar el stock a un valor negativo");
        }
        Optional<Producto> producto = productoRepository.findById(idProducto);
        if (producto.isPresent()) {
            int filasModificadas = productoRepository.modificarStock(idProducto, nuevoStock);
            if (filasModificadas > 0) {
                return true;
            }
            return false;
        }
        throw new DatosNoEncontradosException("No existe el producto con id " + idProducto);
    }

    @Transactional
    public boolean actualizarNombre(UUID idProducto, String nuevoNombre) {
        if (StringUtils.isEmpty(nuevoNombre)) {
            throw new IllegalArgumentException("No se puede modificar el nombre por uno vacío");
        }
        Optional<Producto> producto = productoRepository.findById(idProducto);
        if (producto.isPresent()) {
            int filasModificadas = productoRepository.actualizarNombre(idProducto, nuevoNombre);
            if (filasModificadas > 0) {
                return true;
            }
            return false;
        }
        throw new DatosNoEncontradosException("No existe el producto con id " + idProducto);
    }
}
