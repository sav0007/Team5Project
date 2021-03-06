package com.company.Model;

import java.util.ArrayList;
import java.util.Comparator;

public class Movie implements Comparable<Movie>
{

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards; // listed as just a string in document
    private String Poster;
    private ArrayList<Ratings> Ratings;
    private ArrayList<String> userRatings;
    private ArrayList<String> userReviews;

    /**
     * default constructor not 100% sure its needed though
     */
    public Movie()
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
        Ratings = new ArrayList<com.company.Model.Ratings>();
        userRatings = new ArrayList<>();
        userReviews = new ArrayList<>();
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
    Movie(String Title, String Mpaa, String Date1, String Runtime, String Genre, String Directors, String Actors, String Plot, String Languages, String Country, String Awards, String Poster, String Ratings)
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
        this.Poster = Poster;
        //ratings = Ratings;
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

    public  String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getRated() {
        return Rated;
    }

    public  String getReleased() {
        return Released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public  String getGenre() {
        return Genre;
    }

    public  String getDirector() {
        return Director;
    }

    public  String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public  String getLanguage() {
        return Language;
    }

    public  String getCountry() {
        return Country;
    }

    public  String getAwards() {
        return Awards;
    }

    public String getPoster() {
        return Poster;
    }

    public ArrayList<String> getUserRatings() {
        return userRatings;
    }

    public ArrayList<String> getUserReviews() {
        return userReviews;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }

    public void setUserRatings(ArrayList<String> userRatings) {
        this.userRatings = userRatings;
    }

    public void setUserReviews(ArrayList<String> userReviews) {
        this.userReviews = userReviews;
    }

    public String getRatings() {
        String temp = new String();
        for(int i =0; i < Ratings.size(); i++)
        {
            temp = temp + Ratings.get(i).getSource() + "   " + Ratings.get(i).getValue() + "    ";
        }
        return temp;
    }

    public void setRatings(ArrayList<com.company.Model.Ratings> ratings) {
        Ratings = ratings;
    }

    public int compareTo(Movie o)
    {
        String Title1 = Title.toUpperCase();
        String Title2 = o.getTitle().toUpperCase();
        int watch;
        watch = Title1.compareTo(Title2);
        if (watch > 0) {
            return 1;
        }
        if (watch < 0){
            return -1;
        }
        return 0;
    }

}


