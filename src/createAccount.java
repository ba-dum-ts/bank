import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class createAccount extends JPanel{
    static JTextField username = new JTextField(), password = new JTextField();
    static JLabel label = new JLabel();
    static JButton logIn = new JButton();

    createAccount(){
        this.setLayout(null);

        this.add(username);
        this.add(password);
        this.add(label);
        this.add(logIn);

        menu();
        finish();
    }

    public static void menu(){ // skapar konto
        label.setBounds(350, 160, 200, 23);
        label.setText("Create Account:");
        label.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        username.setBounds(350, 200, 200, 23);
        username.setText("Username");

        password.setBounds(350, 240, 200, 23);
        password.setText("Password");
        password.setEditable(false);

        username.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                username.setText("");
            }
        }); // tömmer ruta

        username.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                password.grabFocus();
                password.setText("");

                if(username.getText().length() > 0 && username.getText().length() < 21){ // om texten inte är för långt eller kort
                    password.setEditable(true); // får röra nästa textfält

                    password.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(password.getText().length() > 0 && password.getText().length() < 21){ // om texten inte är för långt eller kort
                                password.addKeyListener(new KeyListener() { // om användaren trycker på en specifik knapp
                                    public void keyTyped(KeyEvent e) {

                                    }

                                    public void keyPressed(KeyEvent e) {
                                        if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                            addAccount(username.getText(), password.getText());
                                            MAIN.changePanel(MAIN.menu);
                                        }
                                    }

                                    public void keyReleased(KeyEvent e) {

                                    }
                                });
                                logIn.setEnabled(true);
                            }

                            else{
                                label.setText("Enter a password that's 1 to 20 characters long");
                                password.addMouseListener(new MouseAdapter() {
                                    public void mouseClicked(MouseEvent e) {
                                        password.setText("");
                                    }
                                });
                            }
                        }
                    });
                }

                else{
                    label.setText("Enter a username that's 1 to 20 characters long");
                    username.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            username.setText("");
                        }
                    });
                }
            }
        });
    }

    public static void addAccount(String username, String password){ // lägger till konto
        String[] account = {username, password};
        MAIN.accounts.add(account);
    }

    public static void finish(){ // efter att ha skapat konto, går tillbaka till logga in panelen
        logIn.setBounds(350, 263, 200, 23);
        logIn.setText("Enter");
        logIn.setHorizontalAlignment(SwingConstants.CENTER);
        logIn.setVerticalAlignment(SwingConstants.CENTER);
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.menu);
            }
        });
        logIn.setEnabled(false);
    }
}
