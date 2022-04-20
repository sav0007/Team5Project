package com.company.Model;

public class MovieSearch extends MovieDatabase {

    private String movietitle;
    MovieDatabase searchResults;
    public MovieSearch(String title){
        title = movietitle;
    }

    public MovieDatabase Search(String Title, String Mpaa, String Date1, String Runtime, String Genre, String Directors, String Actors, String Plot, String Languages, String Country, String Awards, String Poster, String Ratings){
        Movie o_movie = new Movie (Title,Mpaa,Date1,Runtime,Genre,Directors,Actors,Plot,Languages,Country,Awards,Poster, Ratings);
        while(movies != null){
            if(movies.contains(o_movie)){
                searchResults.addMovie(o_movie);
                return searchResults;
            }
        }
        return null;
    }
}
