package com.codingiscaring;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendingMachineShould {

//    Item smarties = new Item("Smarties", "A01", 10, 0.60);
//        Item caramacBar = new Item("Caramac Bar", "A02", 5, 0.60);
//        Item dairyMilk = new Item("Dairy Milk", "A03", 1, 0.65);
//        Item freddo = new Item("Freddo", "A04", 1, 0.25);

    @Test
    void return_not_enough_money_when_money_given_is_less_than_the_cost() {
        Item smarties = new Item("Smarties", "A01", 10, 0.60);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(smarties));

        assertEquals("Not enough money!",
                vendingMachine.vend("A01", 0.50));
    }

    @Test
    void return_out_of_stock_when_the_item_quantity_is_zero() {
        Item caramacBar = new Item("Caramac Bar", "A02", 0, 0.60);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(caramacBar));

        assertEquals("Caramac Bar: Out of stock!",
                vendingMachine.vend("A02", 0.60));
    }

    @Test
    void return_change_when_the_item_is_correctly_selected() {
        Item dairyMilk = new Item("Dairy Milk", "A03", 1, 0.65);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(dairyMilk));

        assertEquals("Vending Dairy Milk with 0.35 change",
                vendingMachine.vend("A03", 1.00));
    }

    @Test
    void return_no_change_when_the_item_is_correctly_selected_if_change_is_not_needed() {
        Item dairyMilk = new Item("Dairy Milk", "A03", 1, 0.65);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(dairyMilk));

        assertEquals("Vending Dairy Milk",
                vendingMachine.vend("A03", 0.65));
    }

}
