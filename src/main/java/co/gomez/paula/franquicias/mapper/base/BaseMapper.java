package co.gomez.paula.franquicias.mapper.base;

import java.util.List;
import java.util.Set;

public interface BaseMapper<E, D> {
    D aDto(E entidad);
    E aEntidad(D dto);
    List<D> aDto(List<E> entidades);
    List<E> aEntidad(List<D> dtos);
    Set<D> aDto(Set<E> entidades);
    Set<E> aEntidad(Set<D> dtos);
}
