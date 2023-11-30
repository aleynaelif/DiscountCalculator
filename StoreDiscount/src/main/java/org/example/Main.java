package org.example;

import static org.example.DiscountCalculator.calculateTotalPrice;
import static org.example.DiscountCalculator.displayItemsForCustomer;

public class Main {

    public static void main(String[] args) {

        // Create instances of Card for Golden and Silver cards
        Card GoldenCard = new Card(Constants.GOLDEN_CARD);
        Card SilverCard = new Card(Constants.SILVER_CARD);
        Card Affiliate = new Card(Constants.AFFILIATE);
        Card NoCard = new Card(Constants.NO_CARD);

        // Create items
        Item FoodItem = new Item( 100.0, false);
        Item PhoneItem = new Item( 500.0, true);
        Item BookItem = new Item(200.0,false);

        // Create customers with different types of cards
        Customer JohnWithGoldenCard = new Customer("John", GoldenCard,2);
        Customer AliceWithSilverCard = new Customer("Alice", SilverCard,2);
        Customer BobWithAffiliateCard = new Customer("Bob", Affiliate,2);
        Customer LilyWithNoCard = new Customer("Lily", NoCard,2);

        // Add items to customers' lists
        JohnWithGoldenCard.addItem(FoodItem);
        JohnWithGoldenCard.addItem(PhoneItem);
        AliceWithSilverCard.addItem(FoodItem);
        BobWithAffiliateCard.addItem(PhoneItem);
        BobWithAffiliateCard.addItem(BookItem);
        LilyWithNoCard.addItem(BookItem);

        //JohnWithGoldenCard.setCard(Affiliate);
        

        displayItemsForCustomer(JohnWithGoldenCard);
        displayItemsForCustomer(AliceWithSilverCard);
        displayItemsForCustomer(BobWithAffiliateCard);
        displayItemsForCustomer(LilyWithNoCard);

        // Calculate total price
        double totalPriceForJohn = calculateTotalPrice(JohnWithGoldenCard);
        double totalPriceForAlice = calculateTotalPrice(AliceWithSilverCard);
        double totalPriceForBob = calculateTotalPrice(BobWithAffiliateCard);
        double totalPriceForLily = calculateTotalPrice(LilyWithNoCard);

        // Display total prices for each customer
        System.out.println("Total price for John: $" + totalPriceForJohn);
        System.out.println("Total price for Alice: $" + totalPriceForAlice);
        System.out.println("Total price for Bob: $" + totalPriceForBob);
        System.out.println("Total price for Lily: $" + totalPriceForLily);

    }


}