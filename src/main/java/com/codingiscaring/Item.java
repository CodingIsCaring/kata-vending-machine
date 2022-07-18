package com.codingiscaring;

public class Item {
    private final String name;
    private final String code;
    private Integer quantity;
    private final double price;

    public Item(String name, String code, Integer quantity, double price) {
        this.name = name;
        this.code = code;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getPrice() {
        return this.price;
    }

    boolean isOutOfStock() {
        return quantity == 0;
    }

    double changeFrom(double money) {
        return money - price;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}
