package com.company.View;

import com.company.Model.*;

import javax.swing.*;
import java.awt.*;


public class ProfilePage extends MainPage {

    private static JPanel Profile;
    private static GridBagConstraints ProfileConst;
    private static UserProfile uprof;

    public static JPanel profileCard(UserProfile profile) {
        Profile = new JPanel(new GridLayout());

        uprof = profile;
        Profile.setBackground(Color.DARK_GRAY);
        Profile.setForeground(Color.black);

        if (profile == null) {
            return Profile;
        }

        JButton changeUser = new JButton("Change Username");
        changeUser.addActionListener(e -> {
            popChangeUser();
        });
        Profile.add(changeUser);

        JButton changePass = new JButton("Change Password");
        changePass.addActionListener(e -> {
            popChangePass();
        });

        Profile.add(changePass);

        //JButton changePreferences = new JButton("Change Preferences");
        //action listener and location
        //Profile.add(changePreferences);

        JButton logOut = new JButton("Logout");
        logOut.addActionListener(e -> {
            LoginPage.frame.removeAll();
            cardPanel.setVisible(false);
            LoginPage newLogin = new LoginPage();
            newLogin.login();
        });
        Profile.add(logOut);

        Profile.setVisible(true);
        return Profile;
    }

    public static void popChangeUser() {
        // building frame
        JPanel PopAdd = new JPanel();
        PopAdd.setSize(300, 200);
        PopAdd.setBackground(Color.LIGHT_GRAY);
        JFrame popup = new JFrame();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creates Username Prompt
        JLabel UserLabel = new JLabel("New Username");
        UserLabel.setBounds(10, 10, 165, 25);
        UserLabel.setForeground(Color.orange);
        popup.add(UserLabel);

        // Creates Username TextField
        JTextField UserNameText = new JTextField();
        UserNameText.setBounds(10, 30, 165, 25);
        popup.add(UserNameText);

        // Confirmation button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(120, 120, 150, 25);
        Confirm.setForeground(Color.orange);
        Confirm.addActionListener(e -> {
            String newUser = UserNameText.getText();
            if (newUser != null) {
                uprof.changeUsername(newUser);
            }
            popup.setVisible(false);
            createPage();
            page.show(cardPanel, "Profile");
        });
        popup.add(Confirm);


        popup.add(PopAdd);
        popup.setVisible(true);
        popup.setBounds(200, 200, 300, 200);
    }

    public static void popChangePass() {

        // building frame
        JPanel PopAdd = new JPanel();
        PopAdd.setSize(300, 200);
        PopAdd.setBackground(Color.LIGHT_GRAY);
        JFrame popup = new JFrame();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Creates Username Prompt
        JLabel PassLabel = new JLabel("New Username");
        PassLabel.setBounds(10, 10, 165, 25);
        PassLabel.setForeground(Color.orange);
        popup.add(PassLabel);

        // Creates Username TextField
        JTextField PassWordText = new JTextField();
        PassWordText.setBounds(10, 30, 165, 25);
        popup.add(PassWordText);

        // Confirmation button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(120, 120, 150, 25);
        Confirm.setForeground(Color.orange);
        Confirm.addActionListener(e -> {
            String newPass = PassWordText.getText();
            if (newPass != null) {
                uprof.changeUsername(newPass);
            }
            popup.setVisible(false);
            createPage();
            page.show(cardPanel, "Profile");
        });
        popup.add(Confirm);


        popup.add(PopAdd);
        popup.setVisible(true);
        popup.setBounds(200, 200, 300, 200);
    }
}
