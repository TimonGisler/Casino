/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.roulette;

import Casino.MainApp;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasse Modell
 *
 * @author ivanf
 */
public class Modell {

    /**
     * Variablendeklaration
     */
    final ArrayList<Integer> ersteSpalte = new ArrayList<>(Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34));
    final ArrayList<Integer> zweiteSpalte = new ArrayList<>(Arrays.asList(2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35));
    final ArrayList<Integer> dritteSpalte = new ArrayList<>(Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36));

    MainApp mainapp;
    private int einsatz = 0;
    private int einsatzTotal;
    private int kontoStand;
    PropertyChangeSupport changes = new PropertyChangeSupport(this);

    int zahl;
    Random rnd = new Random();
    Farben farbe;

    String ausgewähltesFeld;
    Felder ausgewählt;

    private final Map<Felder, Integer> feldEinsatz = new HashMap<>();

    /**
     * Konstruktor für das Modell
     *
     * @param mainapp
     */
    public Modell(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    Modell() {
        
    }

    /**
     * Methode erhöht den Einsatz um 10 für das jeweilige Feld
     * @return 
     */
    public int zehnerAction() {
        if (feldEinsatz.containsKey(ausgewählt)) {
            int alterEinsatz = einsatz;
            einsatz = (int) feldEinsatz.get(ausgewählt);
            einsatz += 10;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
            System.out.println("Feld existiert");
        } else {
            int alterEinsatz = einsatz;
            einsatz += 10;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
            System.out.println("Feld existiert niicht");
        }
        einsatzTotalRechner();
        return einsatz;
    }

    /**
     * Methode erhöht den Einsatz um 20 für das jeweilige Feld
     * @return 
     */
    public int zwanzigerAction() {
        if (feldEinsatz.containsKey(ausgewählt)) {
            int alterEinsatz = einsatz;
            einsatz = (int) feldEinsatz.get(ausgewählt);
            einsatz += 20;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        } else {
            int alterEinsatz = einsatz;
            einsatz += 20;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        }
        einsatzTotalRechner();
        return einsatz;
    }

    /**
     * Methode erhöht den Einsatz um 50 für das jeweilige Feld
     * @return 
     */
    public int fünfzigerAction() {
        if (feldEinsatz.containsKey(ausgewählt)) {
            int alterEinsatz = einsatz;
            einsatz = (int) feldEinsatz.get(ausgewählt);
            einsatz += 50;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        } else {
            int alterEinsatz = einsatz;
            einsatz += 50;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        }
        einsatzTotalRechner();
        return einsatz;
    }

    /**
     * Methode erhöht den Einsatz um 100 für das jeweilige Feld
     * @return 
     */
    public int hunderterAction() {
        if (feldEinsatz.containsKey(ausgewählt)) {
            int alterEinsatz = einsatz;
            einsatz = (int) feldEinsatz.get(ausgewählt);
            einsatz += 100;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        } else {
            int alterEinsatz = einsatz;
            einsatz += 100;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        }
        einsatzTotalRechner();
        return einsatz;
    }

    /**
     * Methode erhöht den Einsatz um 500 für das jeweilige Feld
     */
    public int fünfhunderterAction() {
        if (feldEinsatz.containsKey(ausgewählt)) {
            int alterEinsatz = einsatz;
            einsatz = (int) feldEinsatz.get(ausgewählt);
            einsatz += 500;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        } else {
            int alterEinsatz = einsatz;
            einsatz += 500;
            changes.firePropertyChange("Einsatz", alterEinsatz, einsatz);

            feldEinsatz.put(ausgewählt, einsatz);
        }
        einsatzTotalRechner();
        return einsatz;
    }

    /**
     * Methode die PropertyChangeListener hinzufügt
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    /**
     * Methode die mit dem Button "Drehen" eine Randozahl generiert und weist
     * der Zahl die Farbe an
     */
    public void drehenAction() {
        einsatzTotal = 0;
        einsatz = 0;
        //Zufällige Zahl wird generiert
        int alteZahl = zahl;

        Random rnd = new Random();
        zahl = rnd.nextInt(37);
        changes.firePropertyChange("Zahl", alteZahl, zahl);

        //Hier wird der Zahl die Farbe zugewiesen
        if (zahl == 0) {
            Farben alteFarbe = farbe;
            farbe = Farben.Grün;
            changes.firePropertyChange("Farbe", alteFarbe, farbe);
        } else if (2 == zahl
                || 4 == zahl
                || 6 == zahl
                || 8 == zahl
                || 10 == zahl
                || 11 == zahl
                || 13 == zahl
                || 15 == zahl
                || 17 == zahl
                || 20 == zahl
                || 22 == zahl
                || 24 == zahl
                || 26 == zahl
                || 28 == zahl
                || 29 == zahl
                || 31 == zahl
                || 33 == zahl
                || 35 == zahl) {
            Farben alteFarbe = farbe;
            farbe = Farben.Schwarz;
            changes.firePropertyChange("Farbe", alteFarbe, farbe);
        } else {
            Farben alteFarbe = farbe;
            farbe = Farben.Rot;
            changes.firePropertyChange("Farbe", alteFarbe, farbe);
        }
    }
    
    public Farben getFarbe()
    {
        return farbe;
    }
    
    public int getZahl()
    {
        return zahl;
    }

    /**
     * Methode welche das Feld auswählt, Anfangseinsatz von einem Feld setzten
     *
     * @param feld
     */
    public void feldAuswählen(Felder feld) {
        if (feldEinsatz.containsKey(feld) && feldEinsatz.get(feld) >= 0) {
            int alterFeldEinsatz = 20;
            einsatz = feldEinsatz.get(feld);
            changes.firePropertyChange("Einsatz", alterFeldEinsatz, einsatz);
            this.ausgewählt = feld;
        } else {
            int alterFeldEinsatz = 20;
            einsatz = 0;
            changes.firePropertyChange("Einsatz", alterFeldEinsatz, einsatz);
            this.ausgewählt = feld;
        }
    }

    /**
     * Methode um dem ausgewählten Feld später einen Einsatz zu geben
     *
     * @param ausgewähltesFeld
     */
    public void einsatzHinzufügen(String ausgewähltesFeld) {
        String alteAusgewähltesFeld = this.ausgewähltesFeld;
        this.ausgewähltesFeld = ausgewähltesFeld;
        changes.firePropertyChange("Ausgewähltes Feld", alteAusgewähltesFeld, ausgewähltesFeld);
    }

    /**
     * Methode die Totaleinsatz auswertet
     */
    public void einsatzTotalRechner() {
        int alterEinsatzTotal = einsatzTotal;
        einsatzTotal = 0;
        for (Map.Entry<Felder, Integer> paar : feldEinsatz.entrySet()) {
            einsatzTotal += paar.getValue();
        }
        changes.firePropertyChange("Einsatz Total", alterEinsatzTotal, einsatzTotal);
    }

    public int getEinsatzT()
    {
        return einsatzTotal;
    }
    
    public void setEinsatzt()
    {
        for (Map.Entry<Felder, Integer> paar : feldEinsatz.entrySet()) {
            einsatzTotal -= paar.getValue();
        }
    }
    /**
     * Startet das Spiel, wechselt die Ansicht
     */
//    public void startenAction() {
//        try {
//            mainapp.wechsleFenster(mainapp.getTemp(), "/fxml/Spielseite.fxml", "Spielseite");
//        } catch (Exception ex) {
//            Logger.getLogger(Modell.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    /**
     * Methode die Schwarz und Rot mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean farb_gewonnen() {
        System.out.println(farbe);
        if (ausgewähltesFeld.equals(farbe.toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die einzelne Zahl mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean einzelneZahl() {
        String vergleich = "Feld_" + Integer.toString(zahl);
        if (vergleich.equals(ausgewähltesFeld)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die schaut ob die Zahl gerade oder ungerade ist
     *
     * @return
     */
    public boolean istGenerierteNummerGerade() {
        boolean r = false;

        if (zahl % 2 == 0) {
            r = true;
        }

        return r;
    }

    /**
     * Methode die gerade und ungerade Zahl mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean checkGeradeUngeradeGewonnen() {
        if (ausgewähltesFeld.equals("Gerade") && istGenerierteNummerGerade()) {
            return true;
        } else if (ausgewähltesFeld.equals("Ungerade") && !istGenerierteNummerGerade()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die niedrig und hoch Zahl mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean istNiedrig() {
        if (zahl == 0) {
            return false;
        } else if (zahl <= 18) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die das erste Dutzend mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean erstesDutzend() {
        if (zahl == 0) {
            return false;
        } else if (zahl <= 12) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die das zweite Dutzend mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean zweitesDutzend() {
        if (zahl == 0) {
            return false;
        } else if (zahl > 12 && zahl <= 24) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die das dritte Dutzend mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean drittesDutzend() {
        if (zahl == 0) {
            return false;
        } else if (zahl > 24) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die die erste Spalte mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean ersteSpalte() {
        if (ersteSpalte.contains(zahl)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die die zweite Spalte mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean zweiteSpalte() {
        if (zweiteSpalte.contains(zahl)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode die die dritte Spalte mit dem ausgewählten Feld vergleicht
     *
     * @return
     */
    public boolean dritteSpalte() {
        if (dritteSpalte.contains(zahl)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returned das ausgewählte Feld
     * @return 
     */
    public String getAusgewähltesFeld() {
        return ausgewähltesFeld;
    }

    /**
     * Methode die den Einsatz löscht
     * @return 
     */
    public void einsatzLöschen() {
        changes.firePropertyChange("Einsatz", null, 0);
    }

}
