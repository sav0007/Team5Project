package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Movie
{
    private String title;
    private String mpaa;
    private Date publishDate;
    private String runTime;
    private ArrayList<String> genre;
    private ArrayList<String> directors;
    private ArrayList<String> actors;
    private String plot;
    private ArrayList<String> Languages;
    private String country;
    private ArrayList<String> awards; // listed as just a string in document
    private Image poster;
    private String ratings;
    private ArrayList<String> userReviews;

    Movie()
    {
        title = "unknown";
        mpaa = "unknown";
        //publishDate.setDat
        genre.add("unknown genre");
        directors.add("unknown directors");
        actors.add("unklown actors");
        plot = "default plot";
        Languages.add("unkown languages");
        country = "unkown";
        awards.add("unkown award"); // listed as just a string in document
        //poster;
        ratings = "unkown rating";
    }
}
