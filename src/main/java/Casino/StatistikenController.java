/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino;

import SicBo.SicBoSpielController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author micha
 */
public class StatistikenController implements Initializable {

    @FXML
    private TableView<Statistics> tblStatistic;
    @FXML
    private TableColumn<Statistics, String> name;
    @FXML
    private TableColumn<Statistics, Integer> gewonnen;
    @FXML
    private TableColumn<Statistics, Integer> verloren;
    @FXML
    private TableColumn<Statistics, Integer> einsatz;
    @FXML
    private Button btnZuruck;
    @FXML
    private AnchorPane apHome;

    DBController db = null;

//    private final ObservableList<Statistics> data = FXCollections.observableArrayList(new Satistics("Michal", "Gar", "son", "5"));
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
            db = new DBController();
        } catch (SQLException ex) {
            Logger.getLogger(SicBoSpielController.class.getName()).log(Level.SEVERE, null, ex);
        }

        name.setCellValueFactory(new PropertyValueFactory<Statistics, String>("name"));
        verloren.setCellValueFactory(new PropertyValueFactory<Statistics, Integer>("verloren"));
        gewonnen.setCellValueFactory(new PropertyValueFactory<Statistics, Integer>("gewonnen"));
        einsatz.setCellValueFactory(new PropertyValueFactory<Statistics, Integer>("einsatz"));

        for (int i = 0; i < db.getNamen().size(); i++) {
            for (int o = 0; o < db.getWon().size(); o++) {
                for (int p = 0; p < db.getLost().size(); p++) {
                    for (int c = 0; c < db.getEinsatz().size(); c++) {
                        SimpleStringProperty n = (SimpleStringProperty) db.getNamen().get(i);
                        SimpleIntegerProperty w = (SimpleIntegerProperty) db.getWon().get(o);
                        SimpleIntegerProperty l = (SimpleIntegerProperty) db.getLost().get(p);
                        SimpleIntegerProperty e = (SimpleIntegerProperty) db.getEinsatz().get(c);
                        Statistics stat = new Statistics(n, l, w, e);

                        tblStatistic.getItems().add(stat);
                        System.out.println("" + n + " " + w + " " + l + " " + e + " ");
                    }
                }
            }
        }
    }

    @FXML
    private void btnZuruck(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
        apHome.getChildren().setAll(pane);
    }

}
