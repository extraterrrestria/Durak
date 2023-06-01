package com.example.sampleproject;

import java.io.IOException;

import com.example.sampleproject.model.Game;
import com.example.sampleproject.model.MyCard;
import com.example.sampleproject.model.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameWindowController {

    @FXML
    private Button addCardButton;

    @FXML
    private GridPane deskAttackCardPane;

    @FXML
    private GridPane deskAnswerCardPane;
    
    @FXML
    private ScrollPane firstPlayerScroll;

    @FXML
    private ScrollPane secondPlayerScroll;

    @FXML
    private FlowPane firstPlayerPane;

    @FXML
    private FlowPane secondPlayerPane;

    private Game game = new Game();

    @FXML
    void addCard(ActionEvent event) throws IOException, InterruptedException {
    	addCards(game.getPlayer1(), firstPlayerPane, firstPlayerScroll);
        addCards(game.getPlayer2(), secondPlayerPane, secondPlayerScroll);
    }

    void addCards(Player player, FlowPane playerPanel, ScrollPane scrollPane) throws IOException {
        for(MyCard card : player.getCards()) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Card.fxml"));

            Pane newPane = (Pane) loader.load();

            CardController cardController = loader.getController();
            cardController.setCardParameters(card, this, newPane);

            playerPanel.getChildren().add(newPane);

            //scrollPane = new ScrollPane();
            //scrollPane.setContent(playerPanel);
        }
    }

    public void addCardOnTable(CardController card) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Card.fxml"));
        
    	Pane newPane = (Pane)loader.load();
    	
    	CardController cardController = loader.getController();
    	cardController.setCardParameters(card.getCard(), this, newPane);
    	
    	deskAttackCardPane.add(newPane, deskAttackCardPane.getChildren().size(), 0);
    }
}
