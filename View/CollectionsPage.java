package com.company.View;

import com.company.Model.MovieDatabase;
import com.company.Model.UserProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;


public class CollectionsPage extends UserProfile implements ActionListener{

    /**
     * @return
     */
    public JPanel CollectionsCard(UserProfile profile) {
        JPanel Collections = new JPanel();
        Dimension dimension = new Dimension(2000, 2000);
        Collections.setPreferredSize(dimension);
        Collections.setMinimumSize(new Dimension(300, 300));
        MovieDatabase temp;
        Collections.add(chooseCollect());
        temp = profile.getCollection(0);
        JScrollPane comp = new JScrollPane();
        if (temp.getMovies() != null) {
            for (int i = 0; i < temp.getMovies().size(); i++) { // add panel for each movie
                //JPanel result = new JPanel(new BorderLayout());

                // get poster - left
                String posterImage = temp.getMovie(i).getPoster();
                if (posterImage.compareTo("N/A") == 0) {
                    posterImage = "https://cdn.vectorstock.com/i/1000x1000/88/26/no-image-available-icon-flat-vector-25898826.webp";
                }
                URL moviePoster = null;
                try {
                    moviePoster = new URL(posterImage);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                ImageIcon imag = new ImageIcon(moviePoster);
                Image image = imag.getImage();
                Image newImage = image.getScaledInstance(100, 150, Image.SCALE_DEFAULT);
                imag = new ImageIcon(newImage);
                JLabel poster = new JLabel(imag);
                comp.add(poster);

                // get movie info - center
                JLabel CliffNotes = new JLabel();
                CliffNotes.setText("<html>" + temp.getMovie(i).getTitle() + "<br>" +
                        temp.getMovie(i).getYear() + "  |  " + temp.getMovie(i).getRated() + "  |  " + temp.getMovie(i).getGenre() + "<br>" +
                        temp.getMovie(i).getPlot() + "</html>");
                comp.add(CliffNotes);
            }
        }
        comp.setVisible(true);
        Collections.add(comp);
        Collections.setVisible(true);
        return Collections;
    }

    protected JComboBox chooseCollect() {
        String Collections[]  = {"Collection 1", "Collection 2", "Collection 3"};

        JComboBox collects = new JComboBox(Collections);

        collects.setBounds(100, 550, 150, 20);

        collects.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (collects.getSelectedIndex() == 0){

                }
            }
        });

        return collects;
    }



    public void actionPerformed(ActionEvent e) {

    }


}