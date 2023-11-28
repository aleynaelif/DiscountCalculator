package org.example;

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
