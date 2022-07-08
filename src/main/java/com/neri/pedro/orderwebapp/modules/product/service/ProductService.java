package com.neri.pedro.orderwebapp.modules.product.service;

import com.neri.pedro.orderwebapp.modules.product.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:43
 * @Author pedro.neri
 */
public interface ProductService {

    Product salvar(Product cat);
    List<Product> findAll();
    Optional<Product> findById(Long id);



}
