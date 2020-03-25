import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class createAccount extends JPanel{
    static JTextField textBox1 = new JTextField(), textBox2 = new JTextField();
    static JLabel label1 = new JLabel();
    static JButton button1 = new JButton();

    createAccount(){
        this.setLayout(null);

        this.add(textBox1);
        this.add(textBox2);
        this.add(label1);
        this.add(button1);


        menu();
        finish();
    }

    public static void menu(){
        label1.setBounds(350, 160, 200, 23);
        label1.setText("Create Account:");
        label1.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);

        textBox1.setBounds(350, 200, 200, 23);
        textBox1.setText("Username");

        textBox2.setBounds(350, 240, 200, 23);
        textBox2.setText("Password");
        textBox2.setEditable(false);

        textBox1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                textBox1.setText("");
            }
        });

        textBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textBox2.grabFocus();
                textBox2.setText("");

                if(textBox1.getText().length() > 0 && textBox1.getText().length() < 21){
                    textBox2.setEditable(true);

                    textBox2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(textBox2.getText().length() > 0 && textBox2.getText().length() < 21){
                                textBox2.addKeyListener(new KeyListener() {
                                    public void keyTyped(KeyEvent e) {

                                    }

                                    public void keyPressed(KeyEvent e) {
                                        if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                            addAccount(textBox1.getText(), textBox2.getText());
                                            MAIN.changePanel(MAIN.menu);
                                        }
                                    }

                                    public void keyReleased(KeyEvent e) {

                                    }
                                });
                                button1.setEnabled(true);
                            }

                            else{
                                label1.setText("Enter a password that's 1 to 20 characters long");
                                textBox2.addMouseListener(new MouseAdapter() {
                                    public void mouseClicked(MouseEvent e) {
                                        textBox2.setText("");
                                    }
                                });
                            }
                        }
                    });
                }

                else{
                    label1.setText("Enter a username that's 1 to 20 characters long");
                    textBox1.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            textBox1.setText("");
                        }
                    });
                }
            }
        });
    }

    public static void addAccount(String username, String password){
        String[] account = {username, password};
        MAIN.accounts.add(account);
    }

    public static void finish(){
        button1.setBounds(350, 263, 200, 23);
        button1.setText("Enter");
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        button1.setVerticalAlignment(SwingConstants.CENTER);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.menu);
            }
        });
        button1.setEnabled(false);
    }
}
