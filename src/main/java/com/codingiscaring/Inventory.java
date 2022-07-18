package com.codingiscaring;

import java.util.List;

public class Inventory {

    private List<Item> items;

    public Inventory(List<Item> items) {
        this.items = items;
    }

    private Item findItemBy(String code) {
        return items.stream()
                .filter(i -> i.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    private void updateInventory(Item item) {
        item.decreaseQuantity();
    }

    public Item sell(String code, double money) throws InventoryException {
        Item item = findItemBy(code);

        if (item == null)
            throw new InventoryException("Invalid selection! : Money in vending machine = " + DoubleUtils.twoDecimalsFormat(money));

        if (item.isOutOfStock())
            throw new InventoryException(item.getName() + ": Out of stock!");

        updateInventory(item);

        return item;
    }
}
