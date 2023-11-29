package org.example;

import java.util.List;

public class Main {


    public static void main(String[] args) {

        // Create instances of Card for Golden and Silver cards
        Card GoldenCard = new Card(Card.GOLDEN_CARD);
        Card SilverCard = new Card(Card.SILVER_CARD);
        Card Affiliate = new Card(Card.AFFILIATE);

        // Create items
        Item FoodItem = new Item( 100.0, false);
        Item PhoneItem = new Item( 500.0, true);
        Item BookItem = new Item(200.0,false);

        // Create customers with different types of cards
        Customer JohnWithGoldenCard = new Customer("John", GoldenCard);
        Customer AliceWithSilverCard = new Customer("Alice", SilverCard);
        Customer BobWithAffiliateCard = new Customer("Bob", Affiliate);

        // Add items to customers' lists
        JohnWithGoldenCard.addItem(FoodItem);
        JohnWithGoldenCard.addItem(PhoneItem);
        AliceWithSilverCard.addItem(FoodItem);
        BobWithAffiliateCard.addItem(PhoneItem);
        BobWithAffiliateCard.addItem(BookItem);

        JohnWithGoldenCard.setCard(Affiliate);
        

        displayItemsForCustomer(JohnWithGoldenCard);
        displayItemsForCustomer(AliceWithSilverCard);
        displayItemsForCustomer(BobWithAffiliateCard);

        // Calculate total price
        double totalPriceForJohn = calculateTotalPrice(JohnWithGoldenCard);
        double totalPriceForAlice = calculateTotalPrice(AliceWithSilverCard);
        double totalPriceForBob = calculateTotalPrice(BobWithAffiliateCard);

        // Display total prices for each customer
        System.out.println("Total price for John: $" + totalPriceForJohn);
        System.out.println("Total price for Alice: $" + totalPriceForAlice);
        System.out.println("Total price for Bob: $" + totalPriceForBob);
    }

    // Method to calculate total price for a customer based on items and discount
    private static double calculateTotalPrice(Customer customer) {
        double totalPrice = 0.0;

        // Calculate the total price of items
        List<Item> items = customer.getItems();
        for (Item item : items) {
            totalPrice += customer.getCard().calculateDiscount(item) * item.getPrice();
        }

        // Apply discount using the Card's calculateDiscount method
        return totalPrice;
    }
    // Method to display items associated with a customer
    private static void displayItemsForCustomer(Customer customer) {
        System.out.println("Items associated with " + customer.getName() + ":");
        List<Item> items = customer.getItems();
        for (Item item : items) {
            System.out.println("Price: $" + item.getPrice() + ", Phone: " + item.isPhone());
        }
        System.out.println();
    }
}