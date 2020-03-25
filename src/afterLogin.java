import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afterLogin extends JPanel{
    static JTextField textBox1 = new JTextField();
    static JLabel label1 = new JLabel();
    static JButton button1 = new JButton(), button2 = new JButton();
    static double amount = 0.0;

    afterLogin(){
        this.setLayout(null);

        this.add(label1);
        this.add(textBox1);
        this.add(button1);
        this.add(button2);

        menu();
    }

    public static void menu(){
        label1.setBounds(350, 160, 200, 23);
        label1.setText("Income:");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);

        textBox1.setBounds(350, 200, 200, 23);
        textBox1.setText(Double.toString(amount));
        textBox1.setHorizontalAlignment(SwingConstants.CENTER);
        textBox1.setEditable(false);

        button1.setBounds(250, 250, 150, 30);
        button1.setText("Insert money");
        button1.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        button1.setVerticalAlignment(SwingConstants.CENTER);
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        button1.setBackground(Color.green);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.insert);
            }
        });

        button2.setBounds(490, 250, 150, 30);
        button2.setText("Extract money");
        button2.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        button2.setVerticalAlignment(SwingConstants.CENTER);
        button2.setHorizontalAlignment(SwingConstants.CENTER);
        button2.setBackground(Color.red);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.extract);
            }
        });
    }
}
