package com.neri.pedro.orderwebapp.modules.product.service;

import com.neri.pedro.orderwebapp.modules.category.domain.Category;
import com.neri.pedro.orderwebapp.modules.category.repository.CategoryRepository;
import com.neri.pedro.orderwebapp.modules.product.domain.Product;
import com.neri.pedro.orderwebapp.modules.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:50
 * @Author pedro.neri
 */

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product salvar(Product cat) {
        return productRepository.save(cat);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
