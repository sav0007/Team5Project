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


public class CollectionsPage extends JPanel {


    public JPanel CollectionsCard(UserProfile profile){
        JPanel Collections = new JPanel();

        Collections.setLayout(new GridBagLayout());
        Collections.setBackground(Color.DARK_GRAY);
        Collections.setForeground(Color.black);

        if (profile == null) {
            return Collections;
        }
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
            c.fill = GridBagConstraints.BOTH;
            c.gridwidth = 1;
            c.ipadx = 0;
            c.weighty = 0.00;
            c.weightx = 0.00;
            c.gridx = 0;
            c.gridy = i;
            Collections.add(comp, c);
        }

        Collections.setVisible(true);
        return Collections;
    }


}












































    /*
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
     *//*
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
*/