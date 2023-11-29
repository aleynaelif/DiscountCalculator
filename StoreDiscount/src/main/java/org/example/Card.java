package org.example;

import java.util.List;

//Superclass
public class Card {

    public static final String GOLDEN_CARD = "Golden";
    public static final String SILVER_CARD = "Silver";
    public static final String AFFILIATE = "Affiliate";
    public static final double GOLDEN_DISCOUNT_PERCENTAGE = 0.7;
    public static final double SILVER_DISCOUNT_PERCENTAGE = 0.8;
    public static final double AFFILIATE_DISCOUNT_PERCENTAGE = 0.9;


    private String cardType;

    public Card(String cardType){
        this.cardType = cardType;
    }

    public String getCardType(){
        return cardType;
    }

    public void setCardType(String cardType){
        this.cardType = cardType;
    }

    public double calculateDiscount (Item item) {
        double discountPercentage = 1.0;

        if(!item.isPhone()) {    // Check if the items contain a phone and if so, do not apply the percentage discount

            // Calculate discount based on card type and affiliate status using constants
            if (GOLDEN_CARD.equals(cardType)) {
                discountPercentage = GOLDEN_DISCOUNT_PERCENTAGE;
            } else if (SILVER_CARD.equals(cardType)) {
                discountPercentage = SILVER_DISCOUNT_PERCENTAGE;
            } else if (AFFILIATE.equals(cardType)) {
                discountPercentage = AFFILIATE_DISCOUNT_PERCENTAGE; // 10% discount for affiliates
            }
        }

        return discountPercentage;
    }

}
