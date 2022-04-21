package com.company.View;

import com.company.Model.Login;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * LoginPage is the first thing the user sees when opening the app, it provides a portal to log in to personal GoodViews account
 */
public class LoginPage {

    private static JTextField usernameText;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton createAccountButton;
    private static JButton guestUserButton;
    static JFrame frame;
    static JPanel panel;

    /**
     * default constructor
     */
    public static void LoginPage() {
        // constructor for main
    }

    /**
     * draws login page components
     */
    public void login() {

        //Creates Login Window
        frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setBackground(Color.gray);
        frame.add(panel);
        panel.setLayout(null);

        //Creates GoodViews Logo
        JLabel logoLabel = new JLabel("GoodViews");
        logoLabel.setBounds(120, 30, 150, 25);
        logoLabel.setFont(new Font("Serif", Font.BOLD, 24));
        logoLabel.setForeground(Color.orange);
        panel.add(logoLabel);

        //Creates username prompt
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20, 80, 80, 25);
        usernameLabel.setForeground(Color.orange);
        panel.add(usernameLabel);

        // Creates username text field
        usernameText = new JTextField();
        usernameText.setBounds(100, 80, 165, 25);
        panel.add(usernameText);

        // Creates password prompt
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 120, 80, 25);
        passwordLabel.setForeground(Color.orange);
        panel.add(passwordLabel);

        // Creates password text field
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 120, 165, 25);
        panel.add(passwordText);

        // Creates Login Button
        LoginButton();
        panel.add(loginButton);

        // Create Account Button
        CreateAccountButton();
        panel.add(createAccountButton);

        //Creates Guest Button
        GuestUserButton();
        panel.add(guestUserButton);

        frame.setVisible(true);
    }

    /**
     * creates login button with action listener
     */
    void LoginButton() {
        loginButton = new JButton("Login");
        loginButton.setBounds(190, 160, 75, 25);
        loginButton.setForeground(Color.orange);
        loginButton.addActionListener(e -> {
            String userName = usernameText.getText();
            String password = passwordText.getText();
            Login.loadUserList();
            if (!Login.checkInfo(userName, password)){
                JLabel fail = new JLabel("Incorrect Username or Password");
                fail.setBounds(90, 55, 300, 25);
                fail.setForeground(Color.yellow);
                panel.add(fail);
                frame.repaint();
            }
            else {
                panel.setVisible(false);
                MainPage.createPage(frame, null, null, Login.getCurrentUser());
            }
        });
    }

    /**
     * creates create account button with action listener
     */
    void CreateAccountButton() {
        createAccountButton = new JButton("Create Account");
        createAccountButton.setForeground(Color.orange);
        createAccountButton.setBounds(25, 225, 150, 25);
        createAccountButton.addActionListener(e -> {
            String user = usernameText.getText();
            String pass = passwordText.getText();
            if (Objects.equals(user, "") || Objects.equals(pass, "")) {
                JLabel fail = new JLabel("Enter Username and Password to Create Account");
                fail.setBounds(50, 55, 300, 25);
                fail.setForeground(Color.yellow);
                panel.add(fail);
                frame.repaint();
            }
            else {
                Login.createAccount(user, pass);
                panel.setVisible(false);
                Login.loadUserList();
                if (Login.checkInfo(user, pass)) { MainPage.createPage(frame, null, null, Login.getCurrentUser()); }
            }

        });
    }

    /**
     * creates enter as guest button with action listener
     */
    void GuestUserButton() {
        guestUserButton = new JButton("Enter as Guest");
        guestUserButton.setBounds(205, 225, 150, 25);
        guestUserButton.setForeground(Color.orange);
        guestUserButton.addActionListener(e -> {
            Login.enterAsGuest(null,null); //change?
            panel.setVisible(false);
            MainPage.createPage(frame, null, null, Login.getCurrentUser());
        });
    }

}


/*
        if(userName.equals("Ace") && password.equals("octopus")) {
            success.setText("Login Successful");
            panel.setVisible(false);
            //MainPage.createPage(frame, null);
        }
        else if(userName.equals("Malachi") && password.equals("gym")) {
            success.setText("Login Successful");
            panel.setVisible(false);
            //MainPage.createPage(frame, null);
        }
        else if(userName.equals("Leela") && password.equals("engineer")) {
            success.setText("Login Successful");
            panel.setVisible(false);
            //MainPage.createPage(frame, null);
        }
        else if(userName.equals("Will") && password.equals("sure")) {
            success.setText("Login Successful");
            panel.setVisible(false);
            //Login log = new Login(userName, password);
            log.loadProfile("Willsure");
            MainPage.createPage(frame, null, log.getUser());
        }

        else {
            success.setText("");
        }
*/
