/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SicBo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javax.swing.JOptionPane;

/**
 *
 * @author micha
 */
public class SicBoModel {

    int all;            //Variable, die den gesamten eingesetzten Betrag berechnet
    static int konto;   //Varibale, die den aktuellen Kontostand speichert

    HashMap<String, Integer> hm = new HashMap<>();      //Hashmap erzeugt, die einen String und einen Integer speichert
    HashMap<String, Boolean> win = new HashMap<>();     //Hashmap erzeugt, die einen String und einen Boolean speichert
    HashMap<String, Button> btn = new HashMap<>();      //Hashmap erzeugt, die einen String und einen Button speichert

    //Methode, die einen Button und einen Int einliest
    public void button(Button b, int betrag) {
        //Style von Button b bekommen
        String o = b.getStyle();

        //String erzeugen, die mit dem Button vergleicht wird
        String p = "-fx-background-color: blue";

        //String erzeugen, die mit dem Button vergleicht wird
        String green = "-fx-background-color: rgb(0, 254, 0)";

        //ID vom Button bekommen um es später anzuwenden
        String button = b.getId();

        //Style von Button mit zwei Strings vergleichen um zu sehen ob der Hintergrund gefärbt wurde oder nicht
        if (o != p & o != green) {
            //Ist der Hintergrund weiss dann werden die folgende Befehle geführt
            //In der Hashmap den Button und den Int(Betrag) speichern
            hm.put(button, betrag);

            //Kontostand wird mit dem eingesetzten Betrag vergleicht, um zu sehen ob es zu gross ist
            if (konto < (all + hm.get(button))) {
                //Ist der Kontostand kleiner als der eingesetzten Betrag, wird eine Fehlermeldung herausgegeben und den Button von der Hashmap gelöscht
                JOptionPane.showMessageDialog(null, "Sie können nicht einen höheren Betrag als Ihr Kontostand setzen.");
                hm.remove(button, betrag);
            } else {
                //Ist der eingesetzten Betrag kleiner als der Kontostand wird der Button blau gefärbt
                b.setStyle("-fx-background-color: blue");

                //In den Hashmaps die Buttons und der Betrag einspeichern
                win.put(button, true);
                btn.put(button, b);

                //Der Betrag von der Hashmap wird zur gesamter eingesetzter Betrag addiert
                all += hm.get(button);
            }
        } else {
            //Ist der Hintergrund nicht weiss, dann wird er weiss gefärbt
            b.setStyle("-fx-background-color: white");

            //In der Heshmap wird der Boolean wert zu false gesetzt
            win.replace(button, false);

            //Der Betrag von der Hashmap wird zur gesamter eingesetzter Betrag subtrahiert
            all -= hm.get(button);

            //In der Hashmaps wird der Button gelöscht
            hm.remove(button, betrag);
            btn.remove(button, b);
        }
    }

    //Hier unten wird genau das gleiche wie in der Methode "button herausgeführt", das einzige ist dass es für die Button der Summe ist, die anders gefärbt werden müssen
    public void buttonsumme(Button b, int betrag) {
        String o = b.getStyle();
        String p = "-fx-background-color: blue";
        String green = "-fx-background-color: rgb(0, 254, 0)";
        String button = b.getId();

        if (o != p & o != green) {
            hm.put(button, betrag);
            if (konto < (all + hm.get(button))) {
                JOptionPane.showMessageDialog(null, "Sie können nicht einen höheren Betrag als Ihr Kontostand setzen.");
                hm.remove(button, betrag);
            } else {
                b.setStyle("-fx-background-color: blue");
                hm.put(button, betrag);
                win.put(button, true);
                btn.put(button, b);
                all += hm.get(button);
            }

        } else {
            b.setStyle("-fx-background-color: rgb(204, 0, 0)");
            win.replace(button, false);
            all -= hm.get(button);
            btn.remove(button, b);
        }
    }

    //In dieser Methode wird der gesamten eingesetzter Betrag herausgegeben
    public int total() {
        return all;
    }

    //In dieser wird ein Image erzeugt mit einem gegebenen Int, der für die History nötig ist.
    public Image history(int a) {
        //Style Befehl erzeugen
        String wurfel1 = "styles/" + a + ".png";

        //Befehl in der Erzeugung eines Bildes befehlen
        Image image = new Image(wurfel1);

        //Bild zurückgeben
        return image;
    }

    //In dieser Methode wird geprüft ob der Spieler gewonnen hat bzw. wie viel er gewonnen hat
    public int checkForWin(int a, int b, int e) {

        //Variable, die die gewonnene Summe einspeichert
        int aus = 0;

        //Hier wird geprüft ob der Spieler einen Small gewonnen hat
        //Alle Würfel zusammenzählen und schauen ob die Summe zwischen 4 und 10 liegt
        if ((a + b + e) <= 10 && (a + b + e) >= 4) {
            try {

                //Falls der Wert Small in der Hashmap drinliegt hat der Spieler der eingesetzten Betrag *1 gewonnen und der Button wird Grün gefärbt mit der Methode "farbe(String)"
                if (win.get("small") == true) {
                    aus += hm.get("small") * 1;
                    farbe("small");
                }
            } catch (Exception er) {
            }
        }

        //Hier wird geprüft ob der Spieler einen Big gewonnen hat
        //Alle Würfel zusammenzählen und schauen ob die Summe zwischen 11 und 17 liegt
        if ((a + b + e) <= 17 && (a + b + e) >= 11) {
            try {

                //Falls der Wert Big in der Hashmap drinliegt hat der Spieler der eingesetzten Betrag *1 gewonnen und der Button wird Grün gefärbt mit der Methode "farbe(String)"
                if (win.get("big") == true) {
                    aus += hm.get("big") * 1;
                    farbe("big");
                }
            } catch (Exception er) {
            }
        }

        //Hier wird geprüft, ob ein Spieler einen Double oder einen Triple gewonnen hat
        //Überprüfen ob ein Double vorliegt
        if (a == b || a == e || b == e) {
            //Überprüfen ob ein Triple vorliegt
            if (a == b & a == e) {
                try {

                    //Falls ein Triple in der Hashmap gespeichert wurde gewinnt der Spieler der eingesetzten Betrag *192, und der Button wird Grün gefärbt mit der Methode "farbe(String)"
                    if (win.get("t" + e)) {
                        aus += hm.get("t" + e) * 192;
                        farbe("t" + e);
                    }

                    //Falls alle Triples in der Hashmap gespeichert wurde gewinnt der Spieler der eingesetzten Betrag *33, und der Button wird Grün gefärbt mit der Methode "farbe(String)"
                    if (win.get("allt")) {
                        aus += hm.get("allt") * 33;
                        farbe("allt");
                    }
                } catch (Exception re) {
                }
            }
            try {

                //Falls kein Triple vorliegt überprüfe ob der Button Double in der Hashmao gespeichert wurde
                //Ist der Button in der Hashmap gewinnt der Spieler der eingesetzte Betrag *11 und der Button wird Grün gefärbt mit der Methode "farbe(String)"
                if (win.get("d" + e)) {
                    aus += hm.get("d" + e) * 11;
                    farbe("d" + e);
                } else if (win.get("d" + a)) {
                    aus += hm.get("d" + a) * 11;
                    farbe("d" + a);
                } else if (win.get("d" + b)) {
                    aus += hm.get("d" + b) * 11;
                    farbe("d" + b);
                }
            } catch (Exception re) {
            }
        }

        List<String> arr = new ArrayList<>();       //Ararylist erzeugt, die String einnimmt
        arr.add("" + a);                              //Der Würfelzahl 1 in der ArrayList speichern
        arr.add("" + b);                              //Der Würfelzahl 2 in der ArrayList speichern
        arr.add("" + e);                              //Der Würfelzahl 3 in der ArrayList speichern
        Collections.sort(arr);                      //ArrayList nach Grösse sortieren

        try {

            //Überprüfen ob eine Domino Kombination vorliegt
            //Falls der Button der Domino Kombination in der Hashmap gespeichert wurde gewinnt der Spieler der eingesetzer Betrag *6 und der Button wird Grün gefärbt mit der Methode "farbe(String)"
            //Es müssen alle möglichen Kombinationen geprüft werden
            if (win.get("" + arr.get(0) + "" + arr.get(1))) {
                aus += hm.get("" + arr.get(0) + "" + arr.get(1)) * 6;
                farbe("" + arr.get(0) + "" + arr.get(1));
            }
        } catch (Exception re) {
        }

        try {
            if (win.get("" + arr.get(0) + "" + arr.get(2))) {
                aus += hm.get("" + arr.get(0) + "" + arr.get(2)) * 6;
                farbe("" + arr.get(0) + "" + arr.get(2));
            }
        } catch (Exception re) {
        }

        try {
            if (win.get("" + arr.get(1) + "" + arr.get(2))) {
                aus += hm.get("" + arr.get(1) + "" + arr.get(2)) * 6;
                farbe("" + arr.get(1) + "" + arr.get(2));
            }
        } catch (Exception re) {
        }

        //Variable um die Summe zu überprüfen, alle Würfelzahlen werden zusammengezählt
        int summe = a + b + e;

        //Falls der Button der Summe in der Hashmap gespeichert wurde, gewinnt der Spieler der eingesetzter Betrag mal den bestimmten Faktor, und der Button wird Grün gefärbt mit der Methode "farbe(String)"
        //Für jede bestimmte Summe gibt es einen Multiplikationsfaktor
        try {
            if (win.get("sum" + summe)) {
                if (summe == 4) {
                    aus = hm.get("sum" + summe) * 65;
                    farbe("sum" + summe);
                }
                if (summe == 5) {
                    aus = hm.get("sum" + summe) * 33;
                    farbe("sum" + summe);
                }
                if (summe == 6) {
                    aus = hm.get("sum" + summe) * 19;
                    farbe("sum" + summe);
                }
                if (summe == 7) {
                    aus = hm.get("sum" + summe) * 12;
                    farbe("sum" + summe);
                }
                if (summe == 8) {
                    aus = hm.get("sum" + summe) * 8;
                    farbe("sum" + summe);
                }
                if (summe == 9) {
                    aus = hm.get("sum" + summe) * 7;
                    farbe("sum" + summe);
                }
                if (summe == 10) {
                    aus = hm.get("sum" + summe) * 6;
                    farbe("sum" + summe);
                }
                if (summe == 11) {
                    aus = hm.get("sum" + summe) * 6;
                    farbe("sum" + summe);
                }
                if (summe == 12) {
                    aus = hm.get("sum" + summe) * 7;
                    farbe("sum" + summe);
                }
                if (summe == 13) {
                    aus = hm.get("sum" + summe) * 8;
                    farbe("sum" + summe);
                }
                if (summe == 14) {
                    aus = hm.get("sum" + summe) * 12;
                    farbe("sum" + summe);
                }
                if (summe == 15) {
                    aus = hm.get("sum" + summe) * 19;
                    farbe("sum" + summe);
                }
                if (summe == 16) {
                    aus = hm.get("sum" + summe) * 33;
                    farbe("sum" + summe);
                }
                if (summe == 17) {
                    aus = hm.get("sum" + summe) * 65;
                    farbe("sum" + summe);
                }
            }
        } catch (Exception re) {
        }

        //Die gesamt gewonnene Summe herausgeben
        return aus;
    }

    //Wenn der Button b gedrückt wird
    public void reset(Button b) {
        //Alle Hashmaps entleeren
        hm.clear();
        win.clear();
        btn.clear();
        //Die gesamte eingestzte Summe auf 0 setzen
        all = 0;
        //Der Button weiss färben
        b.setStyle("-fx-background-color: white");
    }

    //Wie die Methode reset, aber für die Buttons der Summen, da diese anders gefärbt werden müssen
    public void resets(Button b) {
        hm.clear();
        win.clear();
        btn.clear();
        all = 0;
        b.setStyle("-fx-background-color: rgb(204, 0, 0)");
    }

    //Hier wird geprüft ob die Eingabe richitg ist oder nicht
    //Die Methode nimmt die Eingabe ein und der Betrag der eingesetzt wurde
    public int checkEingabe(String e, int be) {
        //Falls die Eingabe null ist oder der eingesetzter Betrag 0 beträgt, gibt eine Fehlermeldung aus und gibt 1 zurück
        if (e.equals("0") || be == 0) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine grössere Zahl als null eingeben bzw. Sie müssen einen Betrag einsetzen");
            return 1;
        } //Falls die Eingabe Stimmt, gibt 0 zurück
        else {
            return 0;
        }

    }

    //Mit dieser Methode wird einen Button gefärbt
    public void farbe(String a) {
        try {
            //Button in der Hashmap suchen mit dem enstsrpechenden ID, der eingenommen wurde
            Button b = btn.get(a);

            //Button b grün färben
            b.setStyle("-fx-background-color: rgb(0, 254, 0)");
        } catch (Exception er) {
        }
    }

    //Kontostand der Spieler herauslesen
    public void setKonto(int konto) {
        SicBoModel.konto = konto;
    }

}
