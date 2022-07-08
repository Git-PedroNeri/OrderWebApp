package com.neri.pedro.orderwebapp.modules.category.service;

import com.neri.pedro.orderwebapp.modules.category.domain.Category;
import com.neri.pedro.orderwebapp.modules.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:50
 * @Author pedro.neri
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category salvar(Category cat) {
        return categoryRepository.save(cat);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }
}
