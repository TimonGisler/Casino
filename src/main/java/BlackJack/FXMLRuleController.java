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
 * FXML Controller class
 *
 * @author Besitzer
 */
public class FXMLRuleController implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private ImageView ruleBack;
    @FXML
    private Label titel;
    @FXML
    private Label ziel;
    @FXML
    private Label zielBesch;
    @FXML
    private Label kartenwerte;
    @FXML
    private Label kartenwerteBesch;
    @FXML
    private Label blackJack;
    @FXML
    private Label blackJackBesch;
    @FXML
    private Label versichern;
    @FXML
    private Label versichernBesch;
    @FXML
    private Label verdoppeln;
    @FXML
    private Label verdoppelnBesch;
    @FXML
    private AnchorPane aphome;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
//        ruleBack.setImage(new Image("Bilder/ruleBackground.png"));
    }    

    @FXML
    private void back(ActionEvent event) throws IOException                     //Regeln verlassen
    {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        aphome.getChildren().setAll(pane);
    }
    
}
