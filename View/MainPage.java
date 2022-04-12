package com.company.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * MainPage is a skeleton rn, a lot of it will be changed after i finish MovieDescription
 */
public class MainPage {


    static public void createPage(JFrame frame) {

        frame.add(drawTopBar());

        JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.setBounds(0,50,1280,670);

        cardPanel.add("movie", MovieDescription.movieCard());
        // add all pages here

        CardLayout page = (CardLayout)(cardPanel.getLayout());
        page.show(cardPanel,"movie");

        frame.add(cardPanel);
        frame.setSize(1280,720);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static public JPanel drawTopBar() {
        JPanel topBar = new JPanel();
        topBar.setLayout(new GridLayout());
        topBar.setBounds(0,0,1280,50);
        topBar.setBackground(Color.lightGray);

        JButton homeB = new JButton("Good Views");
        homeB.setBackground(Color.orange);
        homeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panel=HomePanel();
            }
        });

        JButton collectB = new JButton("Collections");
        collectB.setBackground(Color.gray);
        collectB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //panel is collections page
            }
        });

        JButton profileB = new JButton("Profile");
        profileB.setBackground(Color.orange);
        profileB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // panel is profile page
            }
        });


        topBar.add(homeB);
        topBar.add(collectB);
        topBar.add(profileB);

        return topBar;
    }

    static public JPanel homeCard() {
        JPanel home = new JPanel();

        home.setBounds(0,50,1280,670);
        home.setBackground(Color.lightGray);

        // home stuff

        return home;
    }

}
