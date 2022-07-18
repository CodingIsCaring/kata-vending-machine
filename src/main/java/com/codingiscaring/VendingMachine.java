package com.codingiscaring;

import java.util.List;

public class VendingMachine {

    private List<Item> items;
    private Double cash = 100.00;

    public VendingMachine(List<Item> items) {
        this.items = items;
    }

    public String vend(String code, Double money) {
        Item item = findItemBy(code);

        if (item == null) {
            return "Invalid selection! : Money in vending machine = " + DoubleUtils.twoDecimalsFormat(money);
        }

        if (item.isOutOfStock()) {
            return item.getName() + ": Out of stock!";
        }

        Double change = item.changeFrom(money);
        if (change < 0) {
            return "Not enough money!";
        }

        item.decreaseQuantity();
        this.cash += item.getPrice();
        if (change > 0) {
            return "Vending " + item.getName() + " with " + DoubleUtils.twoDecimalsFormat(change) + " change";
        }

        return "Vending " + item.getName();
    }

    private Item findItemBy(String code) {
        return items.stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public Double getCash() {
        return this.cash;
    }
}
