package com.codingiscaring;

import org.junit.jupiter.api.Test;

import java.util.Formatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VendingMachineShould {

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

    @Test
    void return_invalid_selection_when_the_selected_item_does_not_exist() {
        Item dairyMilk = new Item("Dairy Milk", "A03", 1, 0.65);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(dairyMilk));

        assertEquals("Invalid selection! : Money in vending machine = 0.85",
                vendingMachine.vend("A04", 0.85));
    }

    @Test
    void update_quantity_when_the_selection_is_successfully_sold() {
        Item dairyMilk = new Item("Dairy Milk", "A03", 1, 0.65);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(dairyMilk));

        vendingMachine.vend("A03", 0.65);

        assertEquals(0, dairyMilk.getQuantity());
    }

    @Test
    void keep_track_of_money_in_vending_machine() {
        Item smarties = new Item("Smarties", "A01", 10, 0.60);
        Item caramacBar = new Item("Caramac Bar", "A02", 51, 0.60);
        Item dairyMilk = new Item("Dairy Milk", "A03", 12, 0.65);
        Item freddo = new Item("Freddo", "A04", 13, 0.25);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(smarties, caramacBar, dairyMilk, freddo));

        vendingMachine.vend("A03", 0.65);
        vendingMachine.vend("A04", 0.85);

        assertEquals(100.90, vendingMachine.getCash());
    }


    @Test
    void return_money_amount_with_two_decimals_when_invalid_selection() {
        Item dairyMilk = new Item("Dairy Milk", "A03", 1, 0.65);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(dairyMilk));

        assertEquals("Invalid selection! : Money in vending machine = 0.90",
                vendingMachine.vend("A04", 0.90));
    }

    @Test
    void return_change_with_two_decimals_when_the_item_is_correctly_selected() {
        Item smarties = new Item("Smarties", "A01", 10, 0.60);
        VendingMachine vendingMachine = new VendingMachine(
                List.of(smarties));

        assertEquals("Vending Smarties with 0.40 change",
                vendingMachine.vend("A01", 1.00));
    }

}
