package co.gomez.paula.franquicias.service;

import co.gomez.paula.franquicias.dto.ProductoDTO;
import co.gomez.paula.franquicias.dto.StockDTO;
import co.gomez.paula.franquicias.dto.SucursalDTO;
import co.gomez.paula.franquicias.exception.DatosNoEncontradosException;
import co.gomez.paula.franquicias.mapper.ProductoMapper;
import co.gomez.paula.franquicias.mapper.SucursalMapper;
import co.gomez.paula.franquicias.model.Franquicia;
import co.gomez.paula.franquicias.model.Producto;
import co.gomez.paula.franquicias.model.Sucursal;
import co.gomez.paula.franquicias.repository.ProductoRepository;
import co.gomez.paula.franquicias.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SucursalService {
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;
    private final SucursalMapper sucursalMapper;
    private final ProductoMapper productoMapper;

    public SucursalService(SucursalRepository sucursalRepository, ProductoRepository productoRepository, SucursalMapper sucursalMapper, ProductoMapper productoMapper) {
        this.sucursalRepository = sucursalRepository;
        this.productoRepository = productoRepository;
        this.sucursalMapper = sucursalMapper;
        this.productoMapper = productoMapper;
    }

    public List<SucursalDTO> listarSucursales() {
        return sucursalMapper.aDto(sucursalRepository.findAll());
    }

    public ProductoDTO agregarProducto(UUID idSucursal, ProductoDTO productoDTO) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(idSucursal);
        if (sucursal.isPresent()) {
            Producto producto = productoMapper.aEntidad(productoDTO);
            producto.setIdSucursal(idSucursal);
            return productoMapper.aDto(productoRepository.save(producto));
        }
        throw new DatosNoEncontradosException("No existe la sucursal con id " + idSucursal);

    }

    @Transactional
    public boolean eliminarProducto(UUID idSucursal, UUID idProducto) {
        Optional<Sucursal> sucursal = sucursalRepository.findById(idSucursal);
        if (sucursal.isPresent()) {
            Optional<Producto> producto = productoRepository.findById(idProducto);
            if (producto.isPresent()) {
                productoRepository.deleteById(idProducto);
                return true;
            }
            throw new DatosNoEncontradosException("No existe el producto con id " + idProducto);
        }
        throw new DatosNoEncontradosException("No existe la sucursal con id " + idSucursal);
    }

    public List<StockDTO> listarProductosMayorStockxSucursal(UUID idFranquicia) {
        return sucursalRepository.listarProductosMayorStockxSucursal(idFranquicia);
    }

    @Transactional
    public boolean actualizarNombre(UUID idSucursal, String nuevoNombre) {
        if (StringUtils.isEmpty(nuevoNombre)) {
            throw new IllegalArgumentException("No se puede modificar el nombre por uno vacío");
        }
        Optional<Sucursal> sucursal = sucursalRepository.findById(idSucursal);
        if (sucursal.isPresent()) {
            int filasModificadas = sucursalRepository.actualizarNombre(idSucursal, nuevoNombre);
            if (filasModificadas > 0) {
                return true;
            }
            return false;
        }
        throw new DatosNoEncontradosException("No existe la sucursal con id " + idSucursal);
    }
}
