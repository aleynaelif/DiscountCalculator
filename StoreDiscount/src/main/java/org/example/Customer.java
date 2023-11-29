package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private Card card;
    private List<Item> items; // List of items associated with the customer

    //Constructor
    public Customer(String name, Card card) {
        this.name = name;
        this.card = card;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

}
