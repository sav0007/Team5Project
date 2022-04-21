package com.company.View;

import com.company.Model.Login;

import javax.swing.*;
import java.awt.*;

public class LoginPage {

    private static JLabel logoLabel;
    private static JLabel usernameLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton createAccountButton;
    private static JButton guestUserButton;
    private static JLabel success;
    static JFrame frame;
    static JPanel panel;

    public static void LoginPage() {
        // constructor for main
    }
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
        logoLabel = new JLabel("GoodViews");
        logoLabel.setBounds(120, 30, 150, 25);
        logoLabel.setFont(new Font("Serif", Font.BOLD, 24));
        logoLabel.setForeground(Color.orange);
        panel.add(logoLabel);

        //Creates username prompt
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(20, 80, 80, 25);
        usernameLabel.setForeground(Color.orange);
        panel.add(usernameLabel);

        // Creates username text field
        usernameText = new JTextField();
        usernameText.setBounds(100, 80, 165, 25);
        panel.add(usernameText);

        // Creates password prompt
        passwordLabel = new JLabel("Password");
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
            Login log = new Login();
            log.loadUserList();
            if (!log.checkInfo(userName, password)){
                JLabel fail = new JLabel("Incorrect Username or Password");
                fail.setBounds(90, 55, 300, 25);
                fail.setForeground(Color.yellow);
                panel.add(fail);
                frame.repaint();
            }
            else {
                panel.setVisible(false);
                MainPage.createPage(frame, null, null, log.getCurrentUser());
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
            // create account
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