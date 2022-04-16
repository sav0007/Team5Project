package com.company.View;

import com.company.Model.Movie;
import com.company.Model.MovieDatabase;
import com.company.Model.UserProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;


public class CollectionsPage extends UserProfile implements ActionListener {

    /**
     * @return
     */
    public JPanel CollectionsCard(UserProfile profile, int collectionnum) {
        JPanel Collections = new JPanel();
        Collections.setSize(300,300);
        Collections.setMinimumSize(new Dimension(300, 300));
        MovieDatabase temp;
        temp = profile.getCollection(collectionnum);


        Collections.add(chooseCollect());
        Collections.setVisible(true);
        return Collections;
    }

    protected JComboBox chooseCollect() {
        String Collections[]  = {"Collection 1", "Collection 2", "Collection 3"};

        JComboBox collects = new JComboBox(Collections);

        collects.setBounds(100, 550, 150, 20);

        collects.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (collects.getSelectedIndex() == 0){

                }
            }
        });

        return collects;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}