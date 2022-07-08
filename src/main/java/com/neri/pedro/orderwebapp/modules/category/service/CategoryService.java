package com.neri.pedro.orderwebapp.modules.category.service;

import com.neri.pedro.orderwebapp.modules.category.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:43
 * @Author pedro.neri
 */
public interface CategoryService {

    Category salvar(Category cat);
    List<Category> findAll();
    Optional<Category> findById(Long id);



}
