package com.neri.pedro.orderwebapp.modules.order.domain;

import com.neri.pedro.orderwebapp.modules.order.enums.OrderStatus;
import com.neri.pedro.orderwebapp.modules.payment.domain.Payment;
import com.neri.pedro.orderwebapp.modules.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


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

    @OneToMany(mappedBy = "id.order", fetch = FetchType.EAGER)
    private Set<OrderItem> items = new HashSet<>();

    /*
     * Order pode existir sem um Payment , mas o Payment não podera existir sem um Order
     * Payment é DEPENDENTE de Order.Order INDEPENDETE entidade FORTE do relacionamento
     */
    @OneToOne(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, LocalDateTime moment, User user, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.user = user;
        setOrderStatus(orderStatus);
    }

    public Order() {

    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
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
        return OrderStatus.valueOfByCode(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public BigDecimal getTotal() {
        return items.stream()
                .map(x -> x.getSubTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}