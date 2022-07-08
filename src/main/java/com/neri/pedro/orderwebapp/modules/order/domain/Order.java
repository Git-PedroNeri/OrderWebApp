package com.neri.pedro.orderwebapp.modules.order.domain;

import com.neri.pedro.orderwebapp.modules.order.enums.OrderStatus;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@Builder
@Table(name = "tb_order")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "moment")
    private LocalDateTime moment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "order_status")
    private Integer orderStatus;

    public Order(Long id) {
        this.id = id;
    }

    public Order(Long id, LocalDateTime moment, User user, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.user = user;
        setOrderStatus(orderStatus);
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(String.valueOf(orderStatus));
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }
}