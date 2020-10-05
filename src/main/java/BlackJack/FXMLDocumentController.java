/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Besitzer
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button startButton;
    @FXML
    private Label titel;
    @FXML
    private Button regelnButton;
    @FXML
    private ImageView background;
    @FXML
    private Button quitButton;
    @FXML
    private AnchorPane aphome;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        background.setImage(new Image("blackJack.png"));
    }    

    @FXML
    private void starten(ActionEvent event) throws IOException                  //Spiel starten
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLSpiel.fxml"));
        aphome.getChildren().setAll(pane);
    }

    @FXML
    private void rules(ActionEvent event) throws IOException                    //Regeln öffnen
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLRule.fxml"));
        aphome.getChildren().setAll(pane);
    }

    @FXML
    private void quit(ActionEvent event) throws IOException                                        //Spiel verlassen
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        aphome.getChildren().setAll(pane);
    }
    
}
