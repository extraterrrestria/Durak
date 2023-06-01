package com.example.sampleproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import com.example.sampleproject.model.MyCard;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class CardController {
	Pane cardPane;
	
	GameWindowController gameWindow;

    @FXML
    private Text nominal;

    @FXML
    private Text mask;

    @FXML
    private ImageView imgBuffer;

    @FXML
    private Pane imgPane;

    private MyCard card;

    public MyCard getCard() {
        return card;
    }

    // @FXML
   // private Text smth;

    public void setCardParameters(MyCard card, GameWindowController gameWindow, Pane cardPane) throws FileNotFoundException {
    	this.nominal.setText(card.getRank().name());
    	this.mask.setText(card.getSuit().name());
    	this.gameWindow = gameWindow;
    	this.cardPane = cardPane;
        this.card = card;

        URL url = HelloApplication.class.getResource("EntrancePicture.jpg");
        File img = null; // ("C:\\Users\\Boris\\eclipse-workspace\\Durak_0.1\\img\\EntrancePicture.jpg");
        try {
            img = new File(url.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        InputStream isImage = (InputStream) new FileInputStream(img);
    	imgBuffer = new ImageView(new Image(isImage));
    	imgBuffer.setFitWidth(100);
    	imgBuffer.setPreserveRatio(true);
    	//imgBuffer.setSmooth(true);
    	
    	//cardPane.getChildren().add(imgBuffer);
    	
    	//imgPane = new Pane();
    	imgPane.getChildren().setAll(imgBuffer);
    	
    }
    
    public String getNominal() {
    	return this.nominal.getText();
    }
    
    public String getMask() {
    	return this.mask.getText();
    }
    
    @FXML
    void replaceCardToTable(MouseEvent event) throws IOException {
    	gameWindow.addCardOnTable(this);
    	cardPane.setVisible(false);
    	//FlowPane firstPlayerPane = (FlowPane) cardPane.getParent();
    	//firstPlayerPane.getChildren().remove(cardPane);
    }
}