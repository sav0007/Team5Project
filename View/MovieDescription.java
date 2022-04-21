package com.company.View;

import com.company.Model.Movie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * MovieDescription presents movie information to the user and allows the user to leave a review and add to a collection
 */
public class MovieDescription  {

    /**
     * draws movie description panel
     * @param movie1 (Movie) movie to be shown
     * @return movie panel
     */
    public JPanel movieCard(Movie movie1) {
        JPanel movie = new JPanel();

        movie.setLayout(null);
        movie.setBackground(Color.lightGray);
        movie.setForeground(Color.black);

        if (movie1==null) {
            return movie;
        }

        String Title=movie1.getTitle();
        JLabel title = new JLabel(Title);
        title.setFont(new Font("Arial",Font.BOLD,48));
        title.setBounds(10,0,1280,75);
        movie.add(title);


        String genre = movie1.getGenre();
        movie.add(makeLabel(genre,10,50,500,50));

        movie.add(poster(movie1));

        String release = movie1.getReleased();
        movie.add(makeLabel(release, 350, 100, 200,25));

        String mpaa = "| PG-13 |";
        movie.add(makeLabel(mpaa,525,100,100,25));

        String reviewText = movie1.getRatings();
        movie.add(makeLabel(reviewText,350,125,1000,100));

        String actors = "Actors: "+movie1.getActors();
        movie.add(makeLabel(actors,350,225,1000,25));

        String directors = "Director: "+movie1.getDirector();
        movie.add(makeLabel(directors,350,250,1000,25));

        String plot = "Plot: "+movie1.getPlot();
        movie.add(makeLabel(plot,350,275,1000,125));

        String languages = "Language: "+movie1.getLanguage();
        movie.add(makeLabel(languages,350,400,1000,25));

        String country = "Country: " +movie1.getCountry();
        movie.add(makeLabel(country,350,425,200,25));

        String awards = "Awards: "+movie1.getAwards();
        movie.add(makeLabel(awards,350,450,1000,100));

        movie.add(userReview());
        movie.add(Review());

        movie.add(chooseCollect());
        movie.add(addCollect());

        return movie;
    }

    /**
     * gets user reviews
     * @return string of reviews
     */
    private String getReviews() {
        return "bruh";
    }

    /**
     * makes generic label for description components
     * @param text string that goes into the label
     * @param x x-location of label
     * @param y y-location of label
     * @param w width of label
     * @param h height of label
     * @return label created
     */
    private JLabel makeLabel(String text, int x, int y, int w, int h) {
        JLabel label = new JLabel();

        label.setText(text);
        label.setFont(new Font("Arial",Font.PLAIN,16));
        label.setBounds(x,y,w,h);

        return label;
    }

    /**
     * generates movie poster to show user
     * @param movie1 movie to get poster for
     * @return label with poster in it
     */
     protected JLabel poster(Movie movie1) {
        String posterImage = movie1.getPoster();
        if (posterImage.compareTo("N/A") == 0)
        {
            posterImage = "https://cdn.vectorstock.com/i/1000x1000/88/26/no-image-available-icon-flat-vector-25898826.webp";
        }
        URL moviePoster = null;
        try {
            moviePoster = new URL(posterImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JLabel poster = new JLabel(new ImageIcon(moviePoster));
        poster.setBounds(25,100,300,445);

        return poster;
    }

    // add review

    /**
     * text box for user reviews
     * @return text box
     */
    protected JTextField userReview() {
        JTextField reviewText = new JTextField(20);

        reviewText.setBounds(350,550,300,25);

        return reviewText;
    }

    /**
     * creates button that adds review to user reviews
     * @return add review button
     */
    protected JButton Review() {
        JButton addReview = new JButton("Add Review");

        addReview.setBackground(Color.orange);
        addReview.setBounds(650,550,100,25);

        addReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // save review to file
            }
        });

        return addReview;
    }

    // add to collection

    /**
     *
     * @return
     */
    protected JComboBox chooseCollect() {
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

    /**
     *
     * @return
     */
    protected JButton addCollect() {
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