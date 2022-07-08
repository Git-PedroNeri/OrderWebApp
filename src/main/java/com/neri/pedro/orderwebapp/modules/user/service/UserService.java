package com.neri.pedro.orderwebapp.modules.user.service;

import com.neri.pedro.orderwebapp.modules.user.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:43
 * @Author pedro.neri
 */
public interface UserService {

    User autenticar(String email, String senha);
    User salvar(User user);
    List<User> findAll();
    Optional<User> findById(Long id);



}
