package com.company.Model;

import java.util.ArrayList;

public class Collections extends MovieDatabase{
    private String Collectionname;
    private String Description;
    private ArrayList<Movie> moviesArrayList = new ArrayList<>();

    public Collections()
    {
        Collectionname = null;
        Description = null;
        movies = new ArrayList<>();
    }

    public String getCollectionname() {
        return Collectionname;
    }

    public void setCollectionname(String collectionname) {
        Collectionname = collectionname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDatabase(MovieDatabase mb){
        setMovies(mb);
    }
    public ArrayList<Movie> getmoviesArrayList() {
        return this.moviesArrayList;
    }
    public void addToCollection(final Movie movie) {
        this.moviesArrayList.add(movie);

    }
    public void removeFromCollection(final Movie movie) {
        this.moviesArrayList.remove(movie);
    }
}
