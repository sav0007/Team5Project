package com.company.View;

import com.company.Model.MovieDatabase;

import javax.swing.*;
import java.awt.*;

/**
 * Written by: Leela Hyatt
 * Date: 4/14/22
 * MovieListing displays movies from a search or collection
 * History:
 *  Date        Name            Modification
 *
 */
class MovieListing {

    /**
     *
     * @return
     */
    public JPanel listingCard(MovieDatabase movies) {
        JPanel movieList = new JPanel(new FlowLayout());

        for (Movie movie: movies) {
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
            CliffNotes.setText("<html>"+movie.getTitle()+"<br>"+
                    movie.getYear()+"  |  "+movie.getRated()+"  |  "+movie.getGenre()+"<br>"+
                    movie.getPlot()+"</html>");
            result.add(CliffNotes,BorderLayout.CENTER);

            // select movie - right
            JButton pickmovie = new JButton();
            pickmovie.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MovieDescription.movieCard(movie);
                }
            });
            result.add(pickmovie, BorderLayout.EAST);

            movieList.add(result);
        }

        // this panel may need a scrollbar

        return movieList;
    }

}
