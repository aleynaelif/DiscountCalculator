package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private Card card;
    private List<Item> items; // List of items associated with the customer

    private int years;

    //Constructor
    public Customer(String name, Card card, int years) {
        this.name = name;
        this.card = card;
        this.items = new ArrayList<>();
        this.years = years;
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

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

}
