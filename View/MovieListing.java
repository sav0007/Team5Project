package com.company.View;

import com.company.Model.Movie;
import com.company.Model.MovieDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.company.View.LoginPage.frame;
import static com.company.View.MainPage.createPage;
import static com.company.View.MainPage.user;

/**
 * Written by: Leela Hyatt
 * MovieListing displays list of movies from a search or collection
 */
class MovieListing {

    /**
     * draws list of movies
     * @param movies (MovieDatabase) list of movies to be shown
     * @return movie listing panel
     */
    public static JPanel listingCard(MovieDatabase movies) {
        JPanel movieList = new JPanel(new FlowLayout());
        movieList.setBackground(Color.lightGray);
        movieList.add(options());

        if (movies != null) {
            for (Movie movie : movies.getMovies() ) { // add panel for each movie
                JPanel result = new JPanel(new BorderLayout());

                // get poster - left
                String posterImage = movie.getPoster();
                if (posterImage.compareTo("N/A") == 0) {
                    posterImage = "https://cdn.vectorstock.com/i/1000x1000/88/26/no-image-available-icon-flat-vector-25898826.webp";
                }
                URL moviePoster = null;
                try {
                    moviePoster = new URL(posterImage);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                JLabel poster = new JLabel(new ImageIcon(moviePoster));
                result.add(poster, BorderLayout.WEST);

                // get movie info - center
                JLabel CliffNotes = new JLabel();
                CliffNotes.setText("<html>" + movie.getTitle() + "<br>" +
                        movie.getYear() + "  |  " + movie.getRated() + "  |  " + movie.getGenre() + "<br>" +
                        movie.getPlot() + "</html>");
                result.add(CliffNotes, BorderLayout.CENTER);

                // select movie - right
                JButton pickmovie = new JButton();
                pickmovie.addActionListener(e -> {
                    createPage(frame, movie, null, user);
                    MainPage.page.show(MainPage.cardPanel,"movie");

                });
                result.add(pickmovie, BorderLayout.EAST);

                movieList.add(result);
            }
        }

        // this panel may need a scrollbar

        return movieList;

    }

    /**
     * adds option buttons to movie listing panel
     * @return panel of filter/sort options
     */
    static JPanel options() {
        JPanel oPanel = new JPanel(new GridLayout(1,9));

        // add action listeners

        JButton sortAlphaAZ = new JButton("Sort Alphabetical (A-Z)");
        JButton sortAlphaZA = new JButton("sort Alphabetical (Z-A)");
        JButton sortOld = new JButton("sort Date (old-new)");
        JButton sortNew = new JButton("sort Date (new-old)");
        String[] genres = {"", "", "", ""}; //add possible genre
        JLabel genreLabel = new JLabel("Genre: ",SwingConstants.RIGHT);
        JComboBox genreFilter = new JComboBox(genres);
        String[] mpaa = {"G","PG","PG-13","R","X","Not Rated"};
        JLabel mpaaLabel = new JLabel("MPAA: ",SwingConstants.RIGHT);
        JComboBox mpaaFilter = new JComboBox(mpaa);

        oPanel.add(sortAlphaAZ);
        oPanel.add(sortAlphaZA);
        oPanel.add(sortOld);
        oPanel.add(sortNew);
        oPanel.add(genreLabel);
        oPanel.add(genreFilter);
        oPanel.add(mpaaLabel);
        oPanel.add(mpaaFilter);

        return oPanel;
    }

}