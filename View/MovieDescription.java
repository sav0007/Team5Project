package com.company.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
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
        JPanel movie = new JPanel(new FlowLayout());

        movie.setBackground(Color.darkGray);

        URL moviePoster = null;
        try {
            moviePoster = new URL("https://m.media-amazon.com/images/M/MV5BN2FjNmEyNWMtYzM0ZS00NjIyLTg5YzYtYThlMGVjNzE1OGViXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JLabel poster = new JLabel(new ImageIcon(moviePoster));
        movie.add(poster);



        movie.add(Review());

        return movie;
    }


    // add review
    static protected JButton Review() {
        JButton addReview = new JButton("Add Review");



        return addReview;
    }

    // add to collection
    static protected JButton addCollect() {
        JButton addtoCollect = new JButton("Add to Collection");


        return addtoCollect;
    }

}
