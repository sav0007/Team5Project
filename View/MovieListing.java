package com.company.View;

import Model.Movie;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Written by: Leela Hyatt
 * Date: 4/14/22
 * MovieListing displays movies from a search or collection
 * History:
 *  Date        Name            Modification
 *
 */
class MovieListing {

    /**
     *
     * @return
     */
    static public JPanel listingCard() {
        JPanel movieList = new JPanel(new FlowLayout());

        // get movie list
        ArrayList<Movie> movies = null;

        //get movies from somewhere
        for (Movie movie : movies) {
            // add JButton for each movie
            // get poster - left
            // get title - line 1
            // get year - line 2
            // get mpaa - line 2
            // get genre - line 2
            // get plot - line 3
        }

        // this card needs a scrollbar

        return movieList;
    }
}
