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

    /**
     * default constructor not 100% sure its needed though
     */
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

    /**
     *  parameteriezed constructor
     * @param Title movie title
     * @param Mpaa mpaa rating
     * @param Date1 date
     * @param Runtime movie runtime
     * @param Genre list of genres for a given movie
     * @param Directors list of directors for a movie
     * @param Actors list of actors for a movie
     * @param Plot movie plot
     * @param Languages languages a movie is in
     * @param Country country movie is in
     * @param Awards awards movie has recieved
     * @param Poster image for a movie
     * @param Ratings movie ratings idk if this supposed to be user ratings so im commenting it out
     */
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
        //ratings = Ratings;
    }

    /**
     * adds a user review to a movie
     * @param review new review to be added
     */
    void AddReview(String review)
    {
        userReviews.add(review);
    }

    /**
     * edits a movie reviews entry
     * @param i index of review to be edited
     * @param review edited review
     */
    void EditReview(int i, String review)
    {
        userReviews.set(i, review);
    }

    void DeleteReview(int i)
    {
        userReviews.remove(i);
    }
}
