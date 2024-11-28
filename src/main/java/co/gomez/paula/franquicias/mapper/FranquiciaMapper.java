package co.gomez.paula.franquicias.mapper;

import co.gomez.paula.franquicias.dto.FranquiciaDTO;
import co.gomez.paula.franquicias.mapper.base.BaseMapper;
import co.gomez.paula.franquicias.model.Franquicia;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranquiciaMapper extends BaseMapper<Franquicia, FranquiciaDTO> {
}
