package com.example.sampleproject.model;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<MyCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        for(Rank rank : Rank.values()) {
            for(Suit suit : Suit.values()) {
                MyCard card = new MyCard(rank, suit);
                cards.add(card);
            }
        }

        Collections.shuffle(cards);
    }

    public MyCard take() {
        MyCard card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
