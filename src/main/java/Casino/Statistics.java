/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author micha
 */
public class Statistics {

    private SimpleStringProperty name;
    private SimpleIntegerProperty verloren;
    private SimpleIntegerProperty gewonnen;
    private SimpleIntegerProperty einsatz;

    public Statistics(SimpleStringProperty name, SimpleIntegerProperty verloren, SimpleIntegerProperty gewonnen, SimpleIntegerProperty einsatz) {
        this.name = name;
        this.verloren = verloren;
        this.gewonnen = gewonnen;
        this.einsatz = einsatz;
    }

    public SimpleStringProperty getName() {
        return name;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public SimpleIntegerProperty getVerloren() {
        return verloren;
    }

    public void setVerloren(SimpleIntegerProperty verloren) {
        this.verloren = verloren;
    }

    public SimpleIntegerProperty getGewonnen() {
        return gewonnen;
    }

    public void setGewonnen(SimpleIntegerProperty gewonnen) {
        this.gewonnen = gewonnen;
    }

    public SimpleIntegerProperty getEinsatz() {
        return einsatz;
    }

    public void setEinsatz(SimpleIntegerProperty einsatz) {
        this.einsatz = einsatz;
    }

}
