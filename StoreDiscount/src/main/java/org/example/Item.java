package org.example;

public class Item {
    private double price;
    private boolean isPhone; // Indicates if the item is a phone

    public Item(double price, boolean isPhone) {
        this.price = price;
        this.isPhone = isPhone;
    }

    // Getter and setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and setter for isPhone
    public boolean isPhone() {
        return isPhone;
    }

    public void setPhone(boolean phone) {
        isPhone = phone;
    }
}
