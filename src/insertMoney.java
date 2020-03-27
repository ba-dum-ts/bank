import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class insertMoney extends JPanel {
    static JTextField incomeField = new JTextField();
    static JLabel label = new JLabel();
    static boolean loop;

    insertMoney(){
        this.setLayout(null);

        this.add(label);
        this.add(incomeField);

        menu();
    }

    public void menu(){ // hur mycket användaren väljer att lägga till
        label.setBounds(210, 160, 500, 23);
        label.setText("What amount do you wish to insert to your account:");
        label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        incomeField.setBounds(350, 200, 200, 23);
        incomeField.setText(Double.toString(afterLogin.income));
        incomeField.setHorizontalAlignment(SwingConstants.CENTER);

        incomeField.addMouseListener(new MouseAdapter() { // tömmer ruta
            public void mouseClicked(MouseEvent e) {
                incomeField.setText("");
            }
        });
        incomeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loop = true;
                while(loop){
                    if(Double.parseDouble(incomeField.getText()) >= 0){ // om antalet användaren skriver är mer eller lika med noll
                        loop = false;

                        afterLogin.income = afterLogin.income + Double.parseDouble(incomeField.getText()); // ändrar antalet inkomst

                        MAIN.changePanel(MAIN.login); // tar tillbaka till menyn
                        afterLogin.incomeField.setText(Double.toString(afterLogin.income)); // ändrar totala inkomst  till det nya inkomst
                    }

                    else{ // om användaren försöker istället ta bort pengar
                        label.setText("You're supposed to insert money...");
                        loop = true;
                    }
                }
            }
        });
    }
}
