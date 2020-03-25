import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class extractMoney extends JPanel{
    static JTextField textBox1 = new JTextField();
    static JLabel label1 = new JLabel();
    static boolean loop, loopAgain;

    extractMoney(){
        this.setLayout(null);

        this.add(label1);
        this.add(textBox1);

        menu();
    }

    public void menu(){
        label1.setBounds(210, 160, 500, 23);
        label1.setText("What amount do you wish to extract from your account:");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);

        textBox1.setBounds(350, 200, 200, 23);
        textBox1.setText(Double.toString(afterLogin.amount));
        textBox1.setHorizontalAlignment(SwingConstants.CENTER);

        textBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loop = true;
                while(loop){
                    textBox1.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            textBox1.setText("");
                        }
                    });
                    if(Double.parseDouble(textBox1.getText()) < 0){
                        loop = false;

                        afterLogin.amount = Double.parseDouble(textBox1.getText());

                        MAIN.changePanel(MAIN.login);
                        afterLogin.textBox1.setText(Double.toString(afterLogin.amount));
                    }

                    else if(Double.parseDouble(textBox1.getText()) == 0){
                        label1.setText("You sure you don't want to extract anything?");
                        textBox1.setText("Answer \"yes\" or \"no\"");
                        textBox1.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                textBox1.setText("");
                            }
                        });
                        textBox1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                loopAgain = true;
                                while(loopAgain){
                                    if(textBox1.getText().equalsIgnoreCase("yes")){
                                        loop = false;
                                        loopAgain = false;
                                        MAIN.changePanel(MAIN.login);
                                    }
                                    else if(textBox1.getText().equalsIgnoreCase("no")){
                                        loop = true;
                                        loopAgain = false;
                                    }

                                    else{
                                        textBox1.addMouseListener(new MouseAdapter() {
                                            public void mouseClicked(MouseEvent e) {
                                                textBox1.setText("");
                                            }
                                        });

                                        label1.setText("It's a yes or no question...");
                                        loopAgain = true;
                                    }
                                }
                            }
                        });
                    }

                    else{
                        label1.setText("You're supposed to extract money...");
                        loop = true;
                    }
                }
            }
        });
    }
}
