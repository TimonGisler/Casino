/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yatzy;

import Casino.DBController;
import Casino.EinlogController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author niels
 */
public class FXMLUebersichtYatzyController implements Initializable {

    @FXML
    private Button btnPlayGame;
    @FXML
    private Button btnBack;
    @FXML
    private Label kontostand;
    @FXML
    private AnchorPane rootpane;
    
    static String name;         //Statische Variable erzeugen, wird nicht verändert
    DBController d = null;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rootpane.setStyle("-fx-background-image: url(/styles/02_SICBO_012.png); -fx-background-size: 130% 100%");
        try {
            //Datenbankcontroller erstellen
            d = new DBController();
        } catch (SQLException ex) {
            //Fehler ausgeben falls der Controller nicht erzeugt werden konnte
            Logger.getLogger(EinlogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (d.createConnection() != null) {
            //Falls die Verbindung erzeugt werden konnte, gibt "Verbindung aufgebaut aus"
            System.out.println("Verbindung aufgebaut");
        }
    }
    
    public void setName(String name) {
        FXMLUebersichtYatzyController.name = name;
    }

    //Beim Bewegen des Mouse wird der Konto angezeigt
    @FXML
    private void Konto(MouseEvent event) throws SQLException {
        kontostand.setText("Kontostand: " + d.getKonto(name));
    }
    
    @FXML
    private void actionPlayGame(ActionEvent event){
       try{
           AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLYatzySpiel.fxml"));
           rootpane.getChildren().setAll(pane);
       }
       catch(IOException e)
       {
           System.err.println(e.getMessage());
       }
       
    }

    @FXML
    private void actionGoBack(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
}
