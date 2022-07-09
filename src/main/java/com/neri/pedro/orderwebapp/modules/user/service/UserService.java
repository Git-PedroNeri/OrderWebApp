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
    User insert(User user);
    List<User> findAll();
    User findById(Long id);
    void delete(User id);
    void excluir(Long id);



}
