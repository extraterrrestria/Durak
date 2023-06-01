package com.example.sampleproject.model;

import java.util.ArrayList;

public class Player {
    private ArrayList<MyCard> cards;

    public Player() {
        cards = new ArrayList<>();
    }

    public void put(MyCard card) {
        cards.add(card);
    }

    public ArrayList<MyCard> getCards() {
        return cards;
    }
}
