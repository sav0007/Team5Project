package com.company.View;

import com.company.Model.Collections;
import com.company.Model.UserProfile;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.company.View.LoginPage.frame;


public class CollectionsPage extends MainPage{

    private JPanel Collections;
    private GridBagConstraints CollectConst;
    private UserProfile uprof;

    CollectionsPage(){
        Collections = new JPanel();
        CollectConst = new GridBagConstraints();
    }

    public JPanel CollectionsCard(UserProfile profile) {
        Collections.setVisible(true);
        uprof = profile;
        Collections.setLayout(new GridBagLayout());
        Collections.setBackground(Color.DARK_GRAY);
        Collections.setForeground(Color.black);
        JPanel osPanel = new JPanel(new GridLayout(1,2));

        if (profile == null) {
            return Collections;
        }

        CollectConst.gridy = 0;
        JButton AddCollection = new JButton("Create Collection");
        JButton DeleteCollection = new JButton("Delete Collection");
        AddCollection.addActionListener(e -> {
            PopUpAdd();
        });
        DeleteCollection.addActionListener(e -> {
            PopUpDelete();
        });
        osPanel.add(AddCollection);
        osPanel.add(DeleteCollection);
        CollectConst.weighty = 0;
        CollectConst.weightx = 0;
        Collections.add(osPanel, CollectConst);
        Collections.setSize(1920, 1080);
        for (int i = 0; i < uprof.getUserCollections().size(); i++) {
            //creating buttons
            JButton comp = new JButton();
            comp.setBackground(Color.LIGHT_GRAY);
            comp.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            URL moviePoster = null;
            if (uprof.getCollection(i).movies.size() > 0) {
                String posterImage = uprof.getCollection(i).getMovie(0).getPoster();

                if (posterImage.compareTo("N/A") == 0) {
                    posterImage = "https://cdn.vectorstock.com/i/1000x1000/88/26/no-image-available-icon-flat-vector-25898826.webp";
                }
                try {
                    moviePoster = new URL(posterImage);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                String  posterImage = "https://cdn.vectorstock.com/i/1000x1000/88/26/no-image-available-icon-flat-vector-25898826.webp";

                try {
                    moviePoster = new URL(posterImage);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
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

            // collection name
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

            //collection description
            JLabel CollectionDescription = new JLabel();
            CollectionDescription.setText("<html>" + profile.getCollection(i).getDescription() + "<br>" + "</html>");
            CollectionDescription.setFont(new Font("Arial",Font.BOLD,20));
            c.fill = GridBagConstraints.BOTH;
            c.weighty = .5;
            c.gridx = 1;
            c.gridy = 1;
            comp.add(CollectionDescription, c);
            int finalI = i;
            comp.addActionListener(e -> { // redirects for each collection
                int j = finalI;
                themovies = uprof.getCollection(j);
                l.listingCard();
                createPage();
                page.show(cardPanel,"search");
            });
            CollectConst.gridy = i + 1;
            Collections.add(comp, CollectConst);
        }

        Collections.setVisible(true);
        return Collections;
    }

    public void PopUpAdd()
    {
        // building frame
        JPanel PopAdd = new JPanel();
        PopAdd.setSize(300, 200);
        PopAdd.setBackground(Color.LIGHT_GRAY);
        JFrame popup = new JFrame();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Creates Collection Name prompt
        JLabel CreateCollectionLabel = new JLabel("New Collection Name");
        CreateCollectionLabel.setBounds(10, 10, 165, 25);
        CreateCollectionLabel.setForeground(Color.orange);
        popup.add(CreateCollectionLabel);

        // Creates Collection Name text field
        JTextField CollectionNameText = new JTextField();
        CollectionNameText.setBounds(10, 30, 165, 25);
        popup.add(CollectionNameText);

        //Creates Collection description prompt
        CreateCollectionLabel = new JLabel("New Collection Description");
        CreateCollectionLabel.setBounds(10, 50, 165, 25);
        CreateCollectionLabel.setForeground(Color.orange);
        popup.add(CreateCollectionLabel);

        // Creates Collection descripion text field
        JTextField CollectionDescriptionText = new JTextField();
        CollectionDescriptionText.setBounds(10, 80, 165, 25);
        popup.add(CollectionDescriptionText);

        // Confirmation button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(120, 120, 150, 25);
        Confirm.setForeground(Color.orange);
        Confirm.addActionListener(e -> {
            Collections tempcollect = new Collections();
            String temp = CollectionNameText.getText();
            if (temp != null)
            tempcollect.setCollectionname(temp);
            temp = CollectionDescriptionText.getText();
            if (temp != null)
            tempcollect.setDescription(temp);
            uprof.createCollection(tempcollect);
            popup.setVisible(false);
            createPage();
            page.show(cardPanel,"Collections");
        });
        popup.add(Confirm);


        popup.add(PopAdd);
        popup.setVisible(true);
        popup.setBounds(200, 200, 300, 200);
    }
    public void PopUpDelete()
    {
        // building frame
        JPanel PopAdd = new JPanel();
        PopAdd.setSize(300, 200);
        PopAdd.setBackground(Color.LIGHT_GRAY);
        JFrame popup = new JFrame();
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //

        popup.setLayout(new FlowLayout());
        for (int i = 0; i < uprof.getUserCollections().size(); i++){
            JButton combo = new JButton();
            String temp =uprof.getCollection(i).getCollectionname();
            combo.setText(temp);
            int finalI = i;
            combo.addActionListener(e -> {
                int j = finalI;
                uprof.deleteCollectionatind(j);
                popup.setVisible(false);
                cardPanel.repaint();

            });
            popup.add(combo);
            //combo.addItemListener(uprof.deleteCollection(uprof.getCollection(i)));
        }


        popup.add(PopAdd);
        popup.setVisible(true);
        popup.setBounds(200, 200, 300, 200);
    }


}




/*

            c.fill = GridBagConstraints.BOTH;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.ipadx = 0;
            c.ipady = 0;
            c.weighty = 0.001;
            c.weightx = 0.001;
            c.gridx = 0;
            c.gridy = i;
            c.anchor = GridBagConstraints.PAGE_START;




 */







































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