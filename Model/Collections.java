package com.company.Model;

import java.util.ArrayList;

public class Collections extends MovieDatabase{
    private String Collectionname;
    private String Description;

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

}
