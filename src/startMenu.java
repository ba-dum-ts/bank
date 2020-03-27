import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class startMenu extends JPanel {
    static JTextField username = new JTextField(), password = new JTextField();
    static JLabel label = new JLabel();
    static JButton createAccount = new JButton(), logIn = new JButton();

    startMenu(){
        this.setLayout(null);

        this.add(username);
        this.add(password);
        this.add(label);
        this.add(createAccount);
        this.add(logIn);

        menu();
        help();
        finish();
    }

    public static void menu(){ // bevisar att konto existerar
        label.setBounds(200, 160, 500, 23);
        label.setText("Login:");
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
                    password.setEditable(true);

                    password.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(password.getText().length() > 0 && password.getText().length() < 21){ // om texten inte är för långt eller kort
                                for(int i = 0; i < MAIN.accounts.size(); i++) { // checkar listan med alla konton
                                    if (MAIN.accounts.get(i)[0].equalsIgnoreCase(username.getText()) && MAIN.accounts.get(i)[1].equalsIgnoreCase(password.getText())) { // om kontot existerar
                                        username.addKeyListener(new KeyListener() {
                                            public void keyTyped(KeyEvent e) {

                                            }

                                            public void keyPressed(KeyEvent e) {
                                                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                                                    MAIN.changePanel(MAIN.login);
                                                }
                                            }

                                            public void keyReleased(KeyEvent e) {

                                            }
                                        });
                                        logIn.setEnabled(true);
                                    }

                                    else{ // om kontot inte existerar
                                        label.setText("Wrong username or/and password");
                                    }
                                }
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

    public static void help(){ // skapar konto
        createAccount.setBounds(350, 340, 200, 23);
        createAccount.setText("Don't have an account?");
        createAccount.setHorizontalAlignment(SwingConstants.CENTER);
        createAccount.setVerticalAlignment(SwingConstants.CENTER);
        createAccount.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MAIN.changePanel(MAIN.account);
            }
        });
    }

    public static void finish(){ // om konto existerar, loggar in
        logIn.setBounds(350, 263, 200, 23);
        logIn.setText("Enter");
        logIn.setHorizontalAlignment(SwingConstants.CENTER);
        logIn.setVerticalAlignment(SwingConstants.CENTER);
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MAIN.changePanel(MAIN.login); // loggar in
            }
        });
        logIn.setEnabled(false);
    }
}