import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afterLogin extends JPanel {
    static JTextField incomeField = new JTextField();
    static JLabel label = new JLabel();
    static JButton addMoney = new JButton(), substractMoney = new JButton(), logOut = new JButton();
    static double income = 0.0;

    afterLogin(){
        this.setLayout(null);

        this.add(label);
        this.add(incomeField);
        this.add(addMoney);
        this.add(substractMoney);
        this.add(logOut);

        menu();
        logout();
    }

    public static void menu(){ // lägga till pengar eller ta bort pengar
        label.setBounds(350, 160, 200, 23);
        label.setText("Income:");
        label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        incomeField.setBounds(350, 200, 200, 23);
        incomeField.setText(Double.toString(income));
        incomeField.setHorizontalAlignment(SwingConstants.CENTER);
        incomeField.setEditable(false);

        addMoney.setBounds(250, 250, 150, 30);
        addMoney.setText("Insert money");
        addMoney.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        addMoney.setVerticalAlignment(SwingConstants.CENTER);
        addMoney.setHorizontalAlignment(SwingConstants.CENTER);
        addMoney.setBackground(Color.green);
        addMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.insert); // tar användaren till panelen där det läggs till pengar
            }
        });

        substractMoney.setBounds(490, 250, 150, 30);
        substractMoney.setText("Extract money");
        substractMoney.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        substractMoney.setVerticalAlignment(SwingConstants.CENTER);
        substractMoney.setHorizontalAlignment(SwingConstants.CENTER);
        substractMoney.setBackground(Color.red);
        substractMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.extract); // tar användaren till panelen där det tas bort pengar
            }
        });
    }

    public static void logout() {
        logOut.setBounds(0, 0, 100, 20);
        logOut.setText("Logout");
        logOut.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        logOut.setVerticalAlignment(SwingConstants.CENTER);
        logOut.setHorizontalAlignment(SwingConstants.CENTER);
        logOut.setBackground(Color.red);

        logOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.menu); // tar tillbaka till start menyn
            }
        });
    }
}
