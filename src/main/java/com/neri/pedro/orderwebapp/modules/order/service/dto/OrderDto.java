package com.neri.pedro.orderwebapp.modules.order.service.dto;

import com.neri.pedro.orderwebapp.modules.user.service.dto.UserDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Created 07/07/2022 - 14:04
 * @Author pedro.neri
 */
@Data
@SuperBuilder
public class OrderDto implements Serializable {
    private final Long id;
    private final LocalDateTime moment;
    private final UserDto userDto;
}
