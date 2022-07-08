package com.neri.pedro.orderwebapp.modules.order.rest;

import com.neri.pedro.orderwebapp.modules.order.service.OrderServiceImpl;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.order.service.dto.OrderDto;
import com.neri.pedro.orderwebapp.modules.order.service.mapper.OrderMapper;
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
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderServiceImpl service;

    @Autowired
    private OrderMapper mapper;


    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        final List<Order> all = service.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        Optional<Order> orderFounded = service.findById(id);
        if (orderFounded.isPresent()) {
            return ResponseEntity.ok().body(mapper.toDto(orderFounded.get()));

        }

        return ResponseEntity.notFound().build();
    }

}
