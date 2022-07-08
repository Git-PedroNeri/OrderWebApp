package com.neri.pedro.orderwebapp.modules.order.enums;

/**
 * @Created 07/07/2022 - 21:07
 * @Author pedro.neri
 */

public enum OrderStatus {

    WAITING_PAYMENT(1, "Waiting Payment"),
    PAID(2, "Paid"),
    SHIPPED(3, "Shipped"),
    DELIVERED(4, "Delivered"),
    CANCELED(5, "Canceled");

    private int code;
    private String Description;

    private OrderStatus(int code, String description) {
        this.code = code;
        Description = description;
    }

    static OrderStatus valueOf(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code !");
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
