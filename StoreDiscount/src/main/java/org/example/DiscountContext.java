package org.example;

import java.util.List;

public class DiscountContext {
    private Customer customer;
    private List<Item> items;

    public DiscountContext(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}