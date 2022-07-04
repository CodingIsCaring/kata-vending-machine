package com.codingiscaring;

import java.util.List;

public class VendingMachine {

    private List<Item> items;

    public VendingMachine(List<Item> items) {
        this.items = items;
    }

    public String vend(String code, Double money) {
        Item item = findItemBy(code);

        if (item.isOutOfStock()) {
            return item.getName() + ": Out of stock!";
        }

        Double change = item.changeFrom(money);
        if (change > 0) {
            return "Vending " + item.getName() + " with " + change + " change";
        }
        if (change == 0) {
            return "Vending " + item.getName();
        }

        return "Not enough money!";
    }

    private Item findItemBy(String code) {
        return items.stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

}
