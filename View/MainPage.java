package com.company.View;

import com.company.Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

import static com.company.View.LoginPage.frame;

/**
 * MainPage shows user the pages they can interact with, it calls other view classes to centralize view control
 */
public class MainPage extends Login {
    static JPanel cardPanel;
    static CardLayout page;
    protected static UserProfile user;
    public static MovieDescription m1;
    public static Movie movdesc=null;
    public static MovieDatabase themovies=null;
    public static MovieListing l;

    /**
     *  draws panels and cards to be shown
     */
     public static void createPage() {

         resetFrame();

         UserProfile profile=getCurrentUser();

         user = profile;
         MovieDatabase movies1 = themovies;
         frame.setSize(1280,720);
         frame.setLayout(null);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         frame.add(drawTopBar());

             cardPanel = new JPanel(new CardLayout());
             cardPanel.setBounds(0, 50, 1280, 670);

             // add all pages here
             m1 = new MovieDescription();
             cardPanel.add("movie", m1.movieCard(movdesc));
             cardPanel.add("home", homeCard());
             l = new MovieListing();
             l.listingCard();
             cardPanel.add("search", l.addListing());
             CollectionsPage a = new CollectionsPage();
             cardPanel.add("Collections", a.CollectionsCard(profile));
             MovieListing m = new MovieListing();
             cardPanel.add("profile", ProfilePage.profileCard(profile));

         page = (CardLayout)(cardPanel.getLayout());
         page.show(cardPanel,"home");
         frame.add(cardPanel);
         cardPanel.repaint();
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

        //home button
        JButton homeB = new JButton("Good Views");
        homeB.setBackground(Color.orange);
        homeB.addActionListener(e -> {
            createPage();
            page.show(cardPanel,"home");
        });

        //collections button
        JButton collectB = new JButton("Collections");
        collectB.setBackground(Color.gray);
        collectB.addActionListener(e -> {
            createPage();
            page.show(cardPanel,"Collections");
        });

        //search panel - textbox and button
        JPanel searchP = new JPanel(null);
        searchP.setBackground(Color.orange);
        JTextField searchBar = new JTextField();
        searchBar.setBounds(0,12,240,25);
        JButton searchB = new JButton("Search");
        searchB.setBounds(240,0,80,50);
        searchB.setBackground(Color.orange);
        searchB.addActionListener(e -> {
            String input = searchBar.getText();
            MovieDatabase getmovies = new MovieDatabase();
            getmovies.buildDatabaseJson("SampleMovieFile (2).json");
            final MovieSearch search = new MovieSearch(getmovies);
            search.filterMoviesByTitle(input);
            themovies = search.getResults();
            l.listingCard();
            createPage();
            page.show(cardPanel,"search");
        });
        searchP.add(searchBar);
        searchP.add(searchB);

        //profile button
        JButton profileB = new JButton("Profile");
        profileB.setBackground(Color.gray);
        profileB.addActionListener(e -> {
            createPage();
            page.show(cardPanel, "profile");
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

    private static void resetFrame() {
        if (!Objects.equals(cardPanel,null)) {
            cardPanel.removeAll();
            frame.remove(cardPanel);
        }
    }

}
