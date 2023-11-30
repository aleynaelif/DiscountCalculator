package org.example;

import java.util.List;

import static org.example.Constants.*;

public class DiscountCalculator {
    public static double calculateDiscount(Item item, DiscountContext context) {
        double discountPercentage = 1.0;

        Customer customer = context.getCustomer();

        if(!item.isPhone()) {    // Check if the items contain a phone and if so, do not apply the percentage discount

            // Calculate discount based on card type and affiliate status using constants
            if (GOLDEN_CARD.equals(customer.getCard().getCardType())) {
                discountPercentage = GOLDEN_DISCOUNT_PERCENTAGE;
            } else if (SILVER_CARD.equals(customer.getCard().getCardType())) {
                discountPercentage = SILVER_DISCOUNT_PERCENTAGE;
            } else if (AFFILIATE.equals(customer.getCard().getCardType())) {
                discountPercentage = AFFILIATE_DISCOUNT_PERCENTAGE; // 10% discount for affiliates
            } else if(NO_CARD.equals(customer.getCard().getCardType()) && context.getCustomer().getYears() >= DISCOUNT_YEAR_LIMIT){
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

    public static double calculateTotalPrice(DiscountContext context) {
        double totalPrice = 0.0;

        // Calculate the total price of items
        List<Item> items = context.getItems();
        for (Item item : items) {
            totalPrice += calculateDiscount(item, context) * item.getPrice();
        }

        totalPrice = calculateAdditionalDiscount(totalPrice);

        // Apply discount using the Card's calculateDiscount method
        return totalPrice;
    }

    static void displayItemsForCustomer(DiscountContext context) {
        System.out.println("Items associated with " + context.getCustomer().getName() + ":");
        List<Item> items = context.getCustomer().getItems();
        for (Item item : items) {
            System.out.println("Price: $" + item.getPrice() + ", Phone: " + item.isPhone());
        }
        System.out.println();
    }

}
