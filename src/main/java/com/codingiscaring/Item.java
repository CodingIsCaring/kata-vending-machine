package com.codingiscaring;

public class Item {
    private String name;
    private String code;
    private Integer quantity;
    private Double price;

    public Item(String name, String code, Integer quantity, Double price) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
    }

    boolean isOutOfStock() {
        return quantity == 0;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    double changeFrom(Double money) {
        return money - price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}
