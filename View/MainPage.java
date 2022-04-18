package com.company.View;

import com.company.Model.Login;
import com.company.Model.Movie;
import com.company.Model.UserProfile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Written by: Leela Hyatt
 * Date: 4/5/22
 * MainPage shows user the pages they can interact with, it calls other view classes to centralize view control
 */
public class MainPage extends Login {
    static JPanel cardPanel;
    static CardLayout page;

     public static void createPage(JFrame frame, Movie movdesc, UserProfile profile) {

         frame.setSize(1280,720);
         frame.setLayout(null);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         frame.add(drawTopBar());

        cardPanel = new JPanel(new CardLayout());
        cardPanel.setBounds(0,50,1280,670);

        MovieDescription m1 = new MovieDescription();
        cardPanel.add("movie", m1.movieCard(movdesc));

        cardPanel.add("home",homeCard());

        cardPanel.add("list",MovieListing.listingCard(null));

        CollectionsPage a  = new CollectionsPage();
        cardPanel.add("Collections", a.CollectionsCard(profile));
        // add all pages here

        page = (CardLayout)(cardPanel.getLayout());
        page.show(cardPanel,"list");

        frame.add(cardPanel);
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
                page.show(cardPanel,"home");
            }
        });

        JButton collectB = new JButton("Collections");
        collectB.setBackground(Color.gray);
        collectB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page.show(cardPanel,"Collections");
            }
        });

        JButton profileB = new JButton("Profile");
        profileB.setBackground(Color.orange);
        profileB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // show profile page
            }
        });

        topBar.add(homeB);
        topBar.add(collectB);
        topBar.add(profileB);

        return topBar;
    }

    static public JPanel homeCard() {
        JPanel home = new JPanel(new FlowLayout());

        home.setBounds(0,50,1280,670);
        home.setBackground(Color.lightGray);

        // home stuff

        JLabel welcome = new JLabel("<html>"+"Welcome to GoodViews!<br>"
                +"could add username to personalize homepage message<br>"+
                "Should we add buttons to redirect to other pages or recommended movies?"+"</html>");

        home.add(welcome);
        return home;
    }


}
