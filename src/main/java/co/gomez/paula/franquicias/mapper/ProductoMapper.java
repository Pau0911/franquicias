package co.gomez.paula.franquicias.mapper;

import co.gomez.paula.franquicias.dto.ProductoDTO;
import co.gomez.paula.franquicias.mapper.base.BaseMapper;
import co.gomez.paula.franquicias.model.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductoMapper extends BaseMapper<Producto, ProductoDTO> {
}
