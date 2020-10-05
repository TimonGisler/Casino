/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino;

import BlackJack.FXMLSpielController;
import SicBo.SicBoMenuController;
import SicBo.SicBoSpielController;
import Yatzy.FXMLUebersichtYatzyController;
import Yatzy.FXMLYatzySpielController;
import com.mycompany.roulette.SpielseiteView;
import com.mycompany.roulette.UebersichtsseiteView;
import slotmachine.FXMLController;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class LoginController implements Initializable {

    @FXML
    public TextField name;
    @FXML
    public PasswordField pass;
    @FXML
    private Button btnZuruck;
    @FXML
    private Button btnLogin;
    @FXML
    private AnchorPane APLogin;

    DBController d = null;

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

    @FXML
    private void name(ActionEvent event) {
    }

    @FXML
    private void pass(ActionEvent event) {
    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        String username = name.getText();
        String password = pass.getText();
        try {
            d = new DBController();
            if (d.getUser(username) == true) {
                if (d.getPasswort(password) == true) {

                    SicBoSpielController controller = new SicBoSpielController();
                    HomeController hc = new HomeController();
                    SicBoMenuController sbmc = new SicBoMenuController();
                    FXMLController slotMachineController = new FXMLController();
                    slotMachineController.setName(username);
                    controller.setName(username);
                    hc.setName(username);
                    sbmc.setName(username);
                    FXMLSpielController blackJackController = new FXMLSpielController();
                    blackJackController.setName(username);
                    FXMLUebersichtYatzyController sbmcYatzy = new FXMLUebersichtYatzyController();
                    FXMLYatzySpielController controllerYatzy = new FXMLYatzySpielController();
                    controllerYatzy.setName(username);
                    sbmcYatzy.setName(username);
                    SpielseiteView spv = new SpielseiteView();
                    spv.setName(username);
                    UebersichtsseiteView us = new UebersichtsseiteView();
                    us.setName(username);

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root1));
                        stage.setResizable(false);
                        stage.setWidth(1500);
                        stage.setHeight(900);
                        stage.show();

                        Stage stageclose = (Stage) btnLogin.getScene().getWindow();
                        stageclose.close();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sie haben das falsche Passwort eingegeben");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Der eingegebene Benutzername existiert nicht");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EinlogController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnZuruck(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Einlog.fxml"));
        APLogin.getChildren().setAll(pane);
    }

}
