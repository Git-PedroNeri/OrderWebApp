package com.neri.pedro.orderwebapp.modules.user.service.mapper;

import com.neri.pedro.orderwebapp.comum.service.mapper.EntityMapper;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.service.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Created 07/07/2022 - 12:40
 * @Author pedro.neri
 */
@Component
public class UserMapper implements EntityMapper<UserDto, User> {

    @Override
    public User toEntity(UserDto dto) {
        if(dto == null){return null;}
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    public User toEntity(Long id) {
        return User.builder()
                .id(id)
                .build();
    }

    @Override
    public UserDto toDto(User entity) {
        if(entity == null){return null;}
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }

    @Override
    public List<User> toEntity(List<UserDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> toDto(List<User> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
