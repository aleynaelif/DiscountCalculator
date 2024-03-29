package org.example; // Ensure the package structure matches the tested class

import org.junit.Test;
import static org.junit.Assert.*;
import static org.example.Constants.*;

public class CustomerTest {

    @Test
    public void testCustomerItems() {

        //Create different types of cards
        Card goldenCard = new Card(Constants.GOLDEN_CARD);
        Card silverCard = new Card(Constants.SILVER_CARD);
        Card affiliateCard = new Card(Constants.AFFILIATE);
        Card noCard = new Card(Constants.NO_CARD);

        // Create items for testing
        Item foodItem = new Item(FOOD, FOOD_PRICE, false);
        Item phoneItem = new Item(PHONE,PHONE_PRICE, true);
        Item bookItem = new Item(BOOK,BOOK_PRICE, false);

        // Create customers with different types of cards
        //John with golden card
        Customer johnWithGoldenCard = new Customer("John", goldenCard, DISCOUNT_YEAR_LIMIT);
        johnWithGoldenCard.addItem(foodItem);
        johnWithGoldenCard.addItem(phoneItem);

        //Alice with silver card
        Customer aliceWithSilverCard = new Customer("Alice", silverCard, DISCOUNT_YEAR_LIMIT);
        aliceWithSilverCard.addItem(foodItem);

        //Bob with affiliate card
        Customer bobWithAffiliateCard = new Customer("Bob", affiliateCard, DISCOUNT_YEAR_LIMIT);
        bobWithAffiliateCard.addItem(phoneItem);
        bobWithAffiliateCard.addItem(bookItem);

        //Lily with no card
        Customer lilyWithNoCard = new Customer("Lily", noCard, LESS_THAN_DISCOUNT_YEAR_LIMIT);
        lilyWithNoCard.addItem(bookItem);

        //Dora with no card and no items
        Customer doraWithNoCard = new Customer("Dora", noCard, LESS_THAN_DISCOUNT_YEAR_LIMIT);



        // Assertions to check the created customers and their items
        assertEquals(560, DiscountCalculator.calculateTotalPrice(johnWithGoldenCard),0.0);

        assertEquals(80.0, DiscountCalculator.calculateTotalPrice(aliceWithSilverCard),0.0);

        assertEquals(665.0, DiscountCalculator.calculateTotalPrice(bobWithAffiliateCard),0.0);

        assertEquals(195.0, DiscountCalculator.calculateTotalPrice(lilyWithNoCard),0.0);

        assertEquals(0,doraWithNoCard.getItems().size());


        // Calculate and display total price for each customer in the terminal
        DiscountCalculator.displayItemsForCustomer(johnWithGoldenCard);
        DiscountCalculator.displayItemsForCustomer(aliceWithSilverCard);
        DiscountCalculator.displayItemsForCustomer(bobWithAffiliateCard);
        DiscountCalculator.displayItemsForCustomer(lilyWithNoCard);
        DiscountCalculator.displayItemsForCustomer(doraWithNoCard);
        //johnWithGoldenCard.getCard().setCardType(AFFILIATE);
        //DiscountCalculator.displayItemsForCustomer(johnWithGoldenCard);
    }
}