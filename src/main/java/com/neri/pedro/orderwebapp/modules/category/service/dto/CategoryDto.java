package com.neri.pedro.orderwebapp.modules.category.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Created 07/07/2022 - 22:04
 * @Author pedro.neri
 */
@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
}
