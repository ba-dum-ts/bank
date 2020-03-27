import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MAIN {
    static JFrame frame = new JFrame();
    static JPanel oldPanel = new JPanel();
    static startMenu menu = new startMenu();
    static createAccount account = new createAccount();
    static afterLogin login = new afterLogin();
    static insertMoney insert = new insertMoney();
    static extractMoney extract = new extractMoney();
    static List<String[]> accounts = new ArrayList <String[]>();

    public static void main(String args[]){ // här finns basen ur allt. Alltså, ramen samt första panel.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 550);
        frame.setLocationRelativeTo(null);
        frame.add(menu);
        oldPanel = menu;

        createAccount.addAccount("admin", "admin"); // förbered konto så att man inte behöver skapa en

        frame.validate(); // uppdaterar position på funktioner
        frame.repaint(); // uppdaterar gui
    }

    public static void changePanel(JPanel panel){ // tar bort gamla panel och lägger till ny panel
        frame.remove(oldPanel);
        frame.add(panel);
        oldPanel = panel;

        frame.validate(); // uppdaterar position på funktioner
        frame.repaint(); // uppdaterar gui
    }
}