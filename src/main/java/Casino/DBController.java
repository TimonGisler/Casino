/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino;

import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author micha
 */
public class DBController {

    private static DBController instance;
    private static Connection con;

    private static PropertyChangeSupport change;
    ArrayList<String> users = new ArrayList<>();
    ArrayList<String> pws = new ArrayList<>();

    public DBController() throws SQLException {
        change = new PropertyChangeSupport(this);

    }

    public void insert(String name, String pw) throws SQLException {
        Statement st = con.createStatement();

        try {
//            st.executeUpdate("DROP TABLE IF EXISTS Login;");
//            st.executeUpdate("DROP TABLE IF EXISTS Stats;");

            String update0 = "CREATE TABLE IF NOT EXISTS Login(gameId int AUTO_INCREMENT, Name varchar(255) not null, Password varchar(255) not null,Kontostand int, GamesWon int, GamesLost int);";
            st.executeUpdate(update0);

            PreparedStatement ps = con.prepareStatement("INSERT INTO Login(Name, Password) VALUES (?,?)");
            ps.setString(1, name);
            ps.setString(2, pw);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Das Statement konnte nicht bearbeitet werden");
        }
        
    }

    public void stats(String name, int Win, int Einsatz) throws SQLException {
        Statement st = con.createStatement();

        try {
//            st.executeUpdate("DROP TABLE IF EXISTS Stats;");

            String update0 = "CREATE TABLE IF NOT EXISTS Stats(Name varchar(255) not null, GamesWon int, GamesLost int, Einsatz int);";
            st.executeUpdate(update0);

            if (Win > Einsatz) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO Stats(Name, GamesWon, Einsatz) VALUES (?,?,?)");
                ps.setString(1, name);
                ps.setInt(2, Win);
                ps.setInt(3, Einsatz);
                ps.executeUpdate();
                getDaten();
            }

            if (Win < Einsatz) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO Stats(Name, GamesLost, Einsatz) VALUES (?,?,?)");
                ps.setString(1, name);
                ps.setInt(2, Win);
                ps.setInt(3, Einsatz);
                ps.executeUpdate();
                getDaten();
            }

        } catch (SQLException e) {
            System.err.println("Das Statement konnte nicht bearbeitet werden");
        }
    }

    public void updateKontoSicBo(int Konto, String name) throws SQLException {
        Statement st = con.createStatement();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Login SET Kontostand = ? WHERE Name LIKE ?");
            ps.setInt(1, Konto);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Das Statement konnte nicht bearbeitet werden");
        }
    }
    public void updateKontoYatzy(int kontostand, String name) throws SQLException {
        Statement st = con.createStatement();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Login SET Kontostand = ? WHERE Name LIKE ?");
            ps.setInt(1, kontostand);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Das Statement konnte nicht bearbeitet werden");
        }
    }

    public void updateKontoHome(int Konto, String name) throws SQLException {
        int Stand;
        Statement st = con.createStatement();
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE Login SET Kontostand = ? WHERE Name LIKE ?");
            Stand = getKonto(name) + Konto;
            ps.setInt(1, Stand);
            ps.setString(2, name);
            ps.executeUpdate();

//            ResultSet rs = st.executeQuery("SELECT * FROM Login");
//            while(rs.next())
//            {
//                System.out.println(rs.getString("Name")+rs.getString("Kontostand"));
//            }
        } catch (SQLException e) {
            System.err.println("Das Statement konnte nicht bearbeitet werden");
        }
    }

    public int getKonto(String name) throws SQLException {
        Statement st = con.createStatement();
        int betrag = 0;
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM Login WHERE Name LIKE '" + name + "';");
            betrag = rs.getInt("Kontostand");
        } catch (SQLException e) {

        }
        return betrag;
    }

    public static DBController getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public Connection createConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Datenbank/Casino3.db");
                System.out.println("Die Verbindung wurde erfolgreich abgeschlossen");

            } catch (SQLException ignore) {
                Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ignore);
                System.out.println("Die Verbindung konnte nicht erstellt werden");
            }
        }
        return con;
    }

    public void closeConnection() {
        try {
            con.close();
            con = null;
        } catch (SQLException e) {
            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean getUser(String name) {

        String sql = "SELECT Name FROM Login;";

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(rs.getString("Name"));
            }

            for (int x = 0; x < users.size(); x++) {
                if (users.get(x).matches(name)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(EinlogController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean getPasswort(String pw) {

        String sql = "SELECT Password FROM Login;";

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pws.add(rs.getString("Password"));
            }

            for (int x = 0; x < pws.size(); x++) {
                if (pws.get(x).matches(pw)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(EinlogController.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    ArrayList<String> namen = new ArrayList<>();
    ArrayList<Integer> won = new ArrayList<>();
    ArrayList<Integer> lost = new ArrayList<>();
    ArrayList<Integer> einsatz = new ArrayList<>();

    public void getDaten() {
        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Stats")) {
            while (rs.next()) {
                this.namen.add(rs.getString("Name"));
                this.won.add(rs.getInt("GamesWon"));
                this.lost.add(rs.getInt("GamesLost"));
                this.einsatz.add(rs.getInt("Einsatz"));
            }

            while (rs.next()) {
                System.out.println(rs.getString("Name") + rs.getString("GamesWon") + rs.getString("GamesLost") + rs.getString("Einsatz"));
            }
        } catch (SQLException e) {
            Logger.getLogger(EinlogController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Nicht bearbeitet");
        }

    }

    public ArrayList getNamen() {
        return namen;
    }

    public ArrayList getWon() {
        return won;
    }

    public ArrayList getLost() {
        return lost;
    }

    public ArrayList getEinsatz() {
        return einsatz;
    }
}
