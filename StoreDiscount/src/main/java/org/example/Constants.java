package org.example;

public class Constants {

    private Constants() { throw new IllegalStateException("Constants class"); }
    public static final String GOLDEN_CARD = "Golden";
    public static final String SILVER_CARD = "Silver";
    public static final String AFFILIATE = "Affiliate";
    public static final String NO_CARD = "No";
    public static final String FOOD = "Food";
    public static final double FOOD_PRICE = 100.0;
    public static final String PHONE = "Phone";
    public static final double PHONE_PRICE = 500.0;
    public static final String BOOK = "Book";
    public static final double BOOK_PRICE = 200.0;
    public static final double GOLDEN_DISCOUNT_PERCENTAGE = 0.3;
    public static final double SILVER_DISCOUNT_PERCENTAGE = 0.2;
    public static final double AFFILIATE_DISCOUNT_PERCENTAGE = 0.1;
    public static final double YEAR_DISCOUNT_PERCENTAGE = 0.05;
    public static final int DISCOUNT_YEAR_LIMIT = 2;
    public static final int LESS_THAN_DISCOUNT_YEAR_LIMIT = 1;
    public static final int DISCOUNT_DOLLAR_LIMIT = 200;
    public static final double DOLLAR_DISCOUNT = 5.0;
}
