package Model;

import java.util.ArrayList;
import java.util.Date;

public class Movie
{




    public void setUserReviews(ArrayList<String> userReviews) {
        this.userReviews = userReviews;
    }

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String RunTime;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards; // listed as just a string in document
    private String poster;
    private ArrayList<String> ratings;
    private ArrayList<String> userReviews;

    /**
     * default constructor not 100% sure its needed though
     */
    Movie()
    {
        Title = "N/A";
        Rated = "N/A";
        Year = "N/A";
        Released = "N/A";
        Genre = "N/A";
        Director = "N/A";
        Actors = "N/A";
        Plot = "N/A";
        Language = "N/A";
        Country = "N/A";
        Awards = "N/A"; // listed as just a string in document
        //poster;
        ratings = new ArrayList<String>();
        userReviews = new ArrayList<String>();
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
     */
    Movie(String Title, String Mpaa, String Date1, String Runtime, String Genre, String Directors, String Actors, String Plot, String Languages, String Country, String Awards, String Poster)
    {
        this.Title = Title;
        Rated = Mpaa;
        Released = Date1;
        this.Genre = Genre;
        Director = Directors;
        this.Actors = Actors;
        this.Plot = Plot;
        Language = Languages;
        this.Country = Country;
        this.Awards = Awards; // listed as just a string in document
        poster = Poster;

    }

    /**
     * adds a user review to a movie
     * @param review new review to be added
     */
    public void AddReview(String review)
    {
        userReviews.add(review);
    }

    /**
     * edits a movie reviews entry
     * @param i index of review to be edited
     * @param review edited review
     */
    public void EditReview(int i, String review)
    {
        userReviews.set(i, review);
    }

    public void DeleteReview(int i)
    {
        userReviews.remove(i);
    }

}
