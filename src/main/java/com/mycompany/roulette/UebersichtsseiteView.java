/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.roulette;

import Casino.DBController;
import SicBo.SicBoSpielController;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ivanf
 */
public class UebersichtsseiteView implements Initializable, PropertyChangeListener {

    private Modell modell;
    @FXML
    private AnchorPane apHome;
    
    static String name;
    DBController db = null;
    
    @FXML
    private Label nutzer;
    @FXML
    private Label kontos;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            //Datenbankcontroller erstellen
            db = new DBController();
        } catch (SQLException ex) {
            //Fehler ausgeben falls der Controller nicht erzeugt werden konnte
            Logger.getLogger(SicBoSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Startet das Spiel wenn man auf den Starten Button klickt
     * @param event
     * @throws Exception 
     */
    @FXML
    private void startenAction(ActionEvent event) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Spielseite.fxml"));
        apHome.getChildren().setAll(pane);
    }

    /**
     * setzt das Modell
     * @param modell 
     */
    public void setModell(Modell modell) {
        this.modell = modell;
    }

    /**
     * Methode die von der Schnittstelle implementiert wird, um PropertyChange abzufangen
     * @param evt 
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    /**
     * Zeigt die Anleitung an, wenn man auf den Button Anleitung drückt
     * @param event 
     */
    @FXML
    private void regelnAction(ActionEvent event) {
        String html = "<html><body>"
                + "<p>Als erstes müssen Sie einen Einsatz machen (Jetons auswählen) und können in auch löschen. <br>"
                + "<p>Dann bei der Combobox die gewünschten Felder wählen. <br>"
                + "<p>Wenn Sie alle Ihre Einsätze getätigt haben, können Sie auf den Button Drehen drücken. <br>"
                + "<p>Jetzt steht unten links, ob sie gewonnen haben und oben Links können Sie wieder zur Lobby";     
        JOptionPane.showMessageDialog(null, String.format(html));
    }

    @FXML
    private void konto(MouseEvent event) throws SQLException {
        nutzer.setText(name);
        kontos.setText(""+db.getKonto(name));
    }
    
    public void setName(String name) {
        UebersichtsseiteView.name = name;
    }
}
