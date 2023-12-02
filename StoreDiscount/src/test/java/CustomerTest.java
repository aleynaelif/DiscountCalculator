package org.example; // Ensure the package structure matches the tested class

import org.junit.Test;
import static org.junit.Assert.*;
import static org.example.Constants.*;

public class CustomerTest {

    @Test
    public void testCustomerItems() {

        Card goldenCard = new Card(Constants.GOLDEN_CARD);
        Card silverCard = new Card(Constants.SILVER_CARD);
        Card affiliateCard = new Card(Constants.AFFILIATE);
        Card noCard = new Card(Constants.NO_CARD);

        // Create items for testing
        Item foodItem = new Item(FOOD, FOOD_PRICE, false);
        Item phoneItem = new Item(PHONE,PHONE_PRICE, true);
        Item bookItem = new Item(BOOK,BOOK_PRICE, false);



        // Create customers with different types of cards
        Customer johnWithGoldenCard = new Customer("John", goldenCard, DISCOUNT_YEAR_LIMIT);
        johnWithGoldenCard.addItem(foodItem);
        johnWithGoldenCard.addItem(phoneItem);

        Customer aliceWithSilverCard = new Customer("Alice", silverCard, DISCOUNT_YEAR_LIMIT);
        aliceWithSilverCard.addItem(foodItem);

        Customer bobWithAffiliateCard = new Customer("Bob", affiliateCard, DISCOUNT_YEAR_LIMIT);
        bobWithAffiliateCard.addItem(phoneItem);
        bobWithAffiliateCard.addItem(bookItem);

        Customer lilyWithNoCard = new Customer("Lily", noCard, LESS_THAN_DISCOUNT_YEAR_LIMIT);
        lilyWithNoCard.addItem(bookItem);


        // Assertions to check the created customers and their items
        assertEquals("John", johnWithGoldenCard.getName());
        assertEquals(2, johnWithGoldenCard.getItems().size()); // Check the number of items for John

        assertEquals("Alice", aliceWithSilverCard.getName());
        assertEquals(1, aliceWithSilverCard.getItems().size()); // Check the number of items for Alice

        assertEquals("Bob", bobWithAffiliateCard.getName());
        assertTrue(bobWithAffiliateCard.getItems().contains(phoneItem)); // Check if Bob has phoneItem
        assertTrue(bobWithAffiliateCard.getItems().contains(bookItem)); // Check if Bob has bookItem

        assertEquals("Lily", lilyWithNoCard.getName());
        assertTrue(lilyWithNoCard.getItems().contains(bookItem)); // Check if Lily has bookItem


        // Calculate and display total price for each customer
        calculateAndDisplayTotalPrice(johnWithGoldenCard);
        calculateAndDisplayTotalPrice(aliceWithSilverCard);
        calculateAndDisplayTotalPrice(bobWithAffiliateCard);
        calculateAndDisplayTotalPrice(lilyWithNoCard);
    }

    static void calculateAndDisplayTotalPrice(Customer customer) {
        DiscountCalculator.displayItemsForCustomer(customer);
        double totalPrice = DiscountCalculator.calculateTotalPrice(customer);
        System.out.println("Total price for " + customer.getName() + ": $" + totalPrice +"\n");

    }
}