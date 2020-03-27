import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class extractMoney extends JPanel{
    static JTextField incomeField = new JTextField();
    static JLabel label = new JLabel();
    static boolean loop;

    extractMoney(){
        this.setLayout(null);

        this.add(label);
        this.add(incomeField);

        menu();
    }

    public void menu(){ // hur mycket användaren väljer att ta bort
        label.setBounds(210, 160, 500, 23);
        label.setText("What amount do you wish to extract from your account:");
        label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        incomeField.setBounds(350, 200, 200, 23);
        incomeField.setText(Double.toString(afterLogin.income));
        incomeField.setHorizontalAlignment(SwingConstants.CENTER);

        incomeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loop = true;
                while(loop){
                    incomeField.addMouseListener(new MouseAdapter() { // tömmer ruta
                        public void mouseClicked(MouseEvent e) {
                            incomeField.setText("");
                        }
                    });

                    if(Double.parseDouble(incomeField.getText()) >= 0){ // om antalet användaren skriver är mer eller lika med noll
                        if(afterLogin.income < Double.parseDouble(incomeField.getText())) { // om antalet är mer än hur mycket användaren har
                            label.setText("You don't have that much money");
                        }

                        else { // tar bort pengar och går tillbaka till menyn
                            afterLogin.income = afterLogin.income - Double.parseDouble(incomeField.getText()); // ändrar antalet inkomst

                            MAIN.changePanel(MAIN.login); // tar tillbaka till menyn
                            afterLogin.incomeField.setText(Double.toString(afterLogin.income)); // ändrar totala inkomst  till det nya inkomst

                            loop = false;
                        }
                    }

                    else { // om användaren försöker istället lägga till pengar
                        label.setText("You're supposed to extract money...");
                    }
                }
            }
        });
    }
}
