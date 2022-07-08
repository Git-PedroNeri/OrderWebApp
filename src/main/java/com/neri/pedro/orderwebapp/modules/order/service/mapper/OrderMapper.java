package com.neri.pedro.orderwebapp.modules.order.service.mapper;

import com.neri.pedro.orderwebapp.comum.service.mapper.EntityMapper;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.order.service.dto.OrderDto;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created 07/07/2022 - 12:40
 * @Author pedro.neri
 */
@Component
public class OrderMapper implements EntityMapper<OrderDto, Order> {
    @Autowired
    UserMapper userMapper;

    @Override
    public Order toEntity(OrderDto dto) {
        if(dto == null){return null;}
        return Order.builder()
                .id(dto.getId())
                .moment(dto.getMoment())
                .user(userMapper.toEntity(dto.getUserDto()))
                .build();
    }

    public Order toEntity(Long id) {
        return Order.builder()
                .id(id)
                .build();
    }

    @Override
    public OrderDto toDto(Order entity) {
        if(entity == null){return null;}
        return OrderDto.builder()
                .id(entity.getId())
                .moment(entity.getMoment())
                .userDto(userMapper.toDto(entity.getUser()))
                .build();
    }

    @Override
    public List<Order> toEntity(List<OrderDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> toDto(List<Order> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
