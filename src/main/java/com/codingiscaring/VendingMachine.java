package com.codingiscaring;

import java.util.List;

public class VendingMachine {

    private final Casher cash = new Casher(100);
    private final Inventory inventory;

    public VendingMachine(List<Item> items) {
        this.inventory = new Inventory(items);
    }

    public String vend(String code, double money) {

        try {

            Item item = inventory.sell(code, money);
            double change = cash.registerSell(item, money);

            return formatSuccessSellMessage(item, change);

        } catch (Exception | CashException | InventoryException e) {
            return e.getMessage();
        }
    }

    public double getCash() {
        return this.cash.getCash();
    }

    public String formatSuccessSellMessage(Item item, double change) {
        String result = "Vending " + item.getName();

        if (change > 0)
            result += " with " + DoubleUtils.twoDecimalsFormat(change) + " change";

        return result;
    }


}
