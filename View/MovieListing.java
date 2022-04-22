package com.company.View;

import com.company.Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.company.View.MainPage.*;


/**
 * Written by: Leela Hyatt
 * MovieListing displays list of movies from a search or collection
 */
class MovieListing {

    private static JPanel movieList;

    MovieListing() {
        movieList = new JPanel(new GridBagLayout());
        movieList.setBackground(Color.lightGray);
    }

    /**
     * draws list of movies
     * @return movie listing panel
     */
    public static void listingCard() {
        movieList.setVisible(true);
        movieList.add(options());

        if (themovies!= null) {
            int i = 1;
            GridBagConstraints c = new GridBagConstraints();
            for (Movie movie : themovies.getMovies() ) { // add panel for each movie

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
                    movieList.removeAll();
                    movieList.repaint();
                    themovies = null;
                    MainPage.movdesc = movie;
                    MainPage.createPage();
                    MainPage.page.show(cardPanel,"movie");
                });
                result.add(pickmovie, BorderLayout.EAST);
                c.gridy = i;
                movieList.add(result, c);
                result.setVisible(true);
                i++;
            }
        }

        cardPanel.repaint();
        // this panel may need a scrollbar
    }

    public static JPanel addListing() {
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
        sortAlphaAZ.addActionListener(e -> {
            themovies.sortAlphaAZ();
            createPage();
            page.show(cardPanel, "search");
        });
        JButton sortAlphaZA = new JButton("sort Alphabetical (Z-A)");
        sortAlphaZA.addActionListener(e -> {
            themovies.sortAlphaZA();
            createPage();
            page.show(cardPanel, "search");
        });
        JButton sortOld = new JButton("sort Date (new-old)");
        sortOld.addActionListener(e -> {
            themovies.sortDateOld();
            createPage();
            page.show(cardPanel, "search");
        });
        JButton sortNew = new JButton("sort Date (old-new)");
        sortNew.addActionListener(e -> {
            themovies.sortDateNew();
            createPage();
            page.show(cardPanel, "search");
        });
        JTextField genreText = new JTextField();
        JButton genreFilter = new JButton("filter Genre");
        genreFilter.addActionListener(e -> {
            themovies=themovies.filterGenre(genreText.getText());
            createPage();
            page.show(cardPanel, "search");
        });
        String[] mpaa = {"G","PG","PG-13","R","X","Not Rated"};
        JButton mpaaButton = new JButton("MPAA: ");
        JComboBox mpaaFilter = new JComboBox(mpaa);
        mpaaButton.addActionListener(e -> {
            String chosen = mpaaFilter.getSelectedItem().toString();
            themovies=themovies.filterMPAA(chosen);
            createPage();
            page.show(cardPanel, "search");
        });

        oPanel.add(sortAlphaAZ);
        oPanel.add(sortAlphaZA);
        oPanel.add(sortOld);
        oPanel.add(sortNew);
        oPanel.add(genreText);
        oPanel.add(genreFilter);
        oPanel.add(mpaaButton);
        oPanel.add(mpaaFilter);

        return oPanel;
    }

}