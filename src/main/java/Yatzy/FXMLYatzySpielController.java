/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Yatzy;

import Casino.DBController;
import Casino.EinlogController;
import static Yatzy.FXMLUebersichtYatzyController.name;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author niels
 */
public class FXMLYatzySpielController implements Initializable {

    private boolean zugSpieler = true;
    private boolean zugComp;
    @FXML
    private Label userEiner;
    private int pointEiner;
    private int iEiner = 1;
    @FXML
    private Label userZweier;
    private int pointZweier;
    private int iZweier = 1;
    @FXML
    private Label userDreier;
    private int pointDreier;
    private int iDreier = 1;
    @FXML
    private Label userVierer;
    private int pointVierer;
    private int iVierer = 1;
    @FXML
    private Label userFunfer;
    private int pointFunfer;
    private int iFunfer = 1;
    @FXML
    private Label userSechser;
    private int pointSechser;
    private int iSechser = 1;
    @FXML
    private Label userDreierPasch;
    private int pointDreierPasch;
    private int iDreierPasch = 1;
    @FXML
    private Label userViererPasch;
    private int pointViererPasch;
    private int iViererPasch = 1;
    @FXML
    private Label userFullHouse;
    private int pointFullHouse;
    private int iFullHouse = 1;
    @FXML
    private Label userkStrasse;
    private int pointkStrasse;
    private int ikStrasse = 1;
    @FXML
    private Label usergStrasse;
    private int pointgStrasse;
    private int igStrasse = 1;
    @FXML
    private Label userYatzy;
    private int pointYatzy;
    private int iYatzy = 1;
    @FXML
    private Label userChance;
    private int pointChance;
    private int iChance = 1;
    @FXML
    private Label userSubTotal;
    private int pointSubTotal;
    private int iSubTotal = 1;
    @FXML
    private Label userBonus;
    private int pointBonus;
    @FXML
    private Label userTotal;
    private int pointTotal;
    private int iTotal = 1;

    @FXML
    private Label verbleibendeWurfel;
    @FXML
    private Button würfel1;
    private int wurf1;
    private boolean hold1 = false;
    private boolean gedruckt1 = false;
    @FXML
    private Button würfel2;
    private int wurf2;
    private boolean hold2 = false;
    private boolean gedruckt2 = false;
    @FXML
    private Button würfel3;
    private int wurf3;
    private boolean hold3 = false;
    private boolean gedruckt3 = false;
    @FXML
    private Button würfel4;
    private int wurf4;
    private boolean hold4 = false;
    private boolean gedruckt4 = false;
    @FXML
    private Button würfel5;
    private int wurf5;
    private boolean hold5 = false;
    private boolean gedruckt5 = false;
    private int anzahlWurfe = 3;

    @FXML
    private Button btnAbbrechen;

    @FXML
    private Label compEiner;
    private int compPointEiner;
    private int icompEiner = 1;
    @FXML
    private Label compZweier;
    private int compPointZweier;
    private int icompZweier = 1;
    @FXML
    private Label compDreier;
    private int compPointDreier;
    private int icompDreier = 1;
    @FXML
    private Label compVierer;
    private int compPointVierer;
    private int icompVierer = 1;
    @FXML
    private Label compFuenfer;
    private int compPointFuenfer;
    private int icompFuenfer = 1;
    @FXML
    private Label compSechser;
    private int compPointSechser;
    private int icompSechser = 1;
    @FXML
    private Label compDreierPasch;
    private int compPointDreierPasch;
    private int icompDreierPasch = 1;
    @FXML
    private Label compViererPasch;
    private int compPointViererPasch;
    private int icompViererPasch = 1;
    @FXML
    private Label compFullHouse;
    private int compPointFullHouse;
    private int icompFullHouse = 1;
    @FXML
    private Label compkStrasse;
    private int compPointkStrasse;
    private int icompkStrasse = 1;
    @FXML
    private Label compgStrasse;
    private int compPointgStrasse;
    private int icompgStrasse = 1;
    @FXML
    private Label compYatzy;
    private int compPointYatzy;
    private int icompYatzy = 1;
    @FXML
    private Label compChance;
    private int compPointChance;
    private int icompChance = 1;
    @FXML
    private Label compBonus;
    private int compPointBonus;
    @FXML
    private Label compSubTotal;
    private int compPointSubTotal;
    private int icompSubTotal = 1;
    @FXML
    private Label compTotal;
    private int compPointTotal;
    private int icompTotal = 1;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button btnuserVierer;
    @FXML
    private Button btnuserYatzy;
    @FXML
    private Button btnusergStrasse;
    @FXML
    private Button btnuserFullHouse;
    @FXML
    private Button btnuserkStrasse;
    @FXML
    private Button btnuserEiner;
    @FXML
    private Button btnuserDreier;
    @FXML
    private Button btnuserSechser;
    @FXML
    private Button btnuserZweier;
    @FXML
    private Button btnuserViererPasch;
    @FXML
    private Button btnuserChance;
    @FXML
    private Button btnuserDreierPasch;
    @FXML
    private Button btnuserFuenfer;

    @FXML
    private Label lblkontostand;
    int kontostand;
    @FXML
    private TextField txtbetrag;
    @FXML
    private Label lblBetrag;
    private int betrag = 0;

    static String name;
    DBController d = null;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pane.setStyle("-fx-background-image: url(/styles/ruleBackground.png); -fx-background-size: 100% 130%");
        lblBetrag.setText("Betrag:");
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
        FXMLYatzySpielController.name = name;
    }

    @FXML
    private void Konto(MouseEvent event) throws SQLException {
        kontostand = d.getKonto(name);
        lblkontostand.setText("Kontostand: " + kontostand);
    }

    @FXML
    private void actionsetBetrag(ActionEvent event) throws SQLException {
        String inputbetrag = txtbetrag.getText();
        betrag = Integer.parseInt(inputbetrag);
        if (betrag <= kontostand && betrag > 0) {
            txtbetrag.setVisible(false);
            kontostand = kontostand - betrag;
            d.updateKontoYatzy(kontostand, name);
            lblkontostand.setText("Kontostand: " + kontostand);
            lblBetrag.setText("Betrag: " + inputbetrag);
        }
        else{
            JOptionPane.showMessageDialog(null, "Dieser Betrag ist ungültig, bitte wählen Sie einen Betrag der grösser als 0 und kleiner oder gleichgross wie Ihr Kontostand ist.", "Betrag", JOptionPane.PLAIN_MESSAGE);
        }

    }

    @FXML
    private void actionAbbrechen(ActionEvent event) {
        //Spiel abbrechen
        try {
            AnchorPane panen = FXMLLoader.load(getClass().getResource("/fxml/FXMLUebersichtYatzy.fxml"));
            pane.getChildren().setAll(panen);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    //Methode Würfeln --> generiert 5 random Zahlen und stellt Würfel als Bilder dar.
    private void roll() {
        if (anzahlWurfe > 0) {
            anzahlWurfe--;
            verbleibendeWurfel.setText("Verbleibende Würfe: " + anzahlWurfe);
            int SIDES = 6;
            if (hold1 == false) {
                wurf1 = (int) (Math.random() * SIDES) + 1;
                switch (wurf1) {
                    case 1:
                        würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                        break;
                    case 2:
                        würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                        break;
                    case 3:
                        würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                        break;
                    case 4:
                        würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                        break;
                    case 5:
                        würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                        break;
                    case 6:
                        würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                        break;
                    default:
                        break;
                }
            }
            if (hold2 == false) {
                wurf2 = (int) (Math.random() * SIDES) + 1;
                switch (wurf2) {
                    case 1:
                        würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                        break;
                    case 2:
                        würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                        break;
                    case 3:
                        würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                        break;
                    case 4:
                        würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                        break;
                    case 5:
                        würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                        break;
                    case 6:
                        würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                        break;
                    default:
                        break;
                }
            }
            if (hold3 == false) {
                wurf3 = (int) (Math.random() * SIDES) + 1;
                switch (wurf3) {
                    case 1:
                        würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                        break;
                    case 2:
                        würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                        break;
                    case 3:
                        würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                        break;
                    case 4:
                        würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                        break;
                    case 5:
                        würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                        break;
                    case 6:
                        würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                        break;
                    default:
                        break;
                }
            }
            if (hold4 == false) {
                wurf4 = (int) (Math.random() * SIDES) + 1;
                switch (wurf4) {
                    case 1:
                        würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                        break;
                    case 2:
                        würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                        break;
                    case 3:
                        würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                        break;
                    case 4:
                        würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                        break;
                    case 5:
                        würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                        break;
                    case 6:
                        würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                        break;
                    default:
                        break;
                }
            }
            if (hold5 == false) {
                wurf5 = (int) (Math.random() * SIDES) + 1;
                switch (wurf5) {
                    case 1:
                        würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                        break;
                    case 2:
                        würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                        break;
                    case 3:
                        würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                        break;
                    case 4:
                        würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                        break;
                    case 5:
                        würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                        break;
                    case 6:
                        würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                        break;
                    default:
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Sie haben bereits 3 mal gewürfelt, wählen Sie eine Figur aus.", "Würfeln", JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    //Button zum Würfeln ruft Methode roll auf
    private void actionRoll(ActionEvent event) {
        if (zugSpieler == true) {
            roll();
        }

    }

    //Methode um Würfel1 zu markieren
    private void hold1() {
        if (gedruckt1 == false) {
            hold1 = true;
            gedruckt1 = true;
            switch (wurf1) {
                case 1:
                    würfel1.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel1.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel1.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel1.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel1.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel1.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        } else if (gedruckt1 == true) {
            hold1 = false;
            gedruckt1 = false;
            switch (wurf1) {
                case 1:
                    würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel1.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    //Button um Würfel1 zu markieren --> ruft methode hold1 auf
    private void actionhold1(ActionEvent event) {
        hold1();
    }

    //Methode um Würfel2 zu markieren
    private void hold2() {
        if (gedruckt2 == false) {
            hold2 = true;
            gedruckt2 = true;
            switch (wurf2) {
                case 1:
                    würfel2.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel2.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel2.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel2.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel2.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel2.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        } else if (gedruckt2 == true) {
            hold2 = false;
            gedruckt2 = false;
            switch (wurf2) {
                case 1:
                    würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel2.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    //Button um Würfel2 zu markieren --> ruft methode hold1 auf
    private void actionhold2(ActionEvent event) {
        hold2();
    }

    //Methode um Würfel3 zu markieren
    private void hold3() {
        if (gedruckt3 == false) {
            hold3 = true;
            gedruckt3 = true;
            switch (wurf3) {
                case 1:
                    würfel3.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel3.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel3.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel3.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel3.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel3.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        } else if (gedruckt3 == true) {
            hold3 = false;
            gedruckt3 = false;
            switch (wurf3) {
                case 1:
                    würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel3.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    //Button um Würfel3 zu markieren --> ruft methode hold1 auf
    private void actionhold3(ActionEvent event) {
        hold3();
    }

    //Methode um Würfel4 zu markieren
    private void hold4() {
        if (gedruckt4 == false) {
            hold4 = true;
            gedruckt4 = true;
            switch (wurf4) {
                case 1:
                    würfel4.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel4.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel4.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel4.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel4.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel4.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        } else if (gedruckt4 == true) {
            hold4 = false;
            gedruckt4 = false;
            switch (wurf4) {
                case 1:
                    würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel4.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    //Button um Würfel4 zu markieren --> ruft methode hold1 auf
    private void actionhold4(ActionEvent event) {
        hold4();
    }

    //Methode um Würfel5 zu markieren
    private void hold5() {
        if (gedruckt5 == false) {
            hold5 = true;
            gedruckt5 = true;
            switch (wurf5) {
                case 1:
                    würfel5.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel5.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel5.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel5.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel5.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel5.setStyle("-fx-border-color: yellow;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        } else if (gedruckt5 == true) {
            hold5 = false;
            gedruckt5 = false;
            switch (wurf5) {
                case 1:
                    würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel1.png);-fx-background-position: center");
                    break;
                case 2:
                    würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel2.png);-fx-background-position: center");
                    break;
                case 3:
                    würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel3.png);-fx-background-position: center");
                    break;
                case 4:
                    würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel4.png);-fx-background-position: center");
                    break;
                case 5:
                    würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel5.png);-fx-background-position: center");
                    break;
                case 6:
                    würfel5.setStyle("-fx-border-color: black;-fx-background-image: url(/styles/würfel6.png);-fx-background-position: center");
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    //Button um Würfel5 zu markieren --> ruft methode hold1 auf
    private void actionhold5(ActionEvent event) {
        hold5();
    }

    @FXML
    //Button für Einer --> weist der Figur Punkte zu
    //Wenn es keine Einer hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetEinser(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iEiner == 1) {
                if (wurf1 == 1) {
                    pointEiner += wurf1;
                }
                if (wurf2 == 1) {
                    pointEiner += wurf2;
                }
                if (wurf3 == 1) {
                    pointEiner += wurf3;
                }
                if (wurf4 == 1) {
                    pointEiner += wurf4;
                }
                if (wurf5 == 1) {
                    pointEiner += wurf5;
                }
                userEiner.setText("" + pointEiner);
                iEiner++;
                btnuserEiner.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Zweier --> weist der Figur Punkte zu
    //Wenn es keine Zweier hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetZweier(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iZweier == 1) {
                if (wurf1 == 2) {
                    pointZweier += wurf1;
                }
                if (wurf2 == 2) {
                    pointZweier += wurf2;
                }
                if (wurf3 == 2) {
                    pointZweier += wurf3;
                }
                if (wurf4 == 2) {
                    pointZweier += wurf4;
                }
                if (wurf5 == 2) {
                    pointZweier += wurf5;
                }
                userZweier.setText("" + pointZweier);
                iZweier++;
                btnuserZweier.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Dreier --> weist der Figur Punkte zu
    //Wenn es keine Dreier hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetDreier(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iDreier == 1) {
                if (wurf1 == 3) {
                    pointDreier += wurf1;
                }
                if (wurf2 == 3) {
                    pointDreier += wurf2;
                }
                if (wurf3 == 3) {
                    pointDreier += wurf3;
                }
                if (wurf4 == 3) {
                    pointDreier += wurf4;
                }
                if (wurf5 == 3) {
                    pointDreier += wurf5;
                }
                userDreier.setText("" + pointDreier);
                iDreier++;
                btnuserDreier.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Vierer --> weist der Figur Punkte zu
    //Wenn es keine Vierer hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetVierer(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iVierer == 1) {
                if (wurf1 == 4) {
                    pointVierer += wurf1;
                }
                if (wurf2 == 4) {
                    pointVierer += wurf2;
                }
                if (wurf3 == 4) {
                    pointVierer += wurf3;
                }
                if (wurf4 == 4) {
                    pointVierer += wurf4;
                }
                if (wurf5 == 4) {
                    pointVierer += wurf5;
                }
                userVierer.setText("" + pointVierer);
                iVierer++;
                btnuserVierer.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Fuenfer --> weist der Figur Punkte zu
    //Wenn es keine Fuenfer hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetFuenfer(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iFunfer == 1) {
                if (wurf1 == 5) {
                    pointFunfer += wurf1;
                }
                if (wurf2 == 5) {
                    pointFunfer += wurf2;
                }
                if (wurf3 == 5) {
                    pointFunfer += wurf3;
                }
                if (wurf4 == 5) {
                    pointFunfer += wurf4;
                }
                if (wurf5 == 5) {
                    pointFunfer += wurf5;
                }
                userFunfer.setText("" + pointFunfer);
                iFunfer++;
                btnuserFuenfer.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Sechser --> weist der Figur Punkte zu
    //Wenn es keine Sechser hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetSechser(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iSechser == 1) {
                if (wurf1 == 6) {
                    pointSechser += wurf1;
                }
                if (wurf2 == 6) {
                    pointSechser += wurf2;
                }
                if (wurf3 == 6) {
                    pointSechser += wurf3;
                }
                if (wurf4 == 6) {
                    pointSechser += wurf4;
                }
                if (wurf5 == 6) {
                    pointSechser += wurf5;
                }
                userSechser.setText("" + pointSechser);
                iSechser++;
                btnuserSechser.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für DreierPasch --> weist der Figur Punkte zu
    //Wenn es keinen DreierPasch hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetDreierPasch(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iDreierPasch == 1) {
                ArrayList<Integer> würfel = new ArrayList();
                würfel.add(wurf1);
                würfel.add(wurf2);
                würfel.add(wurf3);
                würfel.add(wurf4);
                würfel.add(wurf5);
                int counter;
                for (int x : würfel) {
                    counter = 0;

                    for (int i : würfel) {
                        if (x == i) {
                            counter++;
                        }
                    }
                    if (counter == 3) {
                        pointDreierPasch = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                        userDreierPasch.setText("" + pointDreierPasch);
                        iDreierPasch++;
                        btnuserDreierPasch.setVisible(false);
                        setuserSubtotal();
                    } else {
                        pointDreierPasch = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                        userDreierPasch.setText("" + pointDreierPasch);
                        iDreierPasch++;
                        btnuserDreierPasch.setVisible(false);
                        setuserSubtotal();
                    }
                }
            }
            compzug();
        }
    }

    @FXML
    //Button für ViererPasch --> weist der Figur Punkte zu
    //Wenn es keinen ViererPasch hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetViererPasch(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iViererPasch == 1) {
                ArrayList<Integer> würfel = new ArrayList();
                würfel.add(wurf1);
                würfel.add(wurf2);
                würfel.add(wurf3);
                würfel.add(wurf4);
                würfel.add(wurf5);
                int counter;
                for (int x : würfel) {
                    counter = 0;

                    for (int i : würfel) {
                        if (x == i) {
                            counter++;
                        }
                    }
                    if (counter == 4) {
                        pointViererPasch = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                        userViererPasch.setText("" + pointViererPasch);
                        iViererPasch++;
                        btnuserViererPasch.setVisible(false);
                        setuserSubtotal();
                    } else {
                        pointViererPasch = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                        userViererPasch.setText("" + pointViererPasch);
                        iViererPasch++;
                        btnuserViererPasch.setVisible(false);
                        setuserSubtotal();
                    }
                }
            }
            compzug();
        }
    }

    @FXML
    //Button für FullHouse --> weist der Figur Punkte zu
    //Wenn es kein FullHouse hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetFullHouse(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iFullHouse == 1) {
                if ((wurf1 == wurf2) && (wurf1 == wurf3) && (wurf4 == wurf5)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf2) && (wurf3 == wurf5) && (wurf1 == wurf4)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf3) && (wurf1 == wurf4) && (wurf2 == wurf5)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf5) && (wurf2 == wurf3) && (wurf2 == wurf4)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf2) && (wurf3 == wurf4) && (wurf1 == wurf5)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf3) && (wurf2 == wurf4) && (wurf1 == wurf5)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf4) && (wurf2 == wurf3) && (wurf2 == wurf5)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf4) && (wurf1 == wurf5) && (wurf2 == wurf3)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf3) && (wurf2 == wurf4) && (wurf2 == wurf5)) {
                    pointFullHouse = 25;
                }
                if ((wurf1 == wurf2) && (wurf3 == wurf4) && (wurf3 == wurf5)) {
                    pointFullHouse = 25;
                }
                userFullHouse.setText("" + pointFullHouse);
                iFullHouse++;
                btnuserFullHouse.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }
    }

    @FXML
    //Button für kStrasse --> weist der Figur Punkte zu
    //Wenn es keine kStrasse hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetkStrasse(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (ikStrasse == 1) {
                ArrayList<Integer> würfel = new ArrayList();
                würfel.add(wurf1);
                würfel.add(wurf2);
                würfel.add(wurf3);
                würfel.add(wurf4);
                würfel.add(wurf5);
                if (würfel.contains(1) && würfel.contains(2) && würfel.contains(3) && würfel.contains(4)) {
                    pointkStrasse = 30;
                } else if (würfel.contains(2) && würfel.contains(3) && würfel.contains(4) && würfel.contains(5)) {
                    pointkStrasse = 30;
                } else if (würfel.contains(3) && würfel.contains(4) && würfel.contains(5) && würfel.contains(6)) {
                    pointkStrasse = 30;
                }
                userkStrasse.setText("" + pointkStrasse);
                ikStrasse++;
                btnuserkStrasse.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für gStrasse --> weist der Figur Punkte zu
    //Wenn es keine gStrasse hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetgStrasse(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (igStrasse == 1) {
                ArrayList<Integer> würfel = new ArrayList();
                würfel.add(wurf1);
                würfel.add(wurf2);
                würfel.add(wurf3);
                würfel.add(wurf4);
                würfel.add(wurf5);
                if (würfel.contains(2) && würfel.contains(3) && würfel.contains(4) && würfel.contains(5) && würfel.contains(6)) {
                    pointgStrasse = 40;
                } else if (würfel.contains(1) && würfel.contains(2) && würfel.contains(3) && würfel.contains(4) && würfel.contains(5)) {
                    pointgStrasse = 40;
                }
                usergStrasse.setText("" + pointgStrasse);
                igStrasse++;
                btnusergStrasse.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Yatzy --> weist der Figur Punkte zu
    //Wenn es kein Yatzy hat wird der Figur 0 Punkte zugewiesen.
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetYatzy(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iYatzy == 1) {
                if ((wurf1 == wurf2) && (wurf1 == wurf3) && (wurf1 == wurf4) && (wurf1 == wurf5)) {
                    pointYatzy = 50;
                }
                userYatzy.setText("" + pointYatzy);
                iYatzy++;
                btnuserYatzy.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    @FXML
    //Button für Chance --> weist der Figur Punkte zu
    //Es wird die Methode setuserSubTotal aufgerufen um zu überprüfen ob bereits ein Ergebins ausgerechnet werden kann
    //Danach ist der Comp am Zug.
    private void actionsetChance(ActionEvent event) throws SQLException {
        if (zugSpieler == true) {
            if (iChance == 1) {
                pointChance += wurf1;
                pointChance += wurf2;
                pointChance += wurf3;
                pointChance += wurf4;
                pointChance += wurf5;
                userChance.setText("" + pointChance);
                iChance++;
                btnuserChance.setVisible(false);
                setuserSubtotal();
            }
            compzug();
        }

    }

    //Überprüft ob alle Figuren ausgefüllt sind
    //Es werden die Einer - Sechser als Punkte zu dem SubTotal dazugezählt
    //Es wird die Methode setuserBonus aufgerufen
    private void setuserSubtotal() throws SQLException {
        if (iSubTotal == 1) {
            if (iEiner > 1 && iZweier > 1 && iDreier > 1 && iVierer > 1 && iFunfer > 1 && iSechser > 1 && iDreierPasch > 1 && iViererPasch > 1 && iFullHouse > 1 && ikStrasse > 1 && igStrasse > 1 && iYatzy > 1 && iChance > 1) {
                pointSubTotal = pointEiner + pointZweier + pointDreier + pointVierer + pointFunfer + pointSechser;
                userSubTotal.setText("Subtotal: " + pointSubTotal);
                setuserBonus();
                iSubTotal++;
            }
        }
    }

    //Überprüft ob das SubTotal einen Wert von 63 oder höher hat
    //Wenn ja --> gibt einen Bonus von 35  Wenn nein --> gibt keinen Bonus
    //Die Methode setuserTotal wird aufgerufen
    private void setuserBonus() throws SQLException {
        if (pointSubTotal >= 63) {
            pointBonus = 35;
            userBonus.setText("Bonus: " + pointBonus);
        } else {
            pointBonus = 0;
            userBonus.setText("Bonus: " + pointBonus);
        }
        setuserTotal();
    }

    //Zählt alle restlichen Figuren und den Bonus und das Subtotal zusammen
    //Die Methode gewonnen wird aufgerufen.
    private void setuserTotal() throws SQLException {
        pointTotal = pointDreierPasch + pointViererPasch + pointFullHouse + pointkStrasse + pointgStrasse + pointYatzy + pointChance + pointBonus + pointSubTotal;
        userTotal.setText("Total: " + pointTotal);
        iTotal++;
        compTotal();
    }

    //Die Methode compzug, reseted alles damit der Comp würfeln kann.
    private void compzug() throws SQLException {
        zugSpieler = false;
        zugComp = true;
        anzahlWurfe = 3;
        würfel1.setStyle("-fx-border-color: black;");
        würfel2.setStyle("-fx-border-color: black;");
        würfel3.setStyle("-fx-border-color: black;");
        würfel4.setStyle("-fx-border-color: black;");
        würfel5.setStyle("-fx-border-color: black;");
        hold1 = false;
        hold2 = false;
        hold3 = false;
        hold4 = false;
        hold5 = false;
        gedruckt1 = false;
        gedruckt2 = false;
        gedruckt3 = false;
        gedruckt4 = false;
        gedruckt5 = false;
        verbleibendeWurfel.setText("Verbleibende Würfe: " + anzahlWurfe);
        compRoll();
    }

    //Die Methode spielerzug, reseted alles damit der Spieler würfeln kann.
    private void spielerzug() {
        zugSpieler = true;
        zugComp = false;
        anzahlWurfe = 3;
        würfel1.setStyle("-fx-border-color: black;");
        würfel2.setStyle("-fx-border-color: black;");
        würfel3.setStyle("-fx-border-color: black;");
        würfel4.setStyle("-fx-border-color: black;");
        würfel5.setStyle("-fx-border-color: black;");
        hold1 = false;
        hold2 = false;
        hold3 = false;
        hold4 = false;
        hold5 = false;
        gedruckt1 = false;
        gedruckt2 = false;
        gedruckt3 = false;
        gedruckt4 = false;
        gedruckt5 = false;
        verbleibendeWurfel.setText("Verbleibende Würfe: " + anzahlWurfe);
    }

    //Ruft, wenn möglich Methode roll auf 
    //Danach wird die Methode checkFullHouse aufgerufen.
    private void compRoll() throws SQLException {
        if (zugComp == true && anzahlWurfe > 0) {
            roll();
            checkFullHouse();
        } else {
            spielerzug();
        }
    }

    //checkFullHouse überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkgStrasse aufgerufen
    private void checkFullHouse() throws SQLException {
        if (icompFullHouse == 1) {
            if ((wurf1 == wurf2) && (wurf1 == wurf3) && (wurf4 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf2) && (wurf3 == wurf5) && (wurf1 == wurf4)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf3) && (wurf1 == wurf4) && (wurf2 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf5) && (wurf2 == wurf3) && (wurf2 == wurf4)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf2) && (wurf3 == wurf4) && (wurf1 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf3) && (wurf2 == wurf4) && (wurf1 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf4) && (wurf2 == wurf3) && (wurf2 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf4) && (wurf1 == wurf5) && (wurf2 == wurf3)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf3) && (wurf2 == wurf4) && (wurf2 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else if ((wurf1 == wurf2) && (wurf3 == wurf4) && (wurf3 == wurf5)) {
                compPointFullHouse = 25;
                compFullHouse.setText("" + compPointFullHouse);
                icompFullHouse = 0;
                compSubTotal();
            } else {
                checkgStrasse();
            }
        } else {
            checkgStrasse();
        }

    }

    //checkgStrasse überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkkStrasse aufgerufen
    private void checkgStrasse() throws SQLException {
        if (icompgStrasse == 1) {
            ArrayList<Integer> würfel = new ArrayList();
            würfel.add(wurf1);
            würfel.add(wurf2);
            würfel.add(wurf3);
            würfel.add(wurf4);
            würfel.add(wurf5);
            if (würfel.contains(2) && würfel.contains(3) && würfel.contains(4) && würfel.contains(5) && würfel.contains(6)) {
                compPointgStrasse = 40;
                compgStrasse.setText("" + compPointgStrasse);
                icompgStrasse = 0;
                compSubTotal();
            } else if (würfel.contains(1) && würfel.contains(2) && würfel.contains(3) && würfel.contains(4) && würfel.contains(5)) {
                compPointgStrasse = 40;
                compgStrasse.setText("" + compPointgStrasse);
                icompgStrasse = 0;
                compSubTotal();
            } else {
                checkkStrasse();
            }
        } else {
            checkkStrasse();
        }
    }

    //checkkStrasse überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkYatzy aufgerufen
    private void checkkStrasse() throws SQLException {
        if (icompkStrasse == 1) {
            ArrayList<Integer> würfel = new ArrayList();
            würfel.add(wurf1);
            würfel.add(wurf2);
            würfel.add(wurf3);
            würfel.add(wurf4);
            würfel.add(wurf5);
            if (würfel.contains(1) && würfel.contains(2) && würfel.contains(3) && würfel.contains(4)) {
                compPointkStrasse = 30;
                compkStrasse.setText("" + compPointkStrasse);
                icompkStrasse = 0;
                compSubTotal();
            } else if (würfel.contains(2) && würfel.contains(3) && würfel.contains(4) && würfel.contains(5)) {
                compPointkStrasse = 30;
                compkStrasse.setText("" + compPointkStrasse);
                icompkStrasse = 0;
                compSubTotal();
            } else if (würfel.contains(3) && würfel.contains(4) && würfel.contains(5) && würfel.contains(6)) {
                compPointkStrasse = 30;
                compkStrasse.setText("" + compPointkStrasse);
                icompkStrasse = 0;
                compSubTotal();
            } else {
                checkYatzy();
            }
        } else {
            checkYatzy();
        }

    }

    //checkYatzy überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird check4Pasch aufgerufen
    private void checkYatzy() throws SQLException {
        if (icompYatzy == 1) {
            if ((wurf1 == wurf2) && (wurf1 == wurf3) && (wurf1 == wurf4) && (wurf1 == wurf5)) {
                compPointYatzy = 50;
                compYatzy.setText("" + compPointYatzy);
                icompYatzy = 0;
                compSubTotal();
            } else {
                check4Pasch();
            }
        } else {
            check4Pasch();
        }
    }

    //check4Pasch überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird check3Pasch aufgerufen
    private void check4Pasch() throws SQLException {
        if (icompViererPasch == 1 && wurf1 + wurf2 + wurf3 + wurf4 + wurf5 >= 23) {
            ArrayList<Integer> würfel = new ArrayList();
            würfel.add(wurf1);
            würfel.add(wurf2);
            würfel.add(wurf3);
            würfel.add(wurf4);
            würfel.add(wurf5);
            int counter;
            for (int x : würfel) {
                counter = 0;

                for (int i : würfel) {
                    if (x == i) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    compPointViererPasch = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                    compViererPasch.setText("" + compPointViererPasch);
                    icompViererPasch = 0;
                    compSubTotal();
                } else {
                    check3Pasch();
                }
            }
        } else {
            check3Pasch();
        }
    }

    //check3Pasch überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkFigure aufgerufen
    private void check3Pasch() throws SQLException {
        if (icompDreierPasch == 1 && wurf1 + wurf2 + wurf3 + wurf4 + wurf5 >= 21) {
            ArrayList<Integer> würfel = new ArrayList();
            würfel.add(wurf1);
            würfel.add(wurf2);
            würfel.add(wurf3);
            würfel.add(wurf4);
            würfel.add(wurf5);
            int counter;
            for (int x : würfel) {
                counter = 0;

                for (int i : würfel) {
                    if (x == i) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    compPointDreierPasch = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                    compDreierPasch.setText("" + compPointDreierPasch);
                    icompDreierPasch = 0;
                    compSubTotal();
                } else {
                    checkFigure();
                }
            }
        } else {
            checkFigure();
        }
    }

    //Die Methode checkFigure lässt den Comp nochmal Würfeln, wenn keine von den oberen Figuren ausgefüllt wurden.
    //Wenn die kStrasse und die gStrasse bereits ausgefüllt wurden wird nach einem 3Pasch gesucht und diese Würfel werden markiert
    //damit es für den Comp einfacher ist einen ViererPasch oder ein Yatzy oder ein Full House zu würfeln.
    //Wenn bereits 3 mal gewürfelt wurde wird die Methode check Chance aufgerufen
    private void checkFigure() throws SQLException {
        if (anzahlWurfe > 0) {
            compRoll();
        } else if (anzahlWurfe > 0 && icompkStrasse > 1 && icompgStrasse > 1) {
            if ((wurf1 == wurf2) && (wurf1 == wurf3)) {
                hold1();
                hold2();
                hold3();
                compRoll();
            } else if ((wurf1 == wurf2) && (wurf1 == wurf4)) {
                hold1();
                hold2();
                hold4();
                compRoll();
            } else if ((wurf1 == wurf2) && (wurf1 == wurf5)) {
                hold1();
                hold2();
                hold5();
                compRoll();
            } else if ((wurf1 == wurf3) && (wurf1 == wurf4)) {
                hold1();
                hold3();
                hold4();
                compRoll();
            } else if ((wurf1 == wurf4) && (wurf1 == wurf5)) {
                hold1();
                hold4();
                hold5();
                compRoll();
            } else if ((wurf2 == wurf3) && (wurf2 == wurf4)) {
                hold2();
                hold3();
                hold4();
                compRoll();
            } else if ((wurf2 == wurf3) && (wurf2 == wurf5)) {
                hold2();
                hold3();
                hold5();
                compRoll();
            } else if ((wurf2 == wurf4) && (wurf2 == wurf5)) {
                hold2();
                hold4();
                hold5();
                compRoll();
            } else if ((wurf3 == wurf4) && (wurf3 == wurf5)) {
                hold3();
                hold4();
                hold5();
                compRoll();
            }
        } else {
            checkChance();
        }
    }

    //checkChance wird nur ausgeführt wenn keine der oberen Figuren ausgefüllt wurde und wenn alle Zahlen der Würfel zusammen grösser oder gleich 20 sind.
    //Dies ist damit es nicht eine Chance gibt die nur wenige Punkte hat.
    //Wenn diese Figur ausgefüllt wurde wird die Methode compSubTotal aufgerufen.
    //Wenn nicht, dann wird die Methode checkEiner aufgerufen.
    private void checkChance() throws SQLException {
        if (icompChance == 1) {
            if (wurf1 + wurf2 + wurf3 + wurf4 + wurf5 >= 20) {
                compPointChance = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
                compChance.setText("" + compPointChance);
                icompChance = 0;
                compSubTotal();
            } else {
                checkEiner();
            }
        } else {
            checkEiner();
        }

    }

    //checkEiner überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkZweier aufgerufen
    private void checkEiner() throws SQLException {
        if (icompEiner == 1) {
            if (wurf1 == 1) {
                compPointEiner += wurf1;
            }
            if (wurf2 == 1) {
                compPointEiner += wurf2;
            }
            if (wurf3 == 1) {
                compPointEiner += wurf3;
            }
            if (wurf4 == 1) {
                compPointEiner += wurf4;
            }
            if (wurf5 == 1) {
                compPointEiner += wurf5;
            }
            compEiner.setText("" + compPointEiner);
            icompEiner = 0;
            compSubTotal();
        } else {
            checkZweier();
        }
    }

    //checkZweier überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkDreier aufgerufen
    private void checkZweier() throws SQLException {
        if (icompZweier == 1) {
            if (wurf1 == 2) {
                compPointZweier += wurf1;
            }
            if (wurf2 == 2) {
                compPointZweier += wurf2;
            }
            if (wurf3 == 2) {
                compPointZweier += wurf3;
            }
            if (wurf4 == 2) {
                compPointZweier += wurf4;
            }
            if (wurf5 == 2) {
                compPointZweier += wurf5;
            }
            compZweier.setText("" + compPointZweier);
            icompZweier = 0;
            compSubTotal();
        } else {
            checkDreier();
        }
    }

    //checkDreier überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkVierer aufgerufen
    private void checkDreier() throws SQLException {
        if (icompDreier == 1) {
            if (wurf1 == 3) {
                compPointDreier += wurf1;
            }
            if (wurf2 == 3) {
                compPointDreier += wurf2;
            }
            if (wurf3 == 3) {
                compPointDreier += wurf3;
            }
            if (wurf4 == 3) {
                compPointDreier += wurf4;
            }
            if (wurf5 == 3) {
                compPointDreier += wurf5;
            }
            compDreier.setText("" + compPointDreier);
            icompDreier = 0;
            compSubTotal();
        } else {
            checkVierer();
        }
    }

    //checkVierer überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkFuenfer aufgerufen
    private void checkVierer() throws SQLException {
        if (icompVierer == 1) {
            if (wurf1 == 4) {
                compPointVierer += wurf1;
            }
            if (wurf2 == 4) {
                compPointVierer += wurf2;
            }
            if (wurf3 == 4) {
                compPointVierer += wurf3;
            }
            if (wurf4 == 4) {
                compPointVierer += wurf4;
            }
            if (wurf5 == 4) {
                compPointVierer += wurf5;
            }
            compVierer.setText("" + compPointVierer);
            icompVierer = 0;
            compSubTotal();
        } else {
            checkFuenfer();
        }
    }

    //checkFuenfer überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird checkSechser aufgerufen
    private void checkFuenfer() throws SQLException {
        if (icompFuenfer == 1) {
            if (wurf1 == 5) {
                compPointFuenfer += wurf1;
            }
            if (wurf2 == 5) {
                compPointFuenfer += wurf2;
            }
            if (wurf3 == 5) {
                compPointFuenfer += wurf3;
            }
            if (wurf4 == 5) {
                compPointFuenfer += wurf4;
            }
            if (wurf5 == 5) {
                compPointFuenfer += wurf5;
            }
            compFuenfer.setText("" + compPointFuenfer);
            icompFuenfer = 0;
            compSubTotal();
        } else {
            checkSechser();
        }
    }

    //checkSechser überprüft für den Comp ob der Figur die Punkte zugewiesen werden können.
    //Wenn ja wird comSubTotal aufgerufen
    //Wenn nein wird compCloseEiner aufgerufen
    private void checkSechser() throws SQLException {
        if (icompSechser == 1) {
            if (wurf1 == 6) {
                compPointSechser += wurf1;
            }
            if (wurf2 == 6) {
                compPointSechser += wurf2;
            }
            if (wurf3 == 6) {
                compPointSechser += wurf3;
            }
            if (wurf4 == 6) {
                compPointSechser += wurf4;
            }
            if (wurf5 == 6) {
                compPointSechser += wurf5;
            }
            compSechser.setText("" + compPointSechser);
            icompSechser = 0;
            compSubTotal();
        } else {
            compCloseEiner();
        }
    }

    //Wenn keiner Figur Punkte zugewiesen werden können, muss eine Figur gestrichen werden.
    //Mit den Methoden compClose werden die Figuren geschlossen.
    //Die Methode compCloseEiner gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseZweier aufgerufen.
    private void compCloseEiner() throws SQLException {
        if (icompEiner == 1) {
            compEiner.setText("" + compPointEiner);
            icompEiner = 0;
            compSubTotal();
        } else {
            compCloseZweier();
        }
    }

    //Die Methode compCloseZweier gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseDreier aufgerufen.
    private void compCloseZweier() throws SQLException {
        if (icompZweier == 1) {
            compZweier.setText("" + compPointZweier);
            icompZweier = 0;
            compSubTotal();
        } else {
            compCloseDreier();
        }
    }

    //Die Methode compCloseDreier gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseVierer aufgerufen.
    private void compCloseDreier() throws SQLException {
        if (icompDreier == 1) {
            compDreier.setText("" + compPointDreier);
            icompDreier = 0;
            compSubTotal();
        } else {
            compCloseVierer();
        }

    }

    //Die Methode compCloseVierer gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseFuenfer aufgerufen.
    private void compCloseVierer() throws SQLException {
        if (icompVierer == 1) {
            compVierer.setText("" + compPointVierer);
            icompVierer = 0;
            compSubTotal();
        } else {
            compCloseFuenfer();
        }
    }

    //Die Methode compCloseFuenfer gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseSechser aufgerufen.
    private void compCloseFuenfer() throws SQLException {
        if (icompFuenfer == 1) {
            compFuenfer.setText("" + compPointFuenfer);
            icompFuenfer = 0;
            compSubTotal();
        } else {
            compCloseSechser();
        }
    }

    //Die Methode compCloseSechser gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compClosegStrasse aufgerufen.
    private void compCloseSechser() throws SQLException {
        if (icompSechser == 1) {
            compSechser.setText("" + compPointSechser);
            icompSechser = 0;
            compSubTotal();
        } else {
            compClosegStrasse();
        }
    }

    //Die Methode compClosegStrasse gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compClosekStrasse aufgerufen.
    private void compClosegStrasse() throws SQLException {
        if (icompgStrasse == 1) {
            compgStrasse.setText("" + compPointgStrasse);
            icompgStrasse = 0;
            compSubTotal();
        } else {
            compClosekStrasse();
        }
    }

    //Die Methode compClosekStrasse gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseYatzy aufgerufen.
    private void compClosekStrasse() throws SQLException {
        if (icompkStrasse == 1) {
            compkStrasse.setText("" + compPointkStrasse);
            icompkStrasse = 0;
            compSubTotal();
        } else {
            compCloseYatzy();
        }
    }

    //Die Methode compCloseYatzy gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseViererPasch aufgerufen.
    private void compCloseYatzy() throws SQLException {
        if (icompYatzy == 1) {
            compYatzy.setText("" + compPointYatzy);
            icompYatzy = 0;
            compSubTotal();
        } else {
            compCloseViererPasch();
        }
    }

    //Die Methode compCloseViererPasch gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseDreierPasch aufgerufen.
    private void compCloseViererPasch() throws SQLException {
        if (icompViererPasch == 1) {
            compViererPasch.setText("" + compPointViererPasch);
            icompViererPasch = 0;
            compSubTotal();
        } else {
            compCloseDreierPasch();
        }
    }

    //Die Methode compCloseDreierPasch gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    //Wenn nicht wird compCloseFullHouse aufgerufen.
    private void compCloseDreierPasch() throws SQLException {
        if (icompDreierPasch == 1) {
            compViererPasch.setText("" + compPointViererPasch);
            compDreierPasch.setText("" + compPointDreierPasch);
            icompDreierPasch = 0;
            compSubTotal();
        } else {
            compCloseFullHouse();
        }
    }

    //Die Methode compCloseFullHouse gibt der Figur 0 Punkte
    //Wenn diese Figur gestrichen wird, wird compSubTotal aufgerufen
    private void compCloseFullHouse() throws SQLException {
        if (icompFullHouse == 1) {
            compFullHouse.setText("" + compPointFullHouse);
            icompFullHouse = 0;
            compSubTotal();
        } else {
            compCloseChance();
        }
    }

    private void compCloseChance() throws SQLException {
        if (icompChance == 1) {
            compPointChance = wurf1 + wurf2 + wurf3 + wurf4 + wurf5;
            compChance.setText("" + compPointChance);
            icompChance = 0;
            compSubTotal();
        }
    }

    //Die Methode compSubTotal wird aufgerufen, wenn einer Figur Punkte zugewiesen werden oder wenn eine Figur gestrichen wird.
    //Sie wird so oft aufgerufen bis jede Figur Punkte hat oder gestrichen ist.
    //Wenn dies der Fall ist wird dem SubTotal die Punkte der Figuren Einer, Zweier, Dreier, Vierer, Fuenfer und Sechser zugewiesen.
    //Danach wird compBonus aufgerufen.
    //Wenn dies nicht der Fall ist, ist der Spieler wieder am Zug.
    private void compSubTotal() throws SQLException {
        if (icompSubTotal == 1) {
            if (iSubTotal > 1 && icompEiner == 0 && icompZweier == 0 && icompDreier == 0 && icompVierer == 0 && icompFuenfer == 0 && icompSechser == 0 && icompDreierPasch == 0 && icompViererPasch == 0 && icompFullHouse == 0 && icompkStrasse == 0 && icompgStrasse == 0 && icompYatzy == 0 && icompChance == 0) {
                compPointSubTotal = compPointEiner + compPointZweier + compPointDreier + compPointVierer + compPointFuenfer + compPointSechser;
                compSubTotal.setText("Subtotal: " + compPointSubTotal);
                icompSubTotal++;
                compBonus();
            } else {
                spielerzug();
            }
        }
    }

    //Die Methode compBonus überprüft ob das SubTotal des Comps 63 oder grösser ist
    //Wenn ja wird ein Bonus von 35 gegeben
    //Wenn nein wird kein Bonus gegeben
    //Die Methode compTotal wird aufgerufen.
    private void compBonus() throws SQLException {
        if (compPointSubTotal >= 63) {
            compPointBonus = 35;
            compBonus.setText("Bonus: " + compPointBonus);
        } else {
            compPointBonus = 0;
            compBonus.setText("Bonus: " + compPointBonus);
        }
    }

    //Zählt die restlichen Figuren und den Bonus und das SubTotal zusammen und ergibt die Totalpunktzahl des Comp
    //Die Methode gewonnen wird aufgerufen
    private void compTotal() throws SQLException {
        compPointTotal = compPointDreierPasch + compPointViererPasch + compPointFullHouse + compPointkStrasse + compPointgStrasse + compPointYatzy + compPointChance + compPointBonus + compPointSubTotal;
        compTotal.setText("Total: " + compPointTotal);
        icompTotal++;
        gewonnen();
    }

    //Überprüft ob das Total des Spielers grösser ist als das Total des Comp
    //Wenn ja bekommt der Spieler den doppelten Betrag zurück gezahlt
    //Wenn nein wird die Methode verloren aufgerufen.
    private void gewonnen() throws SQLException {
        if (icompTotal > 1 && iTotal > 1) {
            if (pointTotal > compPointTotal) {
                JOptionPane.showMessageDialog(null, "Sie haben gewonnen, der gesetzte Betrag wird verdoppelt und ihrem Konto dazu gerechnet", "Gewonnen", JOptionPane.PLAIN_MESSAGE);
                kontostand = kontostand + (betrag * 2);
                d.updateKontoYatzy(kontostand, name);
                lblkontostand.setText("Kontostand: " + kontostand);
            } else {
                verloren();
            }
        }
    }

    //Die Methode verloren überprüft ob das Total des Spielers kleiner ist als das Total des Comp
    //Wenn ja wird dem Spieler der Betrag abgezogen 
    //Wenn nein wird die Methode unentschieden aufgerufen
    private void verloren() throws SQLException {
        if (pointTotal < compPointTotal) {
            JOptionPane.showMessageDialog(null, "Sie haben verloren, der gesetzte Betrag wird Ihnen vom Konto abgezogen", "Verloren", JOptionPane.PLAIN_MESSAGE);
        } else {
            unentschieden();
        }
    }

    //Die Methode unentschieden überprüft ob die beiden Totale des Spielers und des Comps gleich sind.
    //Der Betrag wird dem Spieler unverändert zurückgezahlt.
    private void unentschieden() throws SQLException {
        if (pointTotal == compPointTotal) {
            JOptionPane.showMessageDialog(null, "Es ist Unentschieden, Sie bekommen den vollen Betrag zurückgezahlt.", "Unentschieden", JOptionPane.PLAIN_MESSAGE);
            kontostand = kontostand + betrag;
            d.updateKontoYatzy(kontostand, name);
            lblkontostand.setText("Kontostand: " + kontostand);
        }
    }
}
