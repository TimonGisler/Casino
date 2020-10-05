/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Casino.DBController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Besitzer
 */
public class FXMLSpielController implements Initializable {

    @FXML
    private Button quitButton;
    @FXML
    private Label kartenGrou;
    @FXML
    private Label grouKarte1;
    @FXML
    private Label grouKarte2;
    @FXML
    private Label grouKarte3;
    @FXML
    private Label grouKarte4;
    @FXML
    private Label grouKarte5;
    @FXML
    private Label grouKarte6;
    @FXML
    private Label grouKarte7;
    @FXML
    private Label kartenSpie;
    @FXML
    private Label spieKarte1;
    @FXML
    private Label spieKarte2;
    @FXML
    private Label spieKarte3;
    @FXML
    private Label spieKarte4;
    @FXML
    private Label spieKarte5;
    @FXML
    private Label spieKarte6;
    @FXML
    private Label spieKarte7;
    @FXML
    private Button neueKarteButton;
    @FXML
    private Button keineKarteButton;
    @FXML
    private Button versichernButton;
    @FXML
    private Button verdoppelnButton;
    @FXML
    private Button einsatzBest;
    @FXML
    private Label kontoLabel;
    @FXML
    private Label einsatzLabel;
    @FXML
    private Label gewinnLabel;
    @FXML
    private Label fehlerMeldung;
    @FXML
    private Label geWertGrou;
    @FXML
    private Label geWertSpie;
    @FXML
    private AnchorPane aphome;
    
    int einsatz = 0;
    int gewinn = 0;
    int playerValue = 0;
    int splitValue = 0;
    int groupierValue = 0;
    int konto = 0;
    boolean bestaetigtSetzen = false;
    int ersteGrouKarte = 0;
    String zweiteGrouKarte = "";
    int ersteSpieKarte = 0;
    int zweiteSpieKarte = 0;
    Random random = new Random();
    boolean versicherbar = false;
    boolean doubleable = false;
    boolean spieSwitch1 = false;
    boolean spieSwitch2 = false;
    boolean spieSwitch3 = false;
    boolean spieSwitch4 = false;
    boolean spieSwitch5 = false;
    boolean spieSwitch6 = false;
    boolean spieSwitch7 = false;
    boolean grouSwitch1 = false;
    boolean grouSwitch2 = false;
    boolean grouSwitch3 = false;
    boolean grouSwitch4 = false;
    boolean grouSwitch5 = false;
    boolean grouSwitch6 = false;
    boolean grouSwitch7 = false;
    boolean spliSwitch1 = false;
    boolean spliSwitch2 = false;
    boolean spliSwitch3 = false;
    boolean spliSwitch4 = false;
    boolean spliSwitch5 = false;
    boolean spliSwitch6 = false;
    boolean spliSwitch7 = false;
    boolean bestaetigtVersichern = false;
    int versichert = 0;
    boolean versichertButton = false;
    int spieKartenNummer = 3;
    int grouKartenNummer = 3;
    boolean doubled = false;
    boolean started = false;
    boolean finished = false;
    boolean doubleableSwitch = false;
    DBController db = null;
    static String name;
    
    ArrayList<String> cards = new ArrayList<>();
    @FXML
    private Label resultLabel;
    @FXML
    private Label messageLabel;
    @FXML
    private Label versichertLabel;
    @FXML
    private ImageView spielBack;
    @FXML
    private ComboBox<String> chettons;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        kartenHinzufügen();
//        spielBack.setImage(new Image("ruleBackground.png"));     //Hintergrund setzen
        resultLabel.setText("");                                        //Texte entfernen
        grouKarte1.setText("");
        grouKarte2.setText("");
        grouKarte3.setText("");
        grouKarte4.setText("");
        grouKarte5.setText("");
        grouKarte6.setText("");
        grouKarte7.setText("");
        spieKarte1.setText("");
        spieKarte2.setText("");
        spieKarte3.setText("");
        spieKarte4.setText("");
        spieKarte5.setText("");
        spieKarte6.setText("");
        spieKarte7.setText("");
        fehlerMeldung.setText("");
        messageLabel.setText("");
        chettons.getItems().addAll(
            "10",
            "20",
            "50",
            "100",
            "500"
        );
        
        try {
            db = new DBController();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            konto = db.getKonto(name);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }
        kontoLabel.setText("Konto: " + konto);
    }    

    @FXML
    private void quit(ActionEvent event) throws IOException
    {
        try{
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.setResizable(false);
           stage.setWidth(1500);
           stage.setHeight(900);
           stage.show();
           
            Stage stageclose = (Stage) quitButton.getScene().getWindow();
            stageclose.close();
       }
       catch(IOException e)
       {
           System.err.println(e.getMessage());
       }
    }

    @FXML
    private void karteZiehen(ActionEvent event) throws SQLException
    {
        if(versicherbar == true && versichertButton == false && groupierValue + getWert(zweiteGrouKarte) == 21){    //Überprüfen ob Groupier mit Black Jack gewinnt
            finished = true;
            bestaetigtSetzen = false;
            resultLabel.setText("Sie haben verloren");
            gewinnLabel.setText("Gewinn: 0");
            grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
            groupierValue += getWert(zweiteGrouKarte);
            geWertGrou.setText("Wert: " + groupierValue);
        }
        if(started == true && finished != true){                            //Neue Karte ziehen
            doubleable = false;
            versicherbar = false;
            
                verdoppelnButton.setStyle("-fx-text-fill: black");
                versichernButton.setStyle("-fx-text-fill: black");
                spieSwitchCheck();
                switch(spieKartenNummer){                                                   //Momentane Kartenzahl überprüfen
                    case 3:
                        int randomInteger = random.nextInt(cards.size() + 1);
                        spieKarte3.setGraphic(new ImageView(cards.get(randomInteger)));
                        playerValue += getWert(cards.get(randomInteger));
                        if(getWert(cards.get(randomInteger)) == 11){
                            spieSwitch3 = true;
                        }
                        spieSwitchCheck();
                        cards.remove(randomInteger);
                        spieKartenNummer += 1;
                        geWertSpie.setText("Wert: " + Integer.toString(playerValue));
                        break;
                    case 4:
                        randomInteger = random.nextInt(cards.size() + 1);
                        spieKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        playerValue += getWert(cards.get(randomInteger));
                        if(getWert(cards.get(randomInteger)) == 11){
                            spieSwitch4 = true;
                        }
                        spieSwitchCheck();
                        cards.remove(randomInteger);
                        spieKartenNummer += 1;
                        geWertSpie.setText("Wert: " + Integer.toString(playerValue));
                        break;
                    case 5:
                        randomInteger = random.nextInt(cards.size() + 1);
                        spieKarte5.setGraphic(new ImageView(cards.get(randomInteger)));
                        playerValue += getWert(cards.get(randomInteger));
                        if(getWert(cards.get(randomInteger)) == 11){
                            spieSwitch5 = true;
                        }
                        spieSwitchCheck();
                        cards.remove(randomInteger);
                        spieKartenNummer += 1;
                        geWertSpie.setText("Wert: " + Integer.toString(playerValue));
                        break;
                    case 6:
                        randomInteger = random.nextInt(cards.size() + 1);
                        spieKarte6.setGraphic(new ImageView(cards.get(randomInteger)));
                        playerValue += getWert(cards.get(randomInteger));
                        if(getWert(cards.get(randomInteger)) == 11){
                            spieSwitch6 = true;
                        }
                        spieSwitchCheck();
                        cards.remove(randomInteger);
                        spieKartenNummer += 1;
                        geWertSpie.setText("Wert: " + Integer.toString(playerValue));
                        break;
                    case 7:
                        randomInteger = random.nextInt(cards.size() + 1);
                        spieKarte7.setGraphic(new ImageView(cards.get(randomInteger)));
                        playerValue += getWert(cards.get(randomInteger));
                        if(getWert(cards.get(randomInteger)) == 11){
                            spieSwitch7 = true;
                        }
                        spieSwitchCheck();
                        cards.remove(randomInteger);
                        geWertSpie.setText("Wert: " + Integer.toString(playerValue));
                        break;
                    
                }
                spieSwitchCheck();
                if(playerValue > 21){                                                   //Überprüfen ob Spieler 21 überschritten hat
                    resultLabel.setText("Sie haben verloren.");
                    gewinnLabel.setText("Gewinn: 0");
                    grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
                    groupierValue += getWert(zweiteGrouKarte);
                    geWertGrou.setText("Wert: " + groupierValue);
                    grouSwitchCheck();
                    if(versichertButton == true && ersteGrouKarte == 11 && getWert(zweiteGrouKarte) == 10){
                        resultLabel.setText("Versicherung gewonnen");
                        gewinn = versichert * 2;
                        gewinnLabel.setText("Gewinn: " + gewinn);
                        konto += gewinn;
                        db.updateKontoHome(gewinn, name);
                        kontoLabel.setText("Konto: " + konto);
                    }
                    finished = true;
                    bestaetigtSetzen = false;
                }
                if(playerValue == 21){                                                  //Überprüfen ob Spieler max Wert erreicht hat
                    grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
                    groupierValue += getWert(zweiteGrouKarte);
                    while(groupierValue < 17){                                          //Groupier zieht Karten
                        switch(grouKartenNummer){
                            case 3:
                                int randomInteger = random.nextInt(cards.size() + 1);
                                grouKarte3.setGraphic(new ImageView(cards.get(randomInteger)));
                                groupierValue += getWert(cards.get(randomInteger));
                                geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                                if(getWert(cards.get(randomInteger)) == 11){
                                    grouSwitch3 = true;
                                }
                                grouSwitchCheck();
                                cards.remove(randomInteger);
                                break;
                            case 4:
                                randomInteger = random.nextInt(cards.size() + 1);
                                grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                                groupierValue += getWert(cards.get(randomInteger));
                                geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                                if(getWert(cards.get(randomInteger)) == 11){
                                    grouSwitch4 = true;
                                }
                                grouSwitchCheck();
                                cards.remove(randomInteger);
                            case 5:
                                randomInteger = random.nextInt(cards.size() + 1);
                                grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                                groupierValue += getWert(cards.get(randomInteger));
                                geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                                if(getWert(cards.get(randomInteger)) == 11){
                                    grouSwitch5 = true;
                                }
                                grouSwitchCheck();
                                cards.remove(randomInteger);
                            case 6:
                                randomInteger = random.nextInt(cards.size() + 1);
                                grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                                groupierValue += getWert(cards.get(randomInteger));
                                geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                                if(getWert(cards.get(randomInteger)) == 11){
                                    grouSwitch6 = true;
                                }
                                grouSwitchCheck();
                                cards.remove(randomInteger);
                            case 7:
                                randomInteger = random.nextInt(cards.size() + 1);
                                grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                                groupierValue += getWert(cards.get(randomInteger));
                                geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                                if(getWert(cards.get(randomInteger)) == 11){
                                    grouSwitch7 = true;
                                }
                                grouSwitchCheck();
                                cards.remove(randomInteger);
                        }
                    }
                    geWertGrou.setText("Wert: " + groupierValue);
                    if(playerValue > groupierValue){                                //Überprüfen ob Spieler gewinnt oder unentschieden
                        gewinn = einsatz * 2;
                        resultLabel.setText("Sie haben gewonnen.");
                        gewinnLabel.setText("Gewinn: " + gewinn);
                        konto = konto + gewinn;
                        db.updateKontoHome(gewinn, name);
                        bestaetigtSetzen = false;
                    }else if(playerValue == groupierValue){
                        gewinn = einsatz;
                        resultLabel.setText("Sie haben unentschieden.");
                        gewinnLabel.setText("Gewinn: " + gewinn);
                        konto += gewinn;
                        db.updateKontoHome(gewinn, name);
                        bestaetigtSetzen = false;
                    }
                }
            
        }
    }

    @FXML
    private void keineKarte(ActionEvent event) throws InterruptedException, SQLException
    {
        if(versicherbar == true && versichertButton == false && groupierValue + getWert(zweiteGrouKarte) == 21){    //Überprüfen ob Groupier Black Jack hat
            finished = true;
            bestaetigtSetzen = false;
            resultLabel.setText("Sie haben verloren");
            gewinnLabel.setText("Gewinn: 0");
            grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
            groupierValue += getWert(zweiteGrouKarte);
            geWertGrou.setText("Wert:" + groupierValue);
        }
        if(started == true && finished != true){
            finished = true;
            verdoppelnButton.setStyle("-fx-text-fill: black");
            versichernButton.setStyle("-fx-text-fill: black");
            grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));                  //Zweite Karte aufdecken
            groupierValue += getWert(zweiteGrouKarte);
            if(groupierValue > 21 && grouSwitch1 == true){                          //Überprüfen ob Wert von Ass ersetzt werden kann
                groupierValue = groupierValue - 10;
                grouSwitch1 = false;
            }
            if(groupierValue > 21 && grouSwitch2 == true){
                groupierValue = groupierValue - 10;
                grouSwitch2 = false;
            }
            while(groupierValue < 17){                                              //Karten ziehen bis 17 überschritten wird
                switch(grouKartenNummer){
                    case 3:
                        int randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte3.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch3 = true;
                        }
                        grouSwitchCheck();
                        cards.remove(randomInteger);
                        break;
                    case 4:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch4 = true;
                        }
                        grouSwitchCheck();
                        cards.remove(randomInteger);
                    case 5:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch5 = true;
                        }
                        grouSwitchCheck();
                        cards.remove(randomInteger);
                    case 6:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch6 = true;
                        }
                        grouSwitchCheck();
                        cards.remove(randomInteger);
                    case 7:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch7 = true;
                        }
                        grouSwitchCheck();
                        cards.remove(randomInteger);
                }
            }
            geWertGrou.setText("Wert: " + groupierValue);
            if(playerValue > groupierValue || groupierValue > 21){                  //Überprüfen wer gewonnen hat
                resultLabel.setText("Sie haben gewonnen.");
                gewinn = einsatz * 2;
                gewinnLabel.setText("Gewinn: " + gewinn);
                konto = konto + gewinn;
                db.updateKontoHome(gewinn, name);
                kontoLabel.setText("Konto: " + konto);
            }else if(playerValue == groupierValue){
                resultLabel.setText("Sie haben unentschieden.");
                gewinn = einsatz;
                gewinnLabel.setText("Gewinn: " + gewinn);
                konto = konto + gewinn;
                db.updateKontoHome(gewinn, name);
                kontoLabel.setText("Konto: " + konto);
            }else if((versichertButton == true && ersteGrouKarte == 11 && getWert(zweiteGrouKarte) == 10)){
                resultLabel.setText("Versicherung gewonnen");
                gewinn = versichert * 2;
                gewinnLabel.setText("Gewinn: " + gewinn);
                konto += gewinn;
                db.updateKontoHome(gewinn, name);
                kontoLabel.setText("Konto: " + konto);
            }else{
                resultLabel.setText("Sie haben verloren.");
                gewinnLabel.setText("Gewinn: 0");
            }
            bestaetigtSetzen = false;
        }
    }

    @FXML
    private void versichern(ActionEvent event)
    {
        if(versicherbar == true && started == true && finished != true){            //Versichern einschalten
            messageLabel.setText("Geben Sie einen Wert zum versichern ein.");
            versichertButton = true;
            doubleable = false;
        }
    }

    @FXML
    private void verdoppeln(ActionEvent event) throws InterruptedException, SQLException
    {
        if(doubleable == true && started == true && finished != true && konto >= einsatz){
            konto = konto - einsatz;                                                  //Einsatz verdoppeln
            db.updateKontoHome(-einsatz, name);
            einsatz = einsatz * 2;
            einsatzLabel.setText("Einsatz: " + einsatz);
            kontoLabel.setText("Konto: " + konto);
            verdoppelnButton.setStyle("-fx-text-fill: black");
            if(doubleableSwitch == true){
                if(spieSwitch1 == true){
                    spieSwitch1 = false;
                    playerValue = playerValue - 10;
                }else if(spieSwitch2 == true){
                    spieSwitch2 = false;
                    playerValue = playerValue - 10;
                }
            }
            doubleable = false;
            versicherbar = false;
            int randomInteger = random.nextInt(cards.size() + 1);                       //Weitere Karte ziehen
            spieKarte3.setGraphic(new ImageView(cards.get(randomInteger)));
            playerValue += getWert(cards.get(randomInteger));
            if(getWert(cards.get(randomInteger)) == 11){
                spieSwitch3 = true;
            }
            cards.remove(randomInteger);
            if(playerValue > 21 && spieSwitch1 == true){
                playerValue = playerValue - 10;
                spieSwitch1 = false;
            }
            if(playerValue > 21 && spieSwitch2 == true){
                playerValue = playerValue - 10;
                spieSwitch2 = false;
            }
            if(playerValue > 21 && spieSwitch3 == true){
                playerValue = playerValue - 10;
                spieSwitch3 = false;
            }
            geWertSpie.setText("Wert: " + playerValue);
            grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
            groupierValue += getWert(zweiteGrouKarte);
            while(groupierValue < 17){
                switch(grouKartenNummer){                                               //Groupier zieht Karten
                    case 3:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte3.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch3 = true;
                        }
                        cards.remove(randomInteger);
                        grouSwitchCheck();
                        break;
                    case 4:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch4 = true;
                        }
                        cards.remove(randomInteger);
                    case 5:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch5 = true;
                        }
                        cards.remove(randomInteger);
                        grouSwitchCheck();
                    case 6:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch6 = true;
                        }
                        cards.remove(randomInteger);
                        grouSwitchCheck();
                    case 7:
                        randomInteger = random.nextInt(cards.size() + 1);
                        grouKarte4.setGraphic(new ImageView(cards.get(randomInteger)));
                        groupierValue += getWert(cards.get(randomInteger));
                        geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                        if(getWert(cards.get(randomInteger)) == 11){
                            grouSwitch7 = true;
                        }
                        cards.remove(randomInteger);
                        grouSwitchCheck();
                    }
                }
                geWertGrou.setText("Wert: " + groupierValue);                       //Überprüfen wer gewonnen hat
                if(playerValue > groupierValue || groupierValue > 21){
                    resultLabel.setText("Sie haben gewonnen.");
                    gewinn = einsatz * 2;
                    gewinnLabel.setText("Gewinn:" + gewinn);
                    konto = konto + gewinn;
                    db.updateKontoHome(gewinn, name);
                }else if(playerValue == groupierValue){
                    resultLabel.setText("Sie haben unentschieden.");
                    gewinn = einsatz;
                    gewinnLabel.setText("Gewinn: " + gewinn);
                    konto = konto + gewinn;
                    db.updateKontoHome(gewinn, name);
                }else{
                    resultLabel.setText("Sie haben verloren.");
                    gewinnLabel.setText("Gewinn: 0");
                }
                bestaetigtSetzen = false;
                kontoLabel.setText("Konto: " + konto);
            doubled = true;
        }
    }
    
    @FXML
    private void setzen(ActionEvent event) throws SQLException
    {
        if(versichertButton == true){                                               //Versichern Betrag setzen
            if(bestaetigtVersichern == false){
                versichert = Integer.parseInt(chettons.getSelectionModel().getSelectedItem());
                if(versichert <= 0){
                    fehlerMeldung.setText("Die Zahl muss positiv sein.");
                }else if(versichert > konto){
                    fehlerMeldung.setText("Die Zahl muss kleiner als Ihr Konto sein.");
                }else{
                    fehlerMeldung.setText("");
                    versichertLabel.setText("Versichert: " + Integer.toString(versichert));
                    konto = konto - versichert;
                    db.updateKontoHome(-versichert, name);
                    bestaetigtVersichern = true;
                    versichernButton.setStyle("-fx-text-fill: black");
                    if(groupierValue + getWert(zweiteGrouKarte) == 21){
                        resultLabel.setText("Versicherung gewonnen");
                        gewinn = versichert * 2;
                        gewinnLabel.setText("Gewinn: " + gewinn);
                        konto = konto + gewinn;
                        db.updateKontoHome(gewinn, name);
                        grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
                        groupierValue += getWert(zweiteGrouKarte);
                        bestaetigtSetzen = false;
                        finished = true;
                    }
                }
            }
        }
        if(bestaetigtSetzen == false){                                              //Betrag setzen
            reset();
            try{
            einsatz = Integer.parseInt(chettons.getSelectionModel().getSelectedItem());
            if(einsatz > konto){
                fehlerMeldung.setText("Die Zahl muss kleiner als Ihr Konto sein.");
            }else{
                fehlerMeldung.setText("");
                db.updateKontoHome(-einsatz, name);
                //konto = konto - einsatz;
                einsatzLabel.setText("Einsatz: " + Double.toString(einsatz));
                kontoLabel.setText("Konto: " + konto);
                bestaetigtSetzen = true;
                
                int randomInteger = random.nextInt(cards.size() + 1);              //Erste Karten ziehen
                System.out.println("Test");
                spieKarte1.setGraphic(new ImageView(cards.get(randomInteger)));
                playerValue += getWert(cards.get(randomInteger));
                ersteSpieKarte = getWert(cards.get(randomInteger));
                if(ersteSpieKarte == 11){
                    spieSwitch1 = true;
                }
                cards.remove(randomInteger);
                
                randomInteger = random.nextInt(cards.size() + 1);
                spieKarte2.setGraphic(new ImageView(cards.get(randomInteger)));
                playerValue += getWert(cards.get(randomInteger));
                zweiteSpieKarte = getWert(cards.get(randomInteger));
                if(zweiteSpieKarte == 11){
                    spieSwitch2 = true;
                }
                geWertSpie.setText("Wert: " + playerValue);
                cards.remove(randomInteger);
                
                randomInteger = random.nextInt(cards.size() + 1);
                grouKarte1.setGraphic(new ImageView(cards.get(randomInteger)));
                groupierValue += getWert(cards.get(randomInteger));
                if(getWert(cards.get(randomInteger)) == 11){
                    grouSwitch1 = true;
                }
                ersteGrouKarte = groupierValue;
                geWertGrou.setText("Wert: " + Integer.toString(groupierValue));
                cards.remove(randomInteger);
                
                randomInteger = random.nextInt(cards.size() + 1);
                zweiteGrouKarte = cards.get(randomInteger);
                if(getWert(cards.get(randomInteger)) == 11){
                    grouSwitch1 = true;
                }
                grouKarte2.setGraphic(new ImageView("/img/blackjack/redBack.png"));
                cards.remove(randomInteger);
                
                konto = konto - einsatz;
                kontoLabel.setText("Konto: " + konto);
                
                if(playerValue > 21 && spieSwitch1 == true){                        
                    playerValue = playerValue - 10;
                    spieSwitch1 = false;
                    geWertSpie.setText("Wert: " + playerValue);
                }
                if(playerValue > 21 && spieSwitch2 == true){
                    playerValue = playerValue - 10;
                    spieSwitch2 = false;
                    geWertSpie.setText("Wert: " + playerValue);
                }
                if(groupierValue > 21 && grouSwitch1 == true){
                    groupierValue = groupierValue - 10;
                    grouSwitch1 = false;
                }
                
                if(ersteGrouKarte == 11){                                           //Überprüfen ob versicherbar
                    versicherbar = true;
                    versichernButton.setStyle("-fx-text-fill: red");
                }
                
                if(playerValue == 21){                                              //Überprüfen für Black Jack
                    versichernButton.setStyle("-fx-text-fill: black");
                    verdoppelnButton.setStyle("-fx-text-fill: black");
                    grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
                    groupierValue += getWert(zweiteGrouKarte);
                    geWertGrou.setText("Wert: " + groupierValue);
                    if(playerValue > groupierValue){
                        resultLabel.setText("Sie haben gewonnen");
                        gewinn = (int) (einsatz * 2.5);
                        gewinnLabel.setText("Gewinn: " + gewinn);
                    }else if(playerValue == groupierValue){
                        resultLabel.setText("Sie haben unentschieden");
                        gewinn = (int) (einsatz * 2.5);
                        gewinnLabel.setText("Gewinn: " + gewinn);
                    }
                    konto += gewinn;
                    db.updateKontoHome(gewinn, name);
                    kontoLabel.setText("Konto: " + konto);
                    finished = true;
                    bestaetigtSetzen = false;
                }else if(groupierValue + getWert(zweiteGrouKarte) == 21 && versicherbar == false){
                    resultLabel.setText("Sie haben verloren");
                    gewinnLabel.setText("Gewinn: 0");
                    groupierValue += getWert(zweiteGrouKarte);
                    geWertGrou.setText("Wert: " + groupierValue);
                    grouKarte2.setGraphic(new ImageView(zweiteGrouKarte));
                    groupierValue += getWert(zweiteGrouKarte);
                    bestaetigtSetzen = false;
                }else{
                    started = true;
                }
                
                if((spieSwitch1 == true || spieSwitch2 == true ) && (playerValue - 10 == 9 || playerValue - 10 == 10 || playerValue - 10 == 11) && finished == false){  //Überprüfen für Double
                    doubleable = true;
                    doubleableSwitch = true;
                    geWertSpie.setText("Wert: " + playerValue);
                    verdoppelnButton.setStyle("-fx-text-fill: red");
                }
                if(playerValue == 9 || playerValue == 10 || playerValue == 11 && finished == false){
                    doubleable = true;
                    verdoppelnButton.setStyle("-fx-text-fill: red");
                }
                }
            }catch(Exception e){
                fehlerMeldung.setText("Bitte wählen Sie eine Zahl aus.");
            }
        }
    }
    
    private void kartenHinzufügen(){
        cards.add("/img/blackjack/2C.png");
        cards.add("/img/blackjack/3C.png");
        cards.add("/img/blackjack/4C.png");
        cards.add("/img/blackjack/5C.png");
        cards.add("/img/blackjack/6C.png");
        cards.add("/img/blackjack/7C.png");
        cards.add("/img/blackjack/8C.png");
        cards.add("/img/blackjack/9C.png");
        cards.add("/img/blackjack/10C.png");
        cards.add("/img/blackjack/JC.png");
        cards.add("/img/blackjack/QC.png");
        cards.add("/img/blackjack/KC.png");
        cards.add("/img/blackjack/AC.png");
        cards.add("/img/blackjack/2D.png");
        cards.add("/img/blackjack/3D.png");
        cards.add("/img/blackjack/4D.png");
        cards.add("/img/blackjack/5D.png");
        cards.add("/img/blackjack/6D.png");
        cards.add("/img/blackjack/7D.png");
        cards.add("/img/blackjack/8D.png");
        cards.add("/img/blackjack/9D.png");
        cards.add("/img/blackjack/10D.png");
        cards.add("/img/blackjack/JD.png");
        cards.add("/img/blackjack/QD.png");
        cards.add("/img/blackjack/KD.png");
        cards.add("/img/blackjack/AD.png");
        cards.add("/img/blackjack/2H.png");
        cards.add("/img/blackjack/3H.png");
        cards.add("/img/blackjack/4H.png");
        cards.add("/img/blackjack/5H.png");
        cards.add("/img/blackjack/6H.png");
        cards.add("/img/blackjack/7H.png");
        cards.add("/img/blackjack/8H.png");
        cards.add("/img/blackjack/9H.png");
        cards.add("/img/blackjack/10H.png");
        cards.add("/img/blackjack/JH.png");
        cards.add("/img/blackjack/QH.png");
        cards.add("/img/blackjack/KH.png");
        cards.add("/img/blackjack/AH.png");
        cards.add("/img/blackjack/2S.png");
        cards.add("/img/blackjack/3S.png");
        cards.add("/img/blackjack/4S.png");
        cards.add("/img/blackjack/5S.png");
        cards.add("/img/blackjack/6S.png");
        cards.add("/img/blackjack/7S.png");
        cards.add("/img/blackjack/8S.png");
        cards.add("/img/blackjack/9S.png");
        cards.add("/img/blackjack/10S.png");
        cards.add("/img/blackjack/JS.png");
        cards.add("/img/blackjack/QS.png");
        cards.add("/img/blackjack/KS.png");
        cards.add("/img/blackjack/AS.png");
    }
    
    private int getWert(String s){      //Kartenwert suchen
        switch(s){
            case "/img/blackjack/2C.png":
                return 2;
            case "/img/blackjack/3C.png":
                return 3;
            case "/img/blackjack/4C.png":
                return 4;
            case "/img/blackjack/5C.png":
                return 5;
            case "/img/blackjack/6C.png":
                return 6;
            case "/img/blackjack/7C.png":
                return 7;
            case "/img/blackjack/8C.png":
                return 8;
            case "/img/blackjack/9C.png":
                return 9;
            case "/img/blackjack/10C.png":
                return 10;
            case "/img/blackjack/JC.png":
                return 10;
            case "/img/blackjack/QC.png":
                return 10;
            case "/img/blackjack/KC.png":
                return 10;
            case "/img/blackjack/AC.png":
                return 11;
            case "/img/blackjack/2D.png":
                return 2;
            case "/img/blackjack/3D.png":
                return 3;
            case "/img/blackjack/4D.png":
                return 4;
            case "/img/blackjack/5D.png":
                return 5;
            case "/img/blackjack/6D.png":
                return 6;
            case "/img/blackjack/7D.png":
                return 7;
            case "/img/blackjack/8D.png":
                return 8;
            case "/img/blackjack/9D.png":
                return 9;
            case "/img/blackjack/10D.png":
                return 10;
            case "/img/blackjack/JD.png":
                return 10;
            case "/img/blackjack/QD.png":
                return 10;
            case "/img/blackjack/KD.png":
                return 10;
            case "/img/blackjack/AD.png":
                return 11;
            case "/img/blackjack/2H.png":
                return 2;
            case "/img/blackjack/3H.png":
                return 3;
            case "/img/blackjack/4H.png":
                return 4;
            case "/img/blackjack/5H.png":
                return 5;
            case "/img/blackjack/6H.png":
                return 6;
            case "/img/blackjack/7H.png":
                return 7;
            case "/img/blackjack/8H.png":
                return 8;
            case "/img/blackjack/9H.png":
                return 9;
            case "/img/blackjack/10H.png":
                return 10;
            case "/img/blackjack/JH.png":
                return 10;
            case "/img/blackjack/QH.png":
                return 10;
            case "/img/blackjack/KH.png":
                return 10;
            case "/img/blackjack/AH.png":
                return 11;
            case "/img/blackjack/2S.png":
                return 2;
            case "/img/blackjack/3S.png":
                return 3;
            case "/img/blackjack/4S.png":
                return 4;
            case "/img/blackjack/5S.png":
                return 5;
            case "/img/blackjack/6S.png":
                return 6;
            case "/img/blackjack/7S.png":
                return 7;
            case "/img/blackjack/8S.png":
                return 8;
            case "/img/blackjack/9S.png":
                return 9;
            case "/img/blackjack/10S.png":
                return 10;
            case "/img/blackjack/JS.png":
                return 10;
            case "/img/blackjack/QS.png":
                return 10;
            case "/img/blackjack/KS.png":
                return 10;
            case "/img/blackjack/AS.png":
                return 11;
        }
        return 0;
    }
    
    private void reset(){                   //Spiel zurücksetzen
        spieKarte1.setGraphic(null);
        spieKarte2.setGraphic(null);
        spieKarte3.setGraphic(null);
        spieKarte4.setGraphic(null);
        spieKarte5.setGraphic(null);
        spieKarte6.setGraphic(null);
        spieKarte7.setGraphic(null);
        grouKarte1.setGraphic(null);
        grouKarte2.setGraphic(null);
        grouKarte3.setGraphic(null);
        grouKarte4.setGraphic(null);
        grouKarte5.setGraphic(null);
        grouKarte6.setGraphic(null);
        grouKarte7.setGraphic(null);
        doubleable = false;
        versicherbar = false;
        einsatz = 0;
        gewinn = 0;
        versichert = 0;
        playerValue = 0;
        groupierValue = 0;
        splitValue = 0;
        gewinnLabel.setText("Gewinn:");
        cards.clear();
        kartenHinzufügen();
        started = false;
        finished = false;
        versichernButton.setStyle("-fx-text-fill: black");
        verdoppelnButton.setStyle("-fx-text-fill: black");
        spieKartenNummer = 3;
        resultLabel.setText("");
        spieSwitch1 = false;
        spieSwitch2 = false;
        spieSwitch3 = false;
        spieSwitch4 = false;
        spieSwitch5 = false;
        spieSwitch6 = false;
        spieSwitch7 = false;
        grouSwitch1 = false;
        grouSwitch2 = false;
        grouSwitch3 = false;
        grouSwitch4 = false;
        grouSwitch5 = false;
        grouSwitch6 = false;
        grouSwitch7 = false;
        versichertButton = false;
        ersteGrouKarte = 0;
        zweiteGrouKarte = "";
        ersteSpieKarte = 0;
        zweiteSpieKarte = 0;
        doubled = false;
        bestaetigtVersichern = false;
        versichertLabel.setText("Versichert: " + versichert);
    }
    
    private void spieSwitchCheck(){                                 //Überprüfen für Wertänderung von Ass
        if(playerValue > 21 && spieSwitch1 == true){
            playerValue = playerValue - 10;
            spieSwitch1 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
        if(playerValue > 21 && spieSwitch2 == true){
            playerValue = playerValue -10;
            spieSwitch2 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
        if(playerValue > 21 && spieSwitch3 == true){
            playerValue = playerValue -10;
            spieSwitch3 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
        if(playerValue > 21 && spieSwitch4 == true){
            playerValue = playerValue -10;
            spieSwitch4 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
        if(playerValue > 21 && spieSwitch5 == true){
            playerValue = playerValue -10;
            spieSwitch5 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
        if(playerValue > 21 && spieSwitch6 == true){
            playerValue = playerValue -10;
            spieSwitch6 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
        if(playerValue > 21 && spieSwitch7 == true){
            playerValue = playerValue -10;
            spieSwitch7 = false;
            geWertSpie.setText("Wert: " + Integer.toString(playerValue));
        }
    }
    
    private void grouSwitchCheck(){
        if(groupierValue > 21 && grouSwitch1 == true){
            groupierValue = groupierValue - 10;
            grouSwitch1 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
        if(groupierValue > 21 && grouSwitch2 == true){
            groupierValue = groupierValue - 10;
            grouSwitch2 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
        if(groupierValue > 21 && grouSwitch3 == true){
            groupierValue = groupierValue - 10;
            grouSwitch3 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
        if(groupierValue > 21 && grouSwitch4 == true){
            groupierValue = groupierValue - 10;
            grouSwitch4 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
        if(groupierValue > 21 && grouSwitch5 == true){
            groupierValue = groupierValue - 10;
            grouSwitch5 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
        if(groupierValue > 21 && grouSwitch6 == true){
            groupierValue = groupierValue - 10;
            grouSwitch6 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
        if(groupierValue > 21 && grouSwitch7 == true){
            groupierValue = groupierValue - 10;
            grouSwitch7 = false;
            geWertGrou.setText("Wert: " + Integer.toString(playerValue));
        }
    }
    
    public void setName(String name){
        FXMLSpielController.name = name;
    }
}
