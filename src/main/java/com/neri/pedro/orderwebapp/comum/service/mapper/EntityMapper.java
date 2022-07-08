package com.neri.pedro.orderwebapp.comum.service.mapper;

import java.util.List;

/**
 * @Created 07/07/2022 - 12:41
 * @Author pedro.neri
 */
public interface EntityMapper <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List <D> toDto(List<E> entityList);
}
