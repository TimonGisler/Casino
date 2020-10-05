package slotmachine;

import Casino.DBController;
import Casino.EinlogController;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    private Label label;
    @FXML
    private AnchorPane upper_display;
    @FXML
    private VBox cherry_scale;
    @FXML
    private VBox factor;
    @FXML
    private AnchorPane pentagon;
    @FXML
    private VBox output;
    @FXML
    private AnchorPane lower_display;
    @FXML
    private VBox drum;
    @FXML
    private HBox drums;
    @FXML
    private HBox hold_step;
    @FXML
    private Label hold;
    @FXML
    private Label step;
    @FXML
    private VBox wintable;
    @FXML
    private HBox buttons;
    @FXML
    private Button mysterie;
    @FXML
    private Button bet;
    @FXML
    private Button money;
    @FXML
    private Button gamble;
    @FXML
    private Button stop;
    @FXML
    private Label output_up;
    @FXML
    private Label output_down;
    @FXML
    private Button back;

    Image bell = new Image("/styles/pictures/bell.png");
    Image cherry = new Image("/styles/pictures/cherry.png");
    Image grapes = new Image("/styles/pictures/grape.png");
    Image kleeblatt = new Image("/styles/pictures/kleeblatt.png");
    Image lemon = new Image("/styles/pictures/lemon.png");
    Image melon = new Image("/styles/pictures/melon.png");
    Image orange = new Image("/styles/pictures/orange.png");
    Image seven = new Image("/styles/pictures/seven.png");
    Image star = new Image("/styles/pictures/star.png");

    ArrayList<Integer> drum1 = new ArrayList<>();
    ArrayList<Integer> drum2 = new ArrayList<>();
    ArrayList<Integer> drum3 = new ArrayList<>();

    CherryModel cherryModel = new CherryModel();
    MOCK mock = new MOCK();

    Random r = new Random();

    @FXML
    private ImageView imgView1_1;
    @FXML
    private ImageView imgView1_2;
    @FXML
    private ImageView imgView1_3;
    @FXML
    private ImageView imgView2_1;
    @FXML
    private ImageView imgView2_2;
    @FXML
    private ImageView imgView2_3;
    @FXML
    private ImageView imgView3_1;
    @FXML
    private ImageView imgView3_2;
    @FXML
    private ImageView imgView3_3;
    @FXML
    private ImageView imgView4;
    @FXML
    private HBox UserInfo;
    @FXML
    private Label lblName;
    @FXML
    private Label lblMoney;
    @FXML
    private HBox moneyHBox;
    @FXML
    private VBox plusAndMinus;
    @FXML
    private Button plus;
    @FXML
    private Button minus;

    int one = 0;
    int two = 0;
    int three = 0;
    @FXML
    private VBox vbox_drum1;
    @FXML
    private VBox vbox_drum2;
    @FXML
    private VBox vbox_drum3;
    @FXML
    private VBox vbox_drum4;
    @FXML
    private Label fiveX;
    @FXML
    private Label threeX;
    @FXML
    private Label twoX;
    @FXML
    private Label zeroX;
    @FXML
    private Label winX;

    DBController d = null;

    static String name;
    @FXML
    private AnchorPane pa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    private void start(ActionEvent event) throws SQLException {

        //Reset colors
        zeroX.setStyle("-fx-background-color: #03658C");
        twoX.setStyle("-fx-background-color: #03658C");
        threeX.setStyle("-fx-background-color: #03658C");
        fiveX.setStyle("-fx-background-color: #03658C");

        hold.setStyle("-fx-background-color:  #380580");
        step.setStyle("-fx-background-color:  #380580");

        //Reset safed money
        cherryModel.setSafe(new BigDecimal("0"));

        //Reset colors
        vbox_drum1.setStyle("-fx-background-color: white");
        vbox_drum2.setStyle("-fx-background-color: white");
        vbox_drum3.setStyle("-fx-background-color: white");
        vbox_drum4.setStyle("-fx-background-color: white");

        //Check if Money is payed in
        if (cherryModel.getPaiedIn().compareTo(new BigDecimal("0")) == 0 || d.getKonto(name) - 50 <= 0) {
            output_up.setText("YOU HAVENT PAID IN ANY MONEY");
        } else {

            //Checks if user has hold or step, if not every drum get spun.
            if (cherryModel.isHold()) {

                //decides which drum to spin
                switch (cherryModel.whichDrumDifferent(one, two, three)) {
                    case 1:
                        drum1 = cherryModel.getOneDrum();
                        one = drum1.get(1);
                        setImage(imgView1_1, drum1, 0);
                        setImage(imgView1_2, drum1, 1);
                        setImage(imgView1_3, drum1, 2);
                        break;

                    case 2:
                        drum2 = cherryModel.getOneDrum();
                        two = drum2.get(1);
                        setImage(imgView2_1, drum2, 0);
                        setImage(imgView2_2, drum2, 1);
                        setImage(imgView2_3, drum2, 2);
                        break;

                    case 3:
                        drum3 = cherryModel.getOneDrum();
                        three = drum3.get(1);
                        setImage(imgView3_1, drum3, 0);
                        setImage(imgView3_2, drum3, 1);
                        setImage(imgView3_3, drum3, 2);
                        break;

                    default:
                        throw new AssertionError();
                }

            } else if (cherryModel.isStep()) {

                //Sometimes it rotates threw the entire list and has to start from the beginning
                //to avoid the nullPointer exception it just adds to itself
                //if the list was 123 the avoidNullPointer list is 123123
                ArrayList<Integer> avoidNullPointer = new ArrayList<>();

                //decides which drum to spin
                switch (cherryModel.whichDrumDifferent(one, two, three)) {
                    case 1:
                        //resets list
                        avoidNullPointer.clear();

                        avoidNullPointer.addAll(drum1);
                        avoidNullPointer.addAll(drum1);

                        //Go throught every picture until the correct one, or a cherry is found.
                        for (int i = 1; i <= 9; i++) {

                            one = avoidNullPointer.get(1 + i);
                            setImage(imgView1_1, avoidNullPointer, 0 + i);
                            setImage(imgView1_2, avoidNullPointer, 1 + i);
                            setImage(imgView1_3, avoidNullPointer, 2 + i);

                            if (cherryModel.checkIfWon(one, two, three)) {
                                System.out.println("should break");
                                i = 10;
                            }
                        }
                        break;
                    case 2:
                        avoidNullPointer.clear();
                        avoidNullPointer.addAll(drum2);
                        avoidNullPointer.addAll(drum2);

                        //Go throught every picture until the correct one, or a cherry is found.
                        for (int i = 1; i <= 9; i++) {
                            two = avoidNullPointer.get(1 + i);
                            setImage(imgView2_1, avoidNullPointer, 0 + i);
                            setImage(imgView2_2, avoidNullPointer, 1 + i);
                            setImage(imgView2_3, avoidNullPointer, 2 + i);

                            if (cherryModel.checkIfWon(one, two, three)) {
                                System.out.println("should break");
                                i = 10;
                            }
                        }
                        break;
                    case 3:
                        avoidNullPointer.clear();
                        avoidNullPointer.addAll(drum3);
                        avoidNullPointer.addAll(drum3);

                        //Go throught every picture until the correct one, or a cherry is found.
                        for (int i = 1; i <= 9; i++) {
                            three = avoidNullPointer.get(1 + i);
                            setImage(imgView3_1, avoidNullPointer, 0 + i);
                            setImage(imgView3_2, avoidNullPointer, 1 + i);
                            setImage(imgView3_3, avoidNullPointer, 2 + i);

                            System.out.println(i);

                            if (cherryModel.checkIfWon(one, two, three)) {
                                System.out.println("should break");
                                i = 10;
                            }
                        }
                        break;
                }

            } else {
                //Rotate all Drums
                drum1 = cherryModel.getOneDrum();
                one = drum1.get(1);
                setImage(imgView1_1, drum1, 0);
                setImage(imgView1_2, drum1, 1);
                setImage(imgView1_3, drum1, 2);

                drum2 = cherryModel.getOneDrum();
                two = drum2.get(1);
                setImage(imgView2_1, drum2, 0);
                setImage(imgView2_2, drum2, 1);
                setImage(imgView2_3, drum2, 2);

                drum3 = cherryModel.getOneDrum();
                three = drum3.get(1);
                setImage(imgView3_1, drum3, 0);
                setImage(imgView3_2, drum3, 1);
                setImage(imgView3_3, drum3, 2);
            }

            //If the user won, his money gets multiplied and he gets the chance to use bet, gamble and mysterie
            if (cherryModel.checkIfWon(one, two, three)) {

//                if (cherryModel.whatIsReward(cherryModel.checkWhatWon(one, one, one)).compareTo(new BigDecimal("99")) == 0) {
//                    //3 Star code
                cherryModel.multiplyPaiedIn(cherryModel.whatIsReward(cherryModel.checkWhatWon(one, two, three)));
                output_down.setText("You risk: " + cherryModel.getPaiedIn());
                System.out.println("SET MONEY");

                output_up.setText("YOU WON");

                //Hold and step gets resetet
                cherryModel.setHold(false);
                cherryModel.setStep(false);
                //Wenn letzte Runde nicht Hold und Step gegeben wurde und diese Runde 2 gleich sind wird entweder Hold oder Step freigeschalten
            } else if (!cherryModel.isHold() && !cherryModel.isHold()) {
                cherryModel.checkIfTwo(one, two, three);

                //Color Hold or Step to see which won
                if (cherryModel.isHold()) {
                    hold.setStyle("-fx-background-color: yellow");
                } else if (cherryModel.isStep()) {
                    step.setStyle("-fx-background-color: yellow");
                }
                cherryModel.setPaiedIn(new BigDecimal("0"));

                update("Leider nichts");
                //If last the user had last Round hold or step, but didnt win he gets a bonus.
            } else {
                cherryModel.setHold(false);
                cherryModel.setStep(false);

                //Give Bonus
                System.out.println("background change");
                bonus(r.nextInt(4) + 1);
                BigDecimal bonus = cherryModel.bonus();

                cherryModel.setPaiedIn(new BigDecimal("0"));

                //Pay Bonus in
                cherryModel.payIn(bonus);
                update("Your bonus: " + bonus);
            }

        }

    }

    public void setImage(ImageView imgv, ArrayList<Integer> pictureOrder, int pictureNR) {
        switch (pictureOrder.get(pictureNR)) {

            case 0:
                imgv.setImage(bell);
                break;

            case 1:
                imgv.setImage(cherry);
                break;

            case 2:
                imgv.setImage(grapes);
                break;

            case 3:
                imgv.setImage(kleeblatt);
                break;

            case 4:
                imgv.setImage(lemon);
                break;

            case 5:
                imgv.setImage(melon);
                break;

            case 6:
                imgv.setImage(orange);
                break;

            case 7:
                imgv.setImage(seven);
                break;

            case 8:
                imgv.setImage(star);
                break;

            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void payIn(ActionEvent event) throws SQLException {
        if (d.getKonto(name) - cherryModel.getPayInAmount().intValue() >= 0) {
            //Check how much money to payIn
            int amount = cherryModel.getPayInAmount().intValue();

            //take money from account away
            d.updateKontoHome(-amount, name);

            //pay In Money
            cherryModel.payIn(cherryModel.getPayInAmount());

            output_up.setText("You have:" + cherryModel.getPaiedIn());

            lblMoney.setText("" + d.getKonto(name));
        } else {
        }

    }

    public void bonus(int drumToStop) {

        //decide by which drum the animation should stop
        switch (drumToStop) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    vbox_drum1.setStyle("-fx-background-color: yellow");
                    vbox_drum1.setStyle("-fx-background-color: white");

                    vbox_drum2.setStyle("-fx-background-color: yellow");
                    vbox_drum2.setStyle("-fx-background-color: white");

                    vbox_drum3.setStyle("-fx-background-color: yellow");
                    vbox_drum3.setStyle("-fx-background-color: white");

                    vbox_drum4.setStyle("-fx-background-color: yellow");
                    vbox_drum4.setStyle("-fx-background-color: white");

                    vbox_drum1.setStyle("-fx-background-color: yellow");

                    vbox_drum2.setStyle("-fx-border-color: black");
                    vbox_drum3.setStyle("-fx-border-color: black");
                    vbox_drum4.setStyle("-fx-border-color: black");
                }

                break;

            case 2:
                for (int i = 0; i < 3; i++) {
                    vbox_drum1.setStyle("-fx-background-color: yellow");
                    vbox_drum1.setStyle("-fx-background-color: white");

                    vbox_drum2.setStyle("-fx-background-color: yellow");
                    vbox_drum2.setStyle("-fx-background-color: white");

                    vbox_drum3.setStyle("-fx-background-color: yellow");
                    vbox_drum3.setStyle("-fx-background-color: white");

                    vbox_drum4.setStyle("-fx-background-color: yellow");
                    vbox_drum4.setStyle("-fx-background-color: white");

                    vbox_drum1.setStyle("-fx-background-color: yellow");
                    vbox_drum1.setStyle("-fx-background-color: white");

                    vbox_drum2.setStyle("-fx-background-color: yellow");

                    vbox_drum1.setStyle("-fx-border-color: black");
                    vbox_drum3.setStyle("-fx-border-color: black");
                    vbox_drum4.setStyle("-fx-border-color: black");

                }

                break;

            case 3:
                for (int i = 0; i < 3; i++) {
                    vbox_drum1.setStyle("-fx-background-color: yellow");
                    vbox_drum1.setStyle("-fx-background-color: white");

                    vbox_drum2.setStyle("-fx-background-color: yellow");
                    vbox_drum2.setStyle("-fx-background-color: white");

                    vbox_drum3.setStyle("-fx-background-color: yellow");
                    vbox_drum3.setStyle("-fx-background-color: white");

                    vbox_drum4.setStyle("-fx-background-color: yellow");
                    vbox_drum4.setStyle("-fx-background-color: white");

                    vbox_drum1.setStyle("-fx-background-color: yellow");
                    vbox_drum1.setStyle("-fx-background-color: white");

                    vbox_drum2.setStyle("-fx-background-color: yellow");
                    vbox_drum2.setStyle("-fx-background-color: white");

                    vbox_drum3.setStyle("-fx-background-color: yellow");

                    vbox_drum1.setStyle("-fx-border-color: black");
                    vbox_drum2.setStyle("-fx-border-color: black");
                    vbox_drum4.setStyle("-fx-border-color: black");
                }

                break;

            case 4:
                for (int i = 0; i < 3; i++) {
                    vbox_drum1.setStyle("-fx-background-color: yellow");
                    vbox_drum1.setStyle("-fx-background-color: white");

                    vbox_drum2.setStyle("-fx-background-color: yellow");
                    vbox_drum2.setStyle("-fx-background-color: white");

                    vbox_drum3.setStyle("-fx-background-color: yellow");
                    vbox_drum3.setStyle("-fx-background-color: white");

                    vbox_drum4.setStyle("-fx-background-color: yellow");

                    vbox_drum1.setStyle("-fx-border-color: black");
                    vbox_drum2.setStyle("-fx-border-color: black");
                    vbox_drum3.setStyle("-fx-border-color: black");
                }

                break;
            default:
                throw new AssertionError();
        }

    }

    public void update(String output_d) throws SQLException {
        if (output_d.equals("clone")) {
            output_d = output_down.getText();
        }

        output_up.setText("You have: " + cherryModel.getPaiedIn());
        output_down.setText(output_d);
        lblMoney.setText("" + d.getKonto(name));
    }

    @FXML
    private void bet(ActionEvent event) throws SQLException {
        //The user can only use bet when he won the game
        if (cherryModel.checkIfWon(one, two, three)) {
            cherryModel.safe();
            update("You risk: " + cherryModel.paiedIn.subtract(cherryModel.safe) + " You safe: " + cherryModel.safe);
        }
    }

    @FXML
    private void gamble(ActionEvent event) throws SQLException {

        //The user can only use gamble when he won the game
        if (cherryModel.checkIfWon(one, two, three)) {
            //Animation
            zeroX.setStyle("-fx-background-color: yellow");
            zeroX.setStyle("-fx-background-color: #03658C");
            twoX.setStyle("-fx-background-color: yellow");
            twoX.setStyle("-fx-background-color: #03658C");

            //decide by which label to stop
            switch (r.nextInt(2)) {
                case 0:
                    zeroX.setStyle("-fx-background-color: yellow");
                    cherryModel.setPaiedIn(new BigDecimal("0"));
                    update("You have lost the Gamble.");
                    break;

                case 1:
                    if (cherryModel.getPaiedIn().compareTo(new BigDecimal("0")) == 0) {
                        update("You cant gamble anymore");
                    } else {
                        twoX.setStyle("-fx-background-color: yellow");
                        cherryModel.gambleWon();
                        update("You have won the Gamble!");
                    }

                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    @FXML
    private void mysterie(ActionEvent event) throws SQLException {
        //Mysterie can only be used if you won last round
        if (cherryModel.checkIfWon(one, two, three)) {
            //Animation
            zeroX.setStyle("-fx-background-color: yellow");
            zeroX.setStyle("-fx-background-color: #03658C");
            twoX.setStyle("-fx-background-color: yellow");
            twoX.setStyle("-fx-background-color: #03658C");
            threeX.setStyle("-fx-background-color: yellow");
            threeX.setStyle("-fx-background-color: #03658C");
            fiveX.setStyle("-fx-background-color: yellow");
            fiveX.setStyle("-fx-background-color: #03658C");

            //Decide which option won 0x, 2x, 3x, 5x
            int switchCase = r.nextInt(4);
            switch (switchCase) {
                case 0:
                    if (cherryModel.getPaiedIn().compareTo(new BigDecimal("0")) == 0) {
                        update("You cant use Mysterie anymore");
                    } else {
                        zeroX.setStyle("-fx-background-color: yellow");
                        cherryModel.setPaiedIn(new BigDecimal("0"));
                        update("You have lost the Mysterie!");
                    }
                    break;

                case 1:
                    if (cherryModel.getPaiedIn().compareTo(new BigDecimal("0")) == 0) {
                        update("You cant use Mysterie anymore");
                    } else {
                        twoX.setStyle("-fx-background-color: yellow");
                        cherryModel.mysterieWon(new BigDecimal("5"));
                        update("You have won the Mysterie!");

                        System.out.println("MYSTERIE WON 2x");
                    }
                    break;

                case 2:
                    if (cherryModel.getPaiedIn().compareTo(new BigDecimal("0")) == 0) {
                        update("You cant use Mysterie anymore");
                    } else {
                        threeX.setStyle("-fx-background-color: yellow");
                        cherryModel.mysterieWon(new BigDecimal("5"));
                        update("You have won the Mysterie!");

                        System.out.println("MYSTERIE WON 3x");
                    }
                    break;

                case 3:
                    if (cherryModel.getPaiedIn().compareTo(new BigDecimal("0")) == 0) {
                        update("You cant use Mysterie anymore");
                    } else {
                        fiveX.setStyle("-fx-background-color: yellow");
                        cherryModel.mysterieWon(new BigDecimal("5"));
                        update("You have won the Mysterie!");

                        System.out.println("MYSTERIE WON 5x");
                    }

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @FXML
    private void add(ActionEvent event) throws SQLException {
        if (cherryModel.getPayInAmount().intValue() + 50 - d.getKonto(name) <= 0) {
            cherryModel.addPayInAmount(new BigDecimal("50"));
            money.setText("Pay In: " + cherryModel.getPayInAmount());
        } else {


        }
    }

    @FXML
    private void sub(ActionEvent event) {
        cherryModel.subPayInAmount(new BigDecimal("50"));
        money.setText("Pay In: " + cherryModel.getPayInAmount());
    }

    public void setName(String name) {
        FXMLController.name = name;
    }

    @FXML
    private void mouseMoved(MouseEvent event) throws SQLException {
        lblMoney.setText("" + d.getKonto(name));
        lblName.setText(name);
    }

    @FXML
    private void payOut(ActionEvent event) throws SQLException {
        d.updateKontoHome(cherryModel.getPaiedIn().intValue(), name);
        cherryModel.setPaiedIn(new BigDecimal("0"));
        update("clone");
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        try{
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Home.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.setResizable(false);
           stage.setWidth(1500);
           stage.setHeight(900);
           stage.show();
           
            Stage stageclose = (Stage) back.getScene().getWindow();
            stageclose.close();
       }
       catch(IOException e)
       {
           System.err.println(e.getMessage());
       }
    }

}
