package org.example;

import java.util.List;

import static org.example.Constants.*;

public class DiscountCalculator {
    public static double calculateDiscount(Item item, Customer customer) {
        double discountPercentage = 1.0;

        if(!item.isPhone()) {    // Check if the items contain a phone and if so, do not apply the percentage discount

            // Calculate discount based on card type and affiliate status using constants
            if (GOLDEN_CARD.equals(customer.getCard().getCardType())) {
                discountPercentage = GOLDEN_DISCOUNT_PERCENTAGE;
            } else if (SILVER_CARD.equals(customer.getCard().getCardType())) {
                discountPercentage = SILVER_DISCOUNT_PERCENTAGE;
            } else if (AFFILIATE.equals(customer.getCard().getCardType())) {
                discountPercentage = AFFILIATE_DISCOUNT_PERCENTAGE; // 10% discount for affiliates
            } else if(NO_CARD.equals(customer.getCard().getCardType()) && customer.getYears() >= DISCOUNT_YEAR_LIMIT){
                discountPercentage = YEAR_DISCOUNT_PERCENTAGE;
            }
        }

        return discountPercentage;
    }

    public static double calculateAdditionalDiscount(double totalPrice) {

        // Calculate additional discount based on total spent
        if(totalPrice >= DISCOUNT_DOLLAR_LIMIT)
            totalPrice = totalPrice - ((int)(totalPrice / DISCOUNT_DOLLAR_LIMIT) * DISCOUNT_DOLLAR_DISCOUNT);
        return totalPrice;
    }

    public static double calculateTotalPrice(Customer customer) {
        double totalPrice = 0.0;

        // Calculate the total price of items
        List<Item> items = customer.getItems();
        for (Item item : items) {
            totalPrice += calculateDiscount(item, customer) * item.getPrice();
        }

        totalPrice = calculateAdditionalDiscount(totalPrice);

        return totalPrice;
    }

    static void displayItemsForCustomer(Customer customer) {
        System.out.println("Items associated with " + customer.getName() + ":");
        List<Item> items = customer.getItems();
        for (Item item : items) {
            System.out.println("Price: $" + item.getPrice() + ", Name: " + item.getName());
        }
        System.out.println();
    }

}
