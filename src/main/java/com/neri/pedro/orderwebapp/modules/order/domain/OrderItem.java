package com.neri.pedro.orderwebapp.modules.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neri.pedro.orderwebapp.modules.product.domain.Product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Created 08/07/2022 - 08:46
 * @Author pedro.neri
 */
@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    OrderItemPK id = new OrderItemPK();

    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "price", precision = 19, scale = 2)
    private BigDecimal price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, BigDecimal price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Product p) {
        id.setProduct(p);
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }


    public Product getProduct() {
        return id.getProduct();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public  BigDecimal getSubTotal(){
        return getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }





}
