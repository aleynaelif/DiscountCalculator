package org.example;

public class Item {

    private String name;
    private double price;
    private boolean isPhone; // Indicates if the item is a phone

    public Item(String name, double price, boolean isPhone) {
        this.name = name;
        this.price = price;
        this.isPhone = isPhone;
    }

    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPhone() {
        return isPhone;
    }

    public void setPhone(boolean phone) {
        isPhone = phone;
    }
}
