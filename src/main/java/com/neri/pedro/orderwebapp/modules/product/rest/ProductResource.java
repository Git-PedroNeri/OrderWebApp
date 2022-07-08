package com.neri.pedro.orderwebapp.modules.product.rest;

import com.neri.pedro.orderwebapp.modules.product.domain.Product;
import com.neri.pedro.orderwebapp.modules.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 09:37
 * @Author pedro.neri
 */
@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        final List<Product> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Optional<Product> productFounded = service.findById(id);
        if (productFounded.isPresent()) {
            return ResponseEntity.ok().body(productFounded.get());

        }

        return ResponseEntity.notFound().build();
    }

}
