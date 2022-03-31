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

        topBar.setBounds(0,0,640,75);
        topBar.setBackground(Color.gray);

        JButton homeB = new JButton("Good Views");
        homeB.setBounds(0,0,100,75);
        homeB.setBackground(Color.orange);



        topBar.add(homeB);

        return topBar;
    }

    static public JPanel drawHomePanel() {
        JPanel homePanel = new JPanel();

        // code here

        return homePanel;
    }

}
