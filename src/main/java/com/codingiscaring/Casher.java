package com.codingiscaring;

public class Casher {

    private double cash;

    public Casher(double cash) {
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    boolean isSellAllowed(Item item, double money) {
        return money >= item.getPrice();
    }

    public void updateItemSold(Item item) {
        this.cash += item.getPrice();
    }

    public double registerSell(Item item, double money) throws CashException {
        if (!isSellAllowed(item, money))
            throw new CashException("Not enough money!");

        updateItemSold(item);

        return money - item.getPrice();
    }
}
