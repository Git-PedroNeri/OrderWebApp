package com.neri.pedro.orderwebapp.modules.payment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neri.pedro.orderwebapp.modules.order.domain.Order;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dt_pagamento")
    private LocalDateTime dtPagamento;


    /*
     * Order pode existir sem um Payment , mas o Payment não podera existir sem um Order
     * Payment é DEPENDENTE de Order Entidade FRACA.Order INDEPENDETE entidade FORTE do relacionamento
     */
    //@JoinColumn(name="order_id") comentado por que estou usando MapsID
    @OneToOne(orphanRemoval = true)
    @MapsId//Dependente
    @JsonIgnore
    private Order order;


    public Payment() {

    }

    public Payment(Long id, LocalDateTime dtPagamento, Order order) {
        this.id = id;
        this.dtPagamento = dtPagamento;
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public LocalDateTime getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(LocalDateTime dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}