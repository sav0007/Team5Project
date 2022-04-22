package com.company.View;

import com.company.Model.UserProfile;

import javax.swing.*;
import java.awt.*;

import static com.company.View.LoginPage.frame;


public class ProfilePage extends MainPage{

    private static JPanel Profile;
    private static GridBagConstraints ProfileConst;
    private static UserProfile uprof;

    public static JPanel profileCard(UserProfile profile) {
        Profile = new JPanel(null);

        uprof = profile;
        Profile.setBackground(Color.DARK_GRAY);
        Profile.setForeground(Color.black);

        if (profile == null) {
            return Profile;
        }

        JButton changeUser = new JButton("Change Username");
        //action listener and location
        changeUser.setBounds(100,50,200,25);
        Profile.add(changeUser);

        JButton changePass = new JButton("Change Password");
        //action listener and location
        changePass.setBounds(200,150,200,25);
        Profile.add(changePass);

        JButton changePreferences = new JButton("Change Preferences");
        //action listener and location
        changePreferences.setBounds(200,300,100,25);
        Profile.add(changePreferences);

        JButton logOut = new JButton("Log Out");
        logOut.addActionListener(e -> {
            cardPanel.removeAll();
            frame.removeAll();
            frame.setVisible(false);
            LoginPage newLog = new LoginPage();
            newLog.login();
        });
        logOut.setBounds(1130,30,100,25);
        Profile.add(logOut);

        Profile.setVisible(true);
        return Profile;
    }


}