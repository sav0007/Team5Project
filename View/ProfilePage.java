package com.company.View;

import com.company.Model.MovieDatabase;
import com.company.Model.UserProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

import static com.company.View.LoginPage.frame;


public class ProfilePage extends MainPage{

    private JPanel Profile;
    private GridBagConstraints ProfileConst;
    private UserProfile uprof;

    ProfilePage(){
        Profile = new JPanel();
        ProfileConst = new GridBagConstraints();
    }

    public JPanel ProfileCard(UserProfile profile) {
        uprof = profile;
        Profile.setLayout(new GridBagLayout());
        Profile.setBackground(Color.DARK_GRAY);
        Profile.setForeground(Color.black);
        JPanel osPanel = new JPanel(new GridLayout(1,2));

        if (profile == null) {
            return Profile;
        }

        ProfileConst.gridy = 0;
        JButton changeUser = new JButton("Change Username");
        JButton changePass = new JButton("Change Password");
        JButton changePreferences = new JButton("Change Preferences");
        JButton logOut = new JButton("Logout");
        osPanel.add(changeUser);
        osPanel.add(changePass);
        Profile.add(osPanel);
        for (int i = 0; i < profile.getUserCollections().size(); i++){
            JButton comp = new JButton();
            comp.setBackground(Color.LIGHT_GRAY);
            comp.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            String posterImage = profile.getCollection(i).getMovie(0).getPoster();
            if (posterImage.compareTo("N/A") == 0) {
                posterImage = "https://cdn.vectorstock.com/i/1000x1000/88/26/no-image-available-icon-flat-vector-25898826.webp";
            }
            URL moviePoster = null;
            try {
                moviePoster = new URL(posterImage);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //image resizing
            ImageIcon imag = new ImageIcon(moviePoster);
            Image image = imag.getImage();
            Image newImage = image.getScaledInstance(125, 219, Image.SCALE_DEFAULT);
            imag = new ImageIcon(newImage);
            JLabel poster = new JLabel(imag);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridheight = 2;
            c.weightx = 0.01;
            c.gridx = 0;
            c.gridy = 0;
            comp.add(poster, c);


            JLabel CollectionName = new JLabel();
            CollectionName.setText("<html>" + profile.getCollection(i).getCollectionname() + "<br>" + "</html>");
            CollectionName.setFont(new Font("Arial",Font.BOLD,28));
            c.fill = GridBagConstraints.BOTH;
            c.gridheight = 1;
            c.ipady = 0;
            c.ipadx = 100;
            c.gridwidth = 3;
            c.weighty = .1;
            c.gridx = 1;
            c.gridy = 0;
            comp.add(CollectionName, c);


            JLabel CollectionDescription = new JLabel();
            CollectionDescription.setText("<html>" + profile.getCollection(i).getDescription() + "<br>" + "</html>");
            CollectionDescription.setFont(new Font("Arial",Font.BOLD,20));
            c.fill = GridBagConstraints.BOTH;
            c.weighty = .5;
            c.gridx = 1;
            c.gridy = 1;
            comp.add(CollectionDescription, c);
            int finalI = i;
            comp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { // this should redirect to the movie list in some way im not sure how yet
                    int j = finalI;
                    MovieListing.listingCard(uprof.getCollection(j));
                    cardPanel.add("MovieListings",MovieListing.listingCard(uprof.getCollection(j)));
                    page.show(cardPanel,"MovieListings"); //

                }

            });
            ProfileConst.gridy = i + 1;
            Profile.add(comp, ProfileConst);
        }

        Profile.setVisible(true);
        return Profile;
    }


}