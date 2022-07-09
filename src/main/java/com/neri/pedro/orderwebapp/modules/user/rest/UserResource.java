package com.neri.pedro.orderwebapp.modules.user.rest;

import com.neri.pedro.orderwebapp.comum.service.exeptions.ResourceNotFoundException;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import com.neri.pedro.orderwebapp.modules.user.service.UserServiceImpl;
import com.neri.pedro.orderwebapp.modules.user.service.dto.UserDto;
import com.neri.pedro.orderwebapp.modules.user.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        User userFounded = service.findById(id);
        Optional<User> user = Optional.of(userFounded);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(mapper.toDto(user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = service.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    //TODO Não testado
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<User> byId = Optional.of(service.findById(id));
        if (byId.isPresent()) {
            service.delete(byId.get());
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
            service.excluir(id);
    }

    //TODO Não testado
    @PostMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User user) {
        user = service.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


}
