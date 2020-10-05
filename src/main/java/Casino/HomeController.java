/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnBlackJack;
    @FXML
    private Button btnRoulette;
    @FXML
    private Button btnSicBo;
    @FXML
    private Button btnSlot;
    @FXML
    private Button btnYatzy;
    @FXML
    private Label kontostand;
    @FXML
    private Button btn10;
    @FXML
    private Button btn20;
    @FXML
    private Button btn50;
    @FXML
    private Button btn100;
    @FXML
    private Button btn500;
    @FXML
    private Button btnEinlosen;
    @FXML
    private Button btnZuruck;
    @FXML
    private AnchorPane apHome;

    static String name;

    DBController d = null;
    int betrag;
    @FXML
    private Label aktBetrag;

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
            d = new DBController();
        } catch (SQLException ex) {
            Logger.getLogger(EinlogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (d.createConnection() != null) {
            System.out.println("Verbindung aufgebaut");
        }
    }

    public void setName(String name) {
        HomeController.name = name;
    }

    @FXML
    private void btnBlackJack(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLDocument.fxml"));
        apHome.getChildren().setAll(pane);
    }

    @FXML
    private void btnRoulette(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Uebersichtsseite.fxml"));
        apHome.getChildren().setAll(pane);
    }

    @FXML
    private void btnSicBo(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/SicBoMenu.fxml"));
        apHome.getChildren().setAll(pane);
    }

    @FXML
    private void btnSlot(ActionEvent event) throws IOException {
        try{
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.setResizable(false);
           stage.show();
           
            Stage stageclose = (Stage) btnSlot.getScene().getWindow();
            stageclose.close();
       }
       catch(IOException e)
       {
           System.err.println(e.getMessage());
       }
    }

    @FXML
    private void btnYatzy(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/FXMLUebersichtYatzy.fxml"));
        apHome.getChildren().setAll(pane);
    }

    @FXML
    private void btnEinlosen(ActionEvent event) throws SQLException {
        d.updateKontoHome(betrag, name);
        kontostand.setText("" + d.getKonto(name));
        aktBetrag.setText("0");
        betrag = 0;
    }

    @FXML
    private void btnZuruck(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Einlog.fxml"));
        apHome.getChildren().setAll(pane);
    }

    @FXML
    private void btn10(ActionEvent event) {

        betrag += 10;
        aktBetrag.setText("" + betrag);

    }

    @FXML
    private void btn20(ActionEvent event) {

        betrag += 20;
        aktBetrag.setText("" + betrag);

    }

    @FXML
    private void btn50(ActionEvent event) {

        betrag += 50;
        aktBetrag.setText("" + betrag);

    }

    @FXML
    private void btn100(ActionEvent event) {

        betrag += 100;
        aktBetrag.setText("" + betrag);
    }

    @FXML
    private void btn500(ActionEvent event) {

        betrag += 500;
        aktBetrag.setText("" + betrag);

    }

    @FXML
    private void Konto(MouseEvent event) throws SQLException {
        kontostand.setText("" + d.getKonto(name));
    }
}
