/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SicBo;

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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class SicBoMenuController implements Initializable {

    @FXML
    private Button Start;
    @FXML
    private Label kontostand;
    @FXML
    private Button Zurück;
    @FXML
    private AnchorPane panee;

    static String name;         //Statische Variable erzeugen, wird nicht verändert
    DBController d = null;      //DatenbankController erzeugen, der nötig ist um eine Datenbankanbindung zu erstellen

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    //Start Methode, wenn das Fenster geöffnet wird, werden die Befehle gestartet
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    //Name des Spieler bekommen
    public void setName(String name) {
        SicBoMenuController.name = name;
    }

    //Beim Bewegen des Mouse wird der Konto angezeigt
    @FXML
    private void Konto(MouseEvent event) throws SQLException {
        kontostand.setText("" + d.getKonto(name));
    }

    //Beim Drücken des Buttons kommt man ins Fenster vom Spiel
    @FXML
    private void start(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SicBoSpiel.fxml"));
        panee.getChildren().setAll(pane);

    }

    //Beim Drücken des Buttons geht man zur Home Seite zurück
    @FXML
    private void zurück(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        panee.getChildren().setAll(pane);
    }

    //Beim Drücken des Buttons werden die Spielregeln angezeigt
    @FXML
    private void spielRegeln(ActionEvent event) {
        String html = "<html><body>"
                + "<p>Zunächst müssen Sie Ihre Wetten platzieren. <br>"
                + "<p>Sie können sich auf eine beschränken oder mehrere Einsätze tätigen. <br>"
                + "<p>Sie müssen dabei aber immer das Tischlimit und natürlich Ihr Budget <br>"
                + "<p>im Auge behalten. Danach klicken Sie ganz einfach auf 'Wetten' und <br>"
                + "<p>die Würfel werden gemischt. Sie müssen nur mehr abwarten, auf welcher <br>"
                + "<p>Seite der Würfel stehenbleibt und dann die Kombination mit Ihrer Wette <br>"
                + "<p>abgleichen. Wenn Sie richtig geraten haben, werden Ihre Gewinne automatisch<br>"
                + "<p>berechnet und Sie erhalten diese innerhalb weniger Sekunden.";
        JOptionPane.showMessageDialog(null, String.format(html));
    }
}
