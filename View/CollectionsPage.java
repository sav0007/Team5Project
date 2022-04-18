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


public class CollectionsPage extends JPanel implements ActionListener{


    private UserProfile prof;
    private JScrollPane Collection;
    private JComboBox CollectionsChoices;
    private JButton DeleteCollection;
    private JButton deleteCollectionButton;
    private JPanel CollectionsPAge;
    private LayoutManager layoutManager;



    CollectionsPage(){
        CollectionsPAge = new JPanel();
        Collection = new JScrollPane();
        Collection.createVerticalScrollBar();
        CollectionsPAge.setSize(450,300);
        CollectionsPAge.setVisible(true);
    }





    /**
     * @return
     */
    public JPanel CollectionsCard(UserProfile profile) {
        prof = profile;
        CollectionsPAge.add(chooseCollect());
        Collection = collectionView(profile, 0);


        CollectionsPAge.add(Collection, BorderLayout.CENTER);
        CollectionsPAge.setBackground(Color.DARK_GRAY);
        CollectionsPAge.setVisible(true);
        return CollectionsPAge;
    }

    protected JComboBox chooseCollect() {
        ArrayList<String> Collections  = new ArrayList<>();


        for(int i = 0; i < prof.getUserCollections().size(); i++){
         Collections.add("Collection " + (i + 1));
        }
        String Collectionslist[] = new String[Collections.size()];

        Collections.toArray(Collectionslist);

        CollectionsChoices = new JComboBox(Collectionslist);

        CollectionsChoices.setBounds(100, 550, 150, 20);

        CollectionsChoices.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                collectionView(prof, CollectionsChoices.getSelectedIndex());

            }
        });

        return CollectionsChoices;
    }



    public void actionPerformed(ActionEvent e) {

    }

    public JScrollPane collectionView(UserProfile profile, int a){
        Container temp1 = new JPanel();
        MovieDatabase temp;
        temp = profile.getCollection(a);
        for (int i = 0; i <temp.getMovies().size(); i++){
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
            temp1.add(poster);
        }
        CollectionsPAge.add(temp1);
        return Collection;
    }
}