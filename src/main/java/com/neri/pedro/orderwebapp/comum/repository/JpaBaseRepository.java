package com.neri.pedro.orderwebapp.comum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Created 07/07/2022 - 10:04
 * @Author pedro.neri
 */
@NoRepositoryBean
public interface JpaBaseRepository<ENTIDADE, ID> extends JpaRepository<ENTIDADE, ID>, JpaSpecificationExecutor<ENTIDADE> {

}
