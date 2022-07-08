package com.neri.pedro.orderwebapp.modules.user.repository;

import com.neri.pedro.orderwebapp.comum.repository.JpaBaseRepository;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaBaseRepository<User, Long>, JpaSpecificationExecutor<User> {





}