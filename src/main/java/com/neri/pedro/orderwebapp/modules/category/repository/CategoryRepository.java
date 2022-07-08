package com.neri.pedro.orderwebapp.modules.category.repository;

import com.neri.pedro.orderwebapp.comum.repository.JpaBaseRepository;
import com.neri.pedro.orderwebapp.modules.category.domain.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaBaseRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}