package com.company.View;

import com.company.Model.UserProfile;

import javax.swing.*;
import java.awt.*;


public class ProfilePage extends MainPage{

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
        //action listener and location
        Profile.add(changeUser);

        JButton changePass = new JButton("Change Password");
        //action listener and location
        Profile.add(changePass);

        JButton changePreferences = new JButton("Change Preferences");
        //action listener and location
        Profile.add(changePreferences);

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


}