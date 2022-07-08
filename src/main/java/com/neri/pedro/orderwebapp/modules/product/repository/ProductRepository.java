package com.neri.pedro.orderwebapp.modules.product.repository;

import com.neri.pedro.orderwebapp.comum.repository.JpaBaseRepository;
import com.neri.pedro.orderwebapp.modules.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaBaseRepository<Product, Long> {
}