/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SicBo;

import Casino.DBController;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class SicBoSpielController implements Initializable {

    @FXML
    private AnchorPane pa;
    @FXML
    private Label totalBet;
    @FXML
    private Label totalWin;
    @FXML
    private Label Kontostand;
    @FXML
    private Button allt;
    @FXML
    private Button big;
    @FXML
    private Button d1;
    @FXML
    private Button d2;
    @FXML
    private Button d3;
    @FXML
    private Button d5;
    @FXML
    private Button d4;
    @FXML
    private Button d6;
    @FXML
    private Button t5;
    @FXML
    private Button t1;
    @FXML
    private Button t4;
    @FXML
    private Button t2;
    @FXML
    private Button t3;
    @FXML
    private Button t6;
    @FXML
    private Button small;
    @FXML
    private Button sum4;
    @FXML
    private Button sum5;
    @FXML
    private Button sum6;
    @FXML
    private Button sum7;
    @FXML
    private Button sum8;
    @FXML
    private Button sum9;
    @FXML
    private Button sum10;
    @FXML
    private Button sum11;
    @FXML
    private Button sum12;
    @FXML
    private Button sum13;
    @FXML
    private Button sum14;
    @FXML
    private Button sum15;
    @FXML
    private Button sum16;
    @FXML
    private Button sum17;
    @FXML
    private Button do12;
    @FXML
    private Button do13;
    @FXML
    private Button do14;
    @FXML
    private Button do15;
    @FXML
    private Button do16;
    @FXML
    private Button do23;
    @FXML
    private Button do24;
    @FXML
    private Button do25;
    @FXML
    private Button do26;
    @FXML
    private Button do34;
    @FXML
    private Button do35;
    @FXML
    private Button do36;
    @FXML
    private Button do45;
    @FXML
    private Button do46;
    @FXML
    private Button do56;
    @FXML
    private TextField betrag;
    @FXML
    Button wetten;
    @FXML
    private Button spielv;
    @FXML
    private Button wurfel1;
    @FXML
    private Button wurfel2;
    @FXML
    private Button wurfel3;
    @FXML
    private Button zuruck;
    @FXML
    private Label im1;
    @FXML
    private Label im2;
    @FXML
    private Label im3;
    @FXML
    private Label im4;
    @FXML
    private Label im5;
    @FXML
    private Label im6;
    @FXML
    private Label im7;
    @FXML
    private Label im8;
    @FXML
    private Label im9;
    @FXML
    private Label im10;
    @FXML
    private Label im11;
    @FXML
    private Label im12;
    @FXML
    private Label im13;
    @FXML
    private Label im14;
    @FXML
    private Label im15;
    @FXML
    private Label runde1;
    @FXML
    private Label runde2;
    @FXML
    private Label runde3;
    @FXML
    private Label runde4;
    @FXML
    private Label runde5;

    Croupier c = new Croupier();        //Croupier erzeugen, um es später zu benutzen                   
    SicBoModel m = new SicBoModel();    //SicBoModel erzeugen, um es später zu benutzen
    int anzahl;                         //Variable, die der eingesetzter Betrag speichert
    int a;                              //Würfel 1
    int b;                              //Würfel 2
    int d;                              //Würfel 3
    int click;                          //Anzahl Clicks
    DBController db = null;              //DBCOntroller erzeugen, um es zu verbinden
    static String name;                 //Statischer Nae^me erzeugen, der nicht geändert werden kann

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
        //Die Buttons der drei Würfel werden auf Disabled eingestellt
        wurfel1.setDisable(true);
        wurfel2.setDisable(true);
        wurfel3.setDisable(true);

        //Der Text der eingesetzer Betrag wird auf 0 gesetzt
        totalBet.setText("0");

        try {
            //Datenbankcontroller erstellen
            db = new DBController();
        } catch (SQLException ex) {
            //Fehler ausgeben falls der Controller nicht erzeugt werden konnte
            Logger.getLogger(SicBoSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Kontostand am Model weitergeben um weitere Berechnungen zu machen
        try {
            m.setKonto(db.getKonto(name));
        } catch (SQLException ex) {
            //Falls der Kontostand nicht weitergegeben werden kann, gibt eine Fehlermeldung zurück
            Logger.getLogger(SicBoSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Name des Spielers setzen um es im Model zu benutzen
    public void setName(String name) {
        SicBoSpielController.name = name;
    }

    //Für jede OnAction Methode der Buttons, die einen Betrag annehmen und die das folgendes Zeichen als Kommentar haben: "@@@"
    @FXML
    private void allt(ActionEvent event) {
        try {
            //Wenn der Button gedrückt ist wird der Eingesetzter Betrag gelesen
            anzahl = Integer.parseInt(betrag.getText().trim());

            //Der Betrah wird im Model weiter gegeben um den Button zu färben
            m.button(allt, anzahl);

            //Der Text der gesamten eingesetzter Betrag wird geändert zur aktuellen Stand
            totalBet.setText("" + m.total());

        } catch (NumberFormatException e) {
            //Wenn die Eingabe falsch ist gibt eine Fehlermeldung aus
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }
    }

    //@@@
    @FXML
    private void big(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(big, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }
    }

    //@@@
    @FXML
    private void d1(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(d1, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }
    }

    //@@@
    @FXML
    private void d2(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(d2, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }
    }

    //@@@
    @FXML
    private void d3(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(d3, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void d5(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(d5, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void d4(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(d4, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void d6(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(d6, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void t5(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(t5, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void t1(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(t1, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void t4(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(t4, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void t2(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(t2, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void t3(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(t3, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void t6(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(t6, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void small(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(small, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum4(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum4, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum5(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum5, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum6(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum6, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum7(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum7, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum8(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum8, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum9(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum9, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum10(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum10, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum11(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum11, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum12(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum12, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum13(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum13, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum14(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum14, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum15(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum15, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum16(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum16, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void sum17(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.buttonsumme(sum17, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do12(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do12, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do13(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do13, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do14(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do14, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do15(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do15, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do16(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do16, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do23(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do23, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do24(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do24, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do25(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do25, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do26(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do26, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do34(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do34, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do35(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do35, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do36(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do36, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do45(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do45, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do46(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do46, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    //@@@
    @FXML
    private void do56(ActionEvent event) {
        try {
            anzahl = Integer.parseInt(betrag.getText().trim());
            m.button(do56, anzahl);
            totalBet.setText("" + m.total());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

    }

    @FXML
    private void betrag(MouseEvent event) {
    }

    boolean disabled;       //Boolean wert, der einen True oder False speichert

    //In dieser Methode wird, die ganze Logik des Spiels gestartet mit den entsprechenden Zugriffen ans Model
    @FXML
    private void wetten(ActionEvent event) throws MalformedURLException, IOException, InterruptedException, SQLException {
        //Int wert, der die gewonnene Summe einspeichert
        int poi = 0;

        //Int wert, der das aktuelles Kontostand einspeichert
        int aktKonto;

        //String Wert, der der gesamter eingestzter Betrag einliest
        String gewettet = totalBet.getText();

        try {
            //Eingesetzter Betrag einlesen und als zahl konvertieren
            anzahl = Integer.parseInt(betrag.getText().trim());

            //Überprüft ob die Eingabe richtig ist oder nicht
            if (m.checkEingabe(gewettet, anzahl) == 0) {
                //Click +1 addieren
                click++;

                //Der Boolean disabled auf true setzen
                disabled = true;

                //Der Button auf Disabled setzen
                wetten.setDisable(true);

                //Random Werte erzeugen um die Würfel zu würfeln
                this.a = c.würfle();
                this.b = c.würfle();
                this.d = c.würfle();

                //Je nach der Anzahl der Clicks in der History die gewürfelten Images in den Labels einspeichern
                if (click % 5 == 1 || click == 1) {
                    c.history(a, b, d, im1, im2, im3);
                    runde1.setText("" + click);
                    runde1.setStyle("-fx-background-color: white; -fx-border-color: black;");
                }
                if (click % 5 == 2 || click == 2) {
                    c.history(a, b, d, im4, im5, im6);
                    runde2.setText("" + click);
                    runde2.setStyle("-fx-background-color: white; -fx-border-color: black;");
                }
                if (click % 5 == 3 || click == 3) {
                    c.history(a, b, d, im7, im8, im9);
                    runde3.setText("" + click);
                    runde3.setStyle("-fx-background-color: white; -fx-border-color: black;");
                }
                if (click % 5 == 4 || click == 4) {
                    c.history(a, b, d, im10, im11, im12);
                    runde4.setText("" + click);
                    runde4.setStyle("-fx-background-color: white; -fx-border-color: black;");
                }
                if (click % 5 == 0 || click == 5) {
                    c.history(a, b, d, im13, im14, im15);
                    runde5.setText("" + click);
                    runde5.setStyle("-fx-background-color: white; -fx-border-color: black;");
                }

                //Die Disabled Buttons auf false setzen, damit sie anclickbar sind
                wurfel1.setDisable(false);
                wurfel2.setDisable(false);
                wurfel3.setDisable(false);

                //Die Labels im Croupier mit Bilder, die von Randomzahlen bestimmt werden, befüllen
                wurfel1.setStyle("-fx-background-image: url(/styles/" + a + ".png); -fx-background-color: white; -fx-background-size: 50% 50%; -fx-background-repeat: no-repeat; -fx-background-position: center");
                wurfel2.setStyle("-fx-background-image: url(/styles/" + b + ".png); -fx-background-color: white; -fx-background-size: 50% 50%; -fx-background-repeat: no-repeat; -fx-background-position: center");
                wurfel3.setStyle("-fx-background-image: url(/styles/" + d + ".png); -fx-background-color: white; -fx-background-size: 50% 50%; -fx-background-repeat: no-repeat; -fx-background-position: center");

                //Überprüfen ob man etwas gewonnen hat
                poi = m.checkForWin(a, b, d);

                //Der gewonnen Betrag als Text setzen
                totalWin.setText("" + poi);
            }
        } catch (NumberFormatException e) {
            //Überprüfen ob die Eingabe richtig ist
            JOptionPane.showMessageDialog(null, "Sie müssen eine Zahl eingeben");
        }

        try {
            //Kontostand vom Spieler einlesen
            aktKonto = db.getKonto(name);

            //Kontostand aktualisieren
            int Konto = (poi - m.total()) + aktKonto;

            //Kontostand in der Datenbank aktualisieren
            db.updateKontoSicBo(Konto, name);

            //Kontostand in der View aktualisieren
            Kontostand.setText("" + Konto);

//            //Statistiken abgeben
//            db.stats(name, poi, m.total());
//            db.getDaten();
        } catch (NumberFormatException e) {

        }
    }

    //Wird der Button gedrückt geht man an der Übersichtsseite von SicBo zurück
    @FXML
    private void spielv(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SicBoMenu.fxml"));
        pa.getChildren().setAll(pane);
    }

    //Alles Zurücksetzen um ein neues Spiel anzufangen
    @FXML
    private void zuruck(ActionEvent event) {
        if (disabled == true) {
            wetten.setDisable(false);
        }
        m.reset(allt);
        m.reset(big);
        m.reset(small);
        m.reset(d1);
        m.reset(d2);
        m.reset(d3);
        m.reset(d4);
        m.reset(d5);
        m.reset(d6);
        m.reset(do12);
        m.reset(do13);
        m.reset(do14);
        m.reset(do15);
        m.reset(do16);
        m.reset(do23);
        m.reset(do24);
        m.reset(do25);
        m.reset(do26);
        m.reset(do34);
        m.reset(do35);
        m.reset(do36);
        m.reset(do45);
        m.reset(do46);
        m.reset(do56);
        m.resets(sum4);
        m.resets(sum5);
        m.resets(sum6);
        m.resets(sum7);
        m.resets(sum8);
        m.resets(sum9);
        m.resets(sum10);
        m.resets(sum11);
        m.resets(sum12);
        m.resets(sum13);
        m.resets(sum14);
        m.resets(sum15);
        m.resets(sum16);
        m.resets(sum17);
        m.reset(t1);
        m.reset(t2);
        m.reset(t3);
        m.reset(t4);
        m.reset(t5);
        m.reset(t6);
        wetten.setText("Wetten");
        totalBet.setText("0");
    }

    /**
     *
     * @param b
     */
    //Drückt man auf den Button werden die Spielregeln angezeigt
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

    //Beim Bewegen des Mouse wird der Kontostand aktualisiert
    @FXML
    private void Konto(MouseEvent event) throws SQLException {
        Kontostand.setText("" + db.getKonto(name));
    }
}
