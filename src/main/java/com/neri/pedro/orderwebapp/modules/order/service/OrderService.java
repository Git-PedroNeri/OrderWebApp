package com.neri.pedro.orderwebapp.modules.order.service;

import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.user.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * @Created 07/07/2022 - 10:43
 * @Author pedro.neri
 */
public interface OrderService {

    User salvar(Order user);
    List<Order> findAll();
    Optional<Order> findById(Long id);



}
