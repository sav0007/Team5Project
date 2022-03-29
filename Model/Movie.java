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
    private ArrayList<String> languages;
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
        actors.add("unknown actors");
        plot = "default plot";
        languages.add("unknown languages");
        country = "unknown";
        awards.add("unknown award"); // listed as just a string in document
        //poster;
        ratings = "unknown rating";
    }
    Movie(String Title, String Mpaa, Date Date1, String Runtime, ArrayList<String> Genre, ArrayList<String> Directors, ArrayList<String> Actors, String Plot, ArrayList<String> Languages, String Country, ArrayList<String> Awards, Image Poster, String Ratings)
    {
        title = Title;
        mpaa = Mpaa;
        publishDate = Date1;
        genre = Genre;
        directors = Directors;
        actors = Actors;
        plot = Plot;
        languages = Languages;
        country = Country;
        awards = Awards; // listed as just a string in document
        poster = Poster;
        ratings = Ratings;
    }


}
