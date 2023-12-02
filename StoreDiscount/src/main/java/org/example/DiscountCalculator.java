package org.example;

import java.util.List;

import static org.example.Constants.*;

public class DiscountCalculator {

    private static double discountPercentage;
    private static double additionalDiscount;
    private static double totalPrice;


    public double getDiscountPercentage(){ return discountPercentage; }
    public static void setDiscountPercentage(){ DiscountCalculator.discountPercentage = 0.0;}
    public double getAdditionalDiscount(){ return additionalDiscount; }
    public static void setAdditionalDiscount(){ DiscountCalculator.additionalDiscount = 0.0;}

    public double getTotalPrice(){ return totalPrice; }
    public static void setTotalPrice(){ DiscountCalculator.totalPrice = 0.0;}

    public static double discountPercentageDecider(Item item, Customer customer) {
        setDiscountPercentage();

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
        }else{
            setDiscountPercentage();
        }

        return discountPercentage;
    }

    public static double calculateAdditionalDiscount() {

        setAdditionalDiscount();

        // Calculate additional discount based on total spent
        if(totalPrice >= DISCOUNT_DOLLAR_LIMIT) {
            additionalDiscount = (int) (totalPrice / DISCOUNT_DOLLAR_LIMIT) * DOLLAR_DISCOUNT;
            totalPrice = totalPrice - additionalDiscount;
        }
        return totalPrice;
    }

    public static double calculateTotalPrice(Customer customer) {
        setTotalPrice();
        // Calculate the total price of items
        List<Item> items = customer.getItems();
        for (Item item : items) {
            totalPrice += item.getPrice() - (discountPercentageDecider(item, customer) * item.getPrice());
        }

        totalPrice = calculateAdditionalDiscount();

        return totalPrice;
    }

    static void displayItemsForCustomer(Customer customer) {
        double percentageDiscount;
        System.out.println("\n\n" + customer.getName() + " With " + customer.getCard().getCardType() + " Card");
        System.out.println("\nItem           Price\n--------------------------");
        List<Item> items = customer.getItems();
        for (Item item : items) {
            System.out.println(item.getName() + "            $" + item.getPrice());
            percentageDiscount = discountPercentageDecider(item, customer) * item.getPrice();
            if(percentageDiscount > 0) {
                System.out.println("% Discount      -$" + percentageDiscount);
            }
        }
        totalPrice = calculateTotalPrice(customer);

        if(additionalDiscount > 0) {
            System.out.println("Add Discount    -$" + additionalDiscount);
        }
        System.out.println("+");
        System.out.println("--------------------");
        System.out.println("Total price for " + customer.getName() + ": $" + totalPrice +"\n");
    }

}
