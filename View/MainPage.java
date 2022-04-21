package com.company.View;

import com.company.Model.*;

import javax.swing.*;
import java.awt.*;

import static com.company.View.LoginPage.frame;

/**
 * MainPage shows user the pages they can interact with, it calls other view classes to centralize view control
 */
public class MainPage extends Login {
    static JPanel cardPanel;
    static CardLayout page;
    protected static UserProfile user;
    private static MovieDatabase movies1;
    /**
     *  draws panels and cards to be shown
     * @param frame jframe used by login used here
     * @param movdesc movie for movie description card
     * @param movies movies for movie listing card
     * @param profile profile being used
     */
     public static void createPage(JFrame frame, Movie movdesc, MovieDatabase movies, UserProfile profile) {

         user = profile;
         movies1 = movies;
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

         cardPanel.add("search",MovieListing.listingCard(movies));

        CollectionsPage a  = new CollectionsPage();
        cardPanel.add("Collections", a.CollectionsCard(profile));

        cardPanel.add("MovieListing", MovieListing.listingCard(movies));
        // add all pages here

        page = (CardLayout)(cardPanel.getLayout());
        page.show(cardPanel,"home");

        frame.add(cardPanel);
    }

    /**
     * draws top bar with home button, collections button, search bar, and profile button
     * @return top bar panel
     */
    static public JPanel drawTopBar() {
        JPanel topBar = new JPanel();
        topBar.setLayout(new GridLayout());
        topBar.setBounds(0,0,1280,50);
        topBar.setBackground(Color.lightGray);

        JButton homeB = new JButton("Good Views");
        homeB.setBackground(Color.orange);
        homeB.addActionListener(e -> page.show(cardPanel,"home"));

        JButton collectB = new JButton("Collections");
        collectB.setBackground(Color.gray);
        collectB.addActionListener(e -> page.show(cardPanel,"Collections"));

        JPanel searchP = new JPanel(null);
        searchP.setBackground(Color.orange);
        JTextField searchBar = new JTextField();
        searchBar.setBounds(0,12,240,25);
        JButton searchB = new JButton("Search");
        searchB.setBounds(240,0,80,50);
        searchB.setBackground(Color.orange);
        searchB.addActionListener(e -> {
            String input = searchBar.getText();
            MovieDatabase movies = new MovieDatabase();
            movies.buildDatabaseJson("SampleMovieFile (2).json");
            final MovieSearch search = new MovieSearch(movies);
            search.filterMoviesByTitle(input);
            MovieDatabase results = search.getResults();
            createPage(frame, null, results, user);
            page.show(cardPanel,"search");
        });
        searchP.add(searchBar);
        searchP.add(searchB);

        JButton profileB = new JButton("Profile");
        profileB.setBackground(Color.gray);
        profileB.addActionListener(e -> {
            // show profile page
        });

        topBar.add(homeB);
        topBar.add(collectB);
        topBar.add(searchP);
        topBar.add(profileB);

        return topBar;
    }

    /**
     * draws home page
     * @return home page panel
     */
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
