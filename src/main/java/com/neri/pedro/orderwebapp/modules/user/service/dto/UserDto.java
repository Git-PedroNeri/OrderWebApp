package com.neri.pedro.orderwebapp.modules.user.service.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * @Created 07/07/2022 - 11:54
 * @Author pedro.neri
 */
@Data
@SuperBuilder
public class UserDto implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final String phone;
}
