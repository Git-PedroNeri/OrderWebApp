package com.neri.pedro.orderwebapp.modules.order.repository;

import com.neri.pedro.orderwebapp.comum.repository.JpaBaseRepository;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;
import com.neri.pedro.orderwebapp.modules.order.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaBaseRepository<OrderItem, Long>, JpaSpecificationExecutor<OrderItem> {





}