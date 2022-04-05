package com.company.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;

/**
 * Written by: Leela Hyatt
 * Date: 4/3/22
 * MovieDescription presents movie information to the user and allows the user to leave a review and add to a collection
 * History:
 *  Date        Name            Modification
 *
 */
class MovieDescription {

    // draw panel
    static public JPanel movieCard() {
        JPanel movie = new JPanel();

        movie.setLayout(null);
        movie.setBackground(Color.darkGray);

        JLabel title = new JLabel("Dune");
        title.setFont(new Font("Arial",Font.BOLD,48));
        title.setForeground(Color.black);
        title.setBounds(10,0,1280,100);
        movie.add(title);

        movie.add(poster());

        // important movie stuff

        // these have no bounds so you can't see them
        movie.add(userReview());
        movie.add(Review());

        movie.add(chooseCollect());
        movie.add(addCollect());

        return movie;
    }

    // poster
    static protected JLabel poster() {
        URL moviePoster = null;
        try {
            moviePoster = new URL("https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JLabel poster = new JLabel(new ImageIcon(moviePoster));
        poster.setBounds(25,100,300,445);

        return poster;
    }

    // add review
    static protected JTextField userReview() {
        JTextField reviewText = new JTextField(20);



        return reviewText;
    }

    static protected JButton Review() {
        JButton addReview = new JButton("Add Review");

        addReview.setBackground(Color.orange);

        addReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // save review to file
            }
        });

        return addReview;
    }

    // add to collection
    static protected JComboBox chooseCollect() {
        String Collections[]  = {"Collection 1", "Collection 2", "Collection 3"};

        JComboBox collects = new JComboBox(Collections);

        collects.setBounds(100, 550, 150, 20);

        collects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // choose collection to add to movie
            }
        });

        return collects;
    }

    static protected JButton addCollect() {
        JButton collect = new JButton("Add to Collection");

        collect.setBounds(100, 580, 150, 20);

        collect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add movie to some collection
            }
        });

        return collect;
    }

}
