package org.example;

public class Customer {
    private final boolean IsAffiliate;

    //Constructor
    public Customer(Boolean IsAffiliate) {
        this.IsAffiliate = IsAffiliate;
    }

    //Getter
    public boolean getAffiliate(){
        return IsAffiliate;
    }
}
