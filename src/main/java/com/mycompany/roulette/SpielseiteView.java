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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ivanf
 */
public class SpielseiteView implements Initializable, PropertyChangeListener {

    /**
     * Variablendeklaration
     */
    private Modell modell = new Modell();
    @FXML
    private ImageView zehnerChip;
    @FXML
    private ImageView zwanzigerChip;
    @FXML
    private ImageView fünfhunderterChip;
    @FXML
    private Label einsatzID;
    @FXML
    private ImageView fünfzigerChip;
    @FXML
    private ImageView hunderterChip;
    @FXML
    private Label farbeID;
    @FXML
    private Label feldID;
    @FXML
    private ComboBox<String> feldAuswahlID;
    @FXML
    private Label einsatzTotalID;
    @FXML
    private Label outcome;
    @FXML
    private Label kontoStandID;

    private final StringProperty einsatz = new SimpleStringProperty();
    private final StringProperty farbe = new SimpleStringProperty();
    private final StringProperty feld = new SimpleStringProperty();
    private final StringProperty kontoStand = new SimpleStringProperty();
    private final StringProperty einsatzTotal = new SimpleStringProperty();

    DBController db = null;
    
    static String name;
    ObservableList<String> liste = FXCollections.observableArrayList();
    @FXML
    private AnchorPane apHome;
    @FXML
    private Label nutzer;

    /**
     * Methode die der Liste die Felder hinzufügt
     */
    public SpielseiteView() {
        liste.add(Felder.Feld_0.toString());
        liste.add(Felder.Feld_1.toString());
        liste.add(Felder.Feld_2.toString());
        liste.add(Felder.Feld_3.toString());
        liste.add(Felder.Feld_4.toString());
        liste.add(Felder.Feld_5.toString());
        liste.add(Felder.Feld_6.toString());
        liste.add(Felder.Feld_7.toString());
        liste.add(Felder.Feld_8.toString());
        liste.add(Felder.Feld_9.toString());
        liste.add(Felder.Feld_10.toString());
        liste.add(Felder.Feld_11.toString());
        liste.add(Felder.Feld_12.toString());
        liste.add(Felder.Feld_13.toString());
        liste.add(Felder.Feld_14.toString());
        liste.add(Felder.Feld_15.toString());
        liste.add(Felder.Feld_16.toString());
        liste.add(Felder.Feld_17.toString());
        liste.add(Felder.Feld_18.toString());
        liste.add(Felder.Feld_19.toString());
        liste.add(Felder.Feld_20.toString());
        liste.add(Felder.Feld_21.toString());
        liste.add(Felder.Feld_22.toString());
        liste.add(Felder.Feld_23.toString());
        liste.add(Felder.Feld_24.toString());
        liste.add(Felder.Feld_25.toString());
        liste.add(Felder.Feld_26.toString());
        liste.add(Felder.Feld_27.toString());
        liste.add(Felder.Feld_28.toString());
        liste.add(Felder.Feld_29.toString());
        liste.add(Felder.Feld_30.toString());
        liste.add(Felder.Feld_31.toString());
        liste.add(Felder.Feld_32.toString());
        liste.add(Felder.Feld_33.toString());
        liste.add(Felder.Feld_34.toString());
        liste.add(Felder.Feld_35.toString());
        liste.add(Felder.Feld_36.toString());
        liste.add(Felder.Rot.toString());
        liste.add(Felder.Schwarz.toString());
        liste.add(Felder.Gerade.toString());
        liste.add(Felder.Ungerade.toString());
        liste.add(Felder.Feld_1_to_Feld_18.toString());
        liste.add(Felder.Feld_19_to_Feld_36.toString());
        liste.add(Felder.Erste_Spalte.toString());
        liste.add(Felder.Zweite_Spalte.toString());
        liste.add(Felder.Dritte_Spalte.toString());
        liste.add(Felder.Erste_12.toString());
        liste.add(Felder.Zweite_12.toString());
        liste.add(Felder.Dritte_12.toString());
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        feldAuswahlID.setItems(liste);
        try {
            //Datenbankcontroller erstellen
            db = new DBController();
        } catch (SQLException ex) {
            //Fehler ausgeben falls der Controller nicht erzeugt werden konnte
            Logger.getLogger(SicBoSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Verbindung mit Modell
     *
     * @param event
     */
    @FXML
    private void zehnerAction(MouseEvent event) {
        einsatzID.setText(""+modell.zehnerAction());
        einsatzTotalID.setText(""+modell.getEinsatzT());
    }

    @FXML
    private void zwanzigerAction(MouseEvent event) {
        einsatzID.setText(""+modell.zwanzigerAction());
        einsatzTotalID.setText(""+modell.getEinsatzT());
    }

    @FXML
    private void fünfzigerAction(MouseEvent event) {
        einsatzID.setText(""+modell.fünfzigerAction());
        einsatzTotalID.setText(""+modell.getEinsatzT());
    }

    @FXML
    private void hunderterAction(MouseEvent event) {
        einsatzID.setText(""+modell.hunderterAction());
        einsatzTotalID.setText(""+modell.getEinsatzT());
    }

    @FXML
    private void fünfhunderterAction(MouseEvent event) {
        einsatzID.setText(""+modell.fünfhunderterAction());
        einsatzTotalID.setText(""+modell.getEinsatzT());
    }

    /**
     * Binded die Labels mit den jeweiligen Variablen
     */
    public void bind() {
        einsatzID.textProperty().bind(einsatz);
        feldID.textProperty().bind(feld);
        farbeID.textProperty().bind(farbe);
        kontoStandID.textProperty().bind(kontoStand);
        einsatzTotalID.textProperty().bind(einsatzTotal);
    }

//    public void setModell(Modell modell) {
//        this.modell = modell;
//    }

    /**
     * Eine Methode die den Einsatzwert aus dem Modell nimmt.
     *
     * Switch Case für die propertyChange Methode
     * 
     * @param evt
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "Einsatz":
                einsatz.set(evt.getNewValue().toString());
                break;
        }
        switch (evt.getPropertyName()) {
            case "Zahl":
                feld.set(evt.getNewValue().toString());
                break;
        }
        switch (evt.getPropertyName()) {
            case "Farbe":
                farbe.set(evt.getNewValue().toString());
                break;
        }
        switch (evt.getPropertyName()) {
            case "Kontostand":
                kontoStand.set(evt.getNewValue().toString());
                break;
        }
        switch (evt.getPropertyName()) {
            case "Einsatz Total":
                einsatzTotal.set(evt.getNewValue().toString());
                break;
        }
    }

    /**
     * Mit einem Button kann man das Spiel verlassen
     * @param event 
     */
    @FXML
    private void verlassenAction(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        apHome.getChildren().setAll(pane);
    }
    
    public void setName(String name) {
        SpielseiteView.name = name;
    }
    
    @FXML
    private void drehenAction(ActionEvent event) throws SQLException {
        modell.drehenAction();
        farbeID.setText("" + modell.getFarbe());
        feldID.setText(""+ modell.getZahl());
        int wetten;
        int wette;
        

        switch (modell.getAusgewähltesFeld()) {
            case "Rot":
                if (modell.farb_gewonnen()) {
                    wette = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                    
                } else {
                    outcome.setText("verloren");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Schwarz":
                if (modell.farb_gewonnen()) {
                    wette = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                } else {
                    outcome.setText("verloren");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Gerade":
                if (modell.checkGeradeUngeradeGewonnen()) {
                    wette = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }

                break;

            case "Ungerade":
                if (modell.checkGeradeUngeradeGewonnen()) {
                    wette = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Feld_1_to_Feld_18":
                if (modell.istNiedrig()) {
                    wette = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Feld_19_to_Feld_36":
                if (!modell.istNiedrig()) {
                    wette = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Erste_12":
                if (modell.erstesDutzend()) {
                    wetten = Integer.parseInt(einsatzID.getText())*2;
                    outcome.setText("Du hast " + wetten + " gewonnen");
                    db.updateKontoHome(wetten, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Zweite_12":
                if (modell.zweitesDutzend()) {
                    wetten = Integer.parseInt(einsatzID.getText())*3;
                    outcome.setText("Du hast " + wetten + " gewonnen");
                    db.updateKontoHome(wetten, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Dritte_12":
                if (modell.drittesDutzend()) {
                    wetten = Integer.parseInt(einsatzID.getText())*3;
                    outcome.setText("Du hast " + wetten + " gewonnen");
                    db.updateKontoHome(wetten, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Erste_Spalte":
                if (modell.ersteSpalte()) {
                    wetten = Integer.parseInt(einsatzID.getText())*3;
                    outcome.setText("Du hast " + wetten + " gewonnen");
                    db.updateKontoHome(wetten, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Zweite_Spalte":
                if (modell.zweiteSpalte()) {
                    wetten = Integer.parseInt(einsatzID.getText())*3;
                    outcome.setText("Du hast " + wetten + " gewonnen");
                    db.updateKontoHome(wetten, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;

            case "Dritte_Spalte":
                if (modell.dritteSpalte()) {
                    wetten = Integer.parseInt(einsatzID.getText())*3;
                    outcome.setText("Du hast " + wetten + " gewonnen");
                    db.updateKontoHome(wetten, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
                break;
            default:
                if (modell.einzelneZahl()) {
                    wette = Integer.parseInt(einsatzID.getText())*35;
                    outcome.setText("Du hast " + wette + " gewonnen");
                    db.updateKontoHome(wette, name);
                } else {
                    outcome.setText("VERLOREN");
                    int minus = 0 - Integer.parseInt(einsatzID.getText());
                    db.updateKontoHome(minus, name);
                }
        }

//        if (modell.getAusgewähltesFeld().equals("Rot") || modell.getAusgewähltesFeld().equals("Schwarz")) {
//            modell.farb_gewonnen();
//
//        } else {
//            modell.einzelneZahl();
//            if (modell.einzelneZahl()) {
//                outcome.setText("gewonnen");
//            } else {
//                outcome.setText("verloren");
//            }
        //un/gerade Zahlen
//            modell.ugeradeZahl();
//            if (modell.ugeradeZahl()) {
//                outcome.setText("");
//                System.out.println("nee");
//            } else {
//                outcome.setText("");
//                System.out.println("hs");
//            }
//        }
    }

    /**
     * Verbindung mit Modell
     * @param event 
     */
    @FXML
    private void einsatzLöschen(ActionEvent event) {
//        modell.einsatzLöschen();
//        modell.setEinsatzt();
//        einsatzTotalID.setText(""+modell.getEinsatzT());
//        einsatzID.setText("0");
    }

    /**
     * Gibt der feldAuswahlID einen Value
     * @param event 
     */
    @FXML
    private void einsatzHinzufügen(ActionEvent event) {
        String ausgewähltesFeld = feldAuswahlID.getValue();
        modell.einsatzHinzufügen(ausgewähltesFeld);
        System.out.println(ausgewähltesFeld);
        modell.feldAuswählen(Enum.valueOf(Felder.class, feldAuswahlID.getValue()));
    }

    @FXML
    private void konto(MouseEvent event) throws SQLException {
        kontoStandID.setText(""+db.getKonto(name));
        nutzer.setText(name);
    }

}
