package com.company.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import javax.swing.*;

public class MainPage {

    static public void createFrame() {
        JFrame frame = new JFrame();

        frame.add(drawTopBar());

        frame.setSize(640,640);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static public JPanel drawTopBar() {
        JPanel topBar = new JPanel();
        topBar.setLayout(null);
        topBar.setBounds(0,0,640,75);
        topBar.setBackground(Color.gray);

        JButton homeB = new JButton("Good Views");
        //homeB.setLayout(null);
        homeB.setBounds(0,0,100,75);
        homeB.setBackground(Color.orange);

        JButton profileB = new JButton("Profile");
        //profileB.setLayout(null);
        profileB.setBounds(540,0,100,75);
        profileB.setBackground(Color.orange);

        topBar.add(homeB);
        topBar.add(profileB);

        return topBar;
    }

    static public JPanel drawHomePanel() {
        JPanel homePanel = new JPanel();

        // code here

        return homePanel;
    }

}
