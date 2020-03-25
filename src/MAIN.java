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
    static JLabel label = new JLabel();
    static Timer timer = new Timer(16, new refreshPanel());

    public static void main(String args[]){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 550);
        frame.setLocationRelativeTo(null);
        frame.add(menu);
        oldPanel = menu;

        label.setText(MouseInfo.getPointerInfo().getLocation().toString());
        label.setBounds(0, 0, 1000, 20);
        oldPanel.add(label);

        timer.start();

        frame.validate();
        frame.repaint();
    }

    public static void changePanel(JPanel panel){
        frame.remove(oldPanel);
        frame.add(panel);
        oldPanel = panel;

        label.setText(MouseInfo.getPointerInfo().getLocation().toString());
        label.setBounds(0, 0, 100, 20);
        oldPanel.add(label);

        frame.validate();
        frame.repaint();
    }

    static class refreshPanel implements ActionListener{
        public void actionPerformed(ActionEvent e){
            label.setText(MouseInfo.getPointerInfo().getLocation().toString());

            frame.validate();
            frame.repaint();
        }
    }
}