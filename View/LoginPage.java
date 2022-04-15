package com.company.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {

    private static JLabel logoLabel;
    private static JLabel usernameLabel;
    private static JTextField usernameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;
    private static JButton createAccountButton;
    private static JLabel success;

    public static void login() {

        //Creates Login Window
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
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
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 160, 80, 25);
        loginButton.setForeground(Color.orange);
        loginButton.addActionListener(new LoginPage());
        panel.add(loginButton);

        // Create Account Button
        createAccountButton = new JButton("Create Account");
        createAccountButton.setForeground(Color.orange);
        createAccountButton.setBounds(100, 160, 165, 25);
        panel.add(createAccountButton);

        // Creates Success response if user entry matches records
        success = new JLabel("");
        success.setBounds(10, 180, 300, 25);
        panel.add(success);
        success.setText("");

        frame.setVisible(true);

        // on success, hide login panel and call MainPage.createPage(frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName = usernameText.getText();
        String password = passwordText.getText();

        if(userName.equals("Ace") && password.equals("octopus")) {
            success.setText("Login Successful");
        }
        else if(userName.equals("Malachi") && password.equals("gym")) {
            success.setText("Login Successful");
        }
        else if(userName.equals("Leela") && password.equals("engineer")) {
            success.setText("Login Successful");
        }
        else if(userName.equals("Will") && password.equals("sure")) {
            success.setText("Login Successful");
        }

        else {
            success.setText("");
        }

    }
}


