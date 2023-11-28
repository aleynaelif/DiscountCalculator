package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private boolean IsAffiliate;
    private Card card;
    private List<Item> items; // List of items associated with the customer

    //Constructor
    public Customer(Boolean IsAffiliate,Card card) {
        this.IsAffiliate = IsAffiliate;
        this.card = card;
        this.items = new ArrayList<>();
    }

    public boolean getAffiliate(){
        return IsAffiliate;
    }
    public void setAffiliate(Boolean IsAffiliate) {
        this.IsAffiliate = IsAffiliate;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
