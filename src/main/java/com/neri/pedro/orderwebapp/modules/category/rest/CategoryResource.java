package com.neri.pedro.orderwebapp.modules.category.rest;

import com.neri.pedro.orderwebapp.modules.category.domain.Category;
import com.neri.pedro.orderwebapp.modules.category.service.CategoryServiceImpl;
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
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryServiceImpl service;

//    @Autowired
//    private CategoryMapper mapper;


    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        final List<Category> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> catFounded = service.findById(id);
        if (catFounded.isPresent()) {
            return ResponseEntity.ok().body(catFounded.get());

        }

        return ResponseEntity.notFound().build();
    }

}
