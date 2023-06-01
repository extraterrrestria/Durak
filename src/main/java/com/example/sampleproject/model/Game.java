package com.example.sampleproject.model;

public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    public Game() {
        player1 = new Player();
        player2 = new Player();
        deck = new Deck();

        takeCard(player1);
        takeCard(player2);
    }

    private void takeCard(Player player) {
        for (int i = 0; i < 6; i++) {
            player.put(deck.take());
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
