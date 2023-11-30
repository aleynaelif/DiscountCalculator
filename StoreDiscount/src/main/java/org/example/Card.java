package org.example;

import java.util.List;

import static org.example .Constants.*;

//Superclass
public class Card {
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

}
