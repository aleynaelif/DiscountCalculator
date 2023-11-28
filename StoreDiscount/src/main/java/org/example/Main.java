package org.example;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        // Create instances of Card for Golden and Silver cards
        Card goldenCard = new Card("Golden");
        Card silverCard = new Card("Silver");

        // Create items
        Item item1 = new Item(100.0, false);
        Item item2 = new Item(500.0, true);

        // Create customers with different types of cards
        Customer customerWithGoldenCard = new Customer(false, goldenCard);
        Customer customerWithSilverCard = new Customer(false, silverCard);

        // Add items to customers lists
        customerWithGoldenCard.addItems(item1);
        customerWithGoldenCard.addItems(item2);
        customerWithSilverCard.addItems(item1);

    }
}