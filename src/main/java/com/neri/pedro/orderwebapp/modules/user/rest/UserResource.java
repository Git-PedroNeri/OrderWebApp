package com.neri.pedro.orderwebapp.modules.user.rest;

import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.service.UserServiceImpl;
import com.neri.pedro.orderwebapp.modules.user.service.dto.UserDto;
import com.neri.pedro.orderwebapp.modules.user.service.mapper.UserMapper;
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
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserMapper mapper;


    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        final List<User> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        Optional<User> userFounded = service.findById(id);
        if (userFounded.isPresent()) {
            return ResponseEntity.ok().body(mapper.toDto(userFounded.get()));

        }

        return ResponseEntity.notFound().build();
    }

}
