package com.example.sampleproject.model;

public class MyCard {
    private Rank rank;
    private Suit suit;

    public MyCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
