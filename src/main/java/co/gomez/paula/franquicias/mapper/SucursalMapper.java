package co.gomez.paula.franquicias.mapper;

import co.gomez.paula.franquicias.dto.SucursalDTO;
import co.gomez.paula.franquicias.mapper.base.BaseMapper;
import co.gomez.paula.franquicias.model.Sucursal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SucursalMapper extends BaseMapper<Sucursal, SucursalDTO> {
}
