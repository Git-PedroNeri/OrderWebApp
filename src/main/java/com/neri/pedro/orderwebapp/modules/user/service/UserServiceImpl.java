package com.neri.pedro.orderwebapp.modules.user.service;

import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:50
 * @Author pedro.neri
 */

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User autenticar(String email, String senha) {
        return null;
    }

    @Override
    public User salvar(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
