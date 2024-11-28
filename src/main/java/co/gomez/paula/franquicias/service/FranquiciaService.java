package co.gomez.paula.franquicias.service;

import co.gomez.paula.franquicias.dto.FranquiciaDTO;
import co.gomez.paula.franquicias.dto.SucursalDTO;
import co.gomez.paula.franquicias.exception.DatosNoEncontradosException;
import co.gomez.paula.franquicias.mapper.FranquiciaMapper;
import co.gomez.paula.franquicias.mapper.SucursalMapper;
import co.gomez.paula.franquicias.model.Franquicia;
import co.gomez.paula.franquicias.model.Sucursal;
import co.gomez.paula.franquicias.repository.FranquiciaRepository;
import co.gomez.paula.franquicias.repository.SucursalRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FranquiciaService {
    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;
    private final FranquiciaMapper franquiciaMapper;
    private final SucursalMapper sucursalMapper;

    public FranquiciaService(FranquiciaRepository franquiciaRepository, SucursalRepository sucursalRepository, FranquiciaMapper franquiciaMapper, SucursalMapper sucursalMapper) {
        this.franquiciaRepository = franquiciaRepository;
        this.sucursalRepository = sucursalRepository;
        this.franquiciaMapper = franquiciaMapper;
        this.sucursalMapper = sucursalMapper;
    }


    public FranquiciaDTO crearFranquicia(FranquiciaDTO franquiciaDTO) {
        Franquicia franquicia = franquiciaMapper.aEntidad(franquiciaDTO);
        Franquicia franquiciaGuardada = franquiciaRepository.save(franquicia);
        return franquiciaMapper.aDto(franquiciaGuardada);
    }

    public List<FranquiciaDTO> listarFranquicias() {
        return franquiciaMapper.aDto(franquiciaRepository.findAll());
    }

    public SucursalDTO agregarSucursal(UUID idFranquicia, SucursalDTO sucursalDTO) {
        Optional<Franquicia> franquicia = franquiciaRepository.findById(idFranquicia);
        if (franquicia.isPresent()) {
            Sucursal sucursal = sucursalMapper.aEntidad(sucursalDTO);
            sucursal.setIdFranquicia(idFranquicia);
            return sucursalMapper.aDto(sucursalRepository.save(sucursal));
        }
        throw new DatosNoEncontradosException("No existe la franquicia con id " + idFranquicia);
    }

    @Transactional
    public boolean actualizarNombre(UUID idFranquicia, String nuevoNombre) {
        if (StringUtils.isEmpty(nuevoNombre)) {
            throw new IllegalArgumentException("No se puede modificar el nombre por uno vacío");
        }
        Optional<Franquicia> franquicia = franquiciaRepository.findById(idFranquicia);
        if (franquicia.isPresent()) {
            int filasModificadas = franquiciaRepository.actualizarNombre(idFranquicia, nuevoNombre);
            if (filasModificadas > 0) {
                return true;
            }
            return false;
        }
        throw new DatosNoEncontradosException("No existe la franquicia con id " + idFranquicia);
    }
}
