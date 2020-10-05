package Casino;

import com.mycompany.roulette.Modell;
import com.mycompany.roulette.SpielseiteView;
import com.mycompany.roulette.UebersichtsseiteView;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    Stage temp;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Einlog.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
    }
    
//    public Stage getTemp() {
//        return temp;
//    }
//    
//    public void wechsleFenster(Stage stage, String url, String title) throws Exception {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
//        Parent root;
//        root = loader.load();
//        Modell modell = new Modell(this);
//
//        if (title.equals("Übersichtsseite")) {
//            UebersichtsseiteView view = loader.getController();
//            modell.addPropertyChangeListener(view);
//            view.setModell(modell);
//        } else {
//            SpielseiteView view = loader.getController();
//            modell.addPropertyChangeListener(view);
//            view.setModell(modell);
//            view.bind();
//        }
//        Scene scene = new Scene(root);
//        stage.resizableProperty().setValue(Boolean.FALSE);
//
//        stage.setTitle("JavaFX and Maven");
//        stage.setScene(scene);
//        //stage.initStyle(StageStyle.UNDECORATED);
//        stage.show();
//    }
}
