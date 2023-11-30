package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Card goldenCard = new Card(Constants.GOLDEN_CARD);
        Card silverCard = new Card(Constants.SILVER_CARD);
        Card affiliateCard = new Card(Constants.AFFILIATE);
        Card noCard = new Card(Constants.NO_CARD);

        // Create items
        Item foodItem = new Item(100.0, false);
        Item phoneItem = new Item(500.0, true);
        Item bookItem = new Item(200.0, false);

        // Create customers with different types of cards
        Customer johnWithGoldenCard = createCustomer("John", goldenCard, 2, foodItem, phoneItem);
        Customer aliceWithSilverCard = createCustomer("Alice", silverCard, 2, foodItem);
        Customer bobWithAffiliateCard = createCustomer("Bob", affiliateCard, 2, phoneItem, bookItem);
        Customer lilyWithNoCard = createCustomer("Lily", noCard, 1, bookItem);

        // Calculate and display total price for each customer
        calculateAndDisplayTotalPrice(johnWithGoldenCard);
        calculateAndDisplayTotalPrice(aliceWithSilverCard);
        calculateAndDisplayTotalPrice(bobWithAffiliateCard);
        calculateAndDisplayTotalPrice(lilyWithNoCard);
    }

    private static Customer createCustomer(String name, Card card, int years, Item... items) {
        Customer customer = new Customer(name, card, years);
        for (Item item : items) {
            customer.addItem(item);
        }
        return customer;
    }

    private static void calculateAndDisplayTotalPrice(Customer customer) {
        DiscountContext context = new DiscountContext(customer, customer.getItems());
        DiscountCalculator.displayItemsForCustomer(context);
        double totalPrice = DiscountCalculator.calculateTotalPrice(context);
        System.out.println("Total price for " + customer.getName() + ": $" + totalPrice);

    }
}