/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SicBo;

import java.net.MalformedURLException;
import java.util.Random;
import javafx.scene.control.Label;

/**
 *
 * @author micha
 */
public class Croupier {

    int würfel1;

    //Eine Random Zahl wird generiert und herausgegeben
    public int würfle() throws MalformedURLException {
        //Zahl generieren und einer Variable zugeben
        Random zufall = new Random();
        this.würfel1 = zufall.nextInt(6) + 1;

        //Generierte Zahl
        return würfel1;
    }

    //Spiel History erstellt
    //History nimmt 3 Zahlen an und 3 Label an
    public void history(int w1, int w2, int w3, Label l1, Label l2, Label l3) {
        //Label mit Bilder füllen, die von den gegebenen Zahlen bestimmt werden
        l1.setStyle("-fx-background-image: url(/styles/" + w1 + ".png); -fx-background-color: white; -fx-background-size: 50% 50%; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-border-color: black;");
        l2.setStyle("-fx-background-image: url(/styles/" + w2 + ".png); -fx-background-color: white; -fx-background-size: 50% 50%; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-border-color: black;");
        l3.setStyle("-fx-background-image: url(/styles/" + w3 + ".png); -fx-background-color: white; -fx-background-size: 50% 50%; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-border-color: black;");
    }
}
