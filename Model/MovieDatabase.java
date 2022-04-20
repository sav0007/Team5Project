package com.company.Model;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieDatabase
{

    public ArrayList<Movie> movies;

    /**
     * setter for movies
     * @param movies MovieDatabase to be replaced with current movie database
     */
    public void setMovies(MovieDatabase movies) {
        this.movies = movies.getMovies();
    }

    /**
     * default constructor
     */
    public MovieDatabase()
    {
        movies = new ArrayList<Movie>();
    }

    /**
     * adds a movie to the movies instance
     * @param movie movie to be added to instance
     */
    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    /**
     * getter for a specific movie in the database
     * @param i index for specific movie
     * @return movie at given index
     */
    public Movie getMovie(int i){
        return movies.get(i);
    }

    /**
     * getter for movies
     * @return ArrayList of movies in movie database
     */
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     *  Parses a list of movies from a json file and builds a database from the movies in the file
     * @param filename name of json file containing movies not currently in use should be fine to include but i dont remember if i tested it or not
     */
    public void buildDatabaseJson(String filename)
    {
        Gson gson = new Gson();
        JsonArray movielist = new JsonArray();
        JsonParser jsonParser = new JsonParser();
        try (FileReader reader = new FileReader("SampleMovieFile (2).json"))
        {
            Object obj = jsonParser.parse(reader);
            movielist = (JsonArray) obj;
            for (int i = 0; i < movielist.size(); i++)
            {
                String tempstring = movielist.get(i).toString(); // ignore this is just for looking at the string in the debugger
                Movie tempmovie;
                tempmovie = gson.fromJson(movielist.get(i), Movie.class);
                movies.add(tempmovie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    /**
     * Alphabetic sorting function for movies uses a compareto method
     */
    public void sortAlphaAZ()
    {
        Collections.sort(movies);
    }

    /**
     *  Reverse Alphabetic sorting function for movies using a comparator method
     */
    public void sortAlphaZA()
    {
        Comparator<Movie> sortTitleZA = new Comparator<Movie>() {
            public int compare(Movie o1, Movie o2) {
                String T1 = o1.getTitle();
                String T2 = o2.getTitle();
                int watch = T1.compareTo(T2);
                if (watch > 0){
                    return -1;
                }
                if (watch < 0){
                    return 1;
                }
                return 0;
            }
        };
        Collections.sort(movies, sortTitleZA);
    }

    /**
     * Sorting function for movies sorts by Year from Oldest to Newest
     */
    public void sortDateOld()
    {
        Comparator<Movie> sortYear = new Comparator<Movie>() {
            public int compare(Movie o1, Movie o2) {
                String Y1 = o1.getYear();
                String Y2 = o2.getYear();
                int watch = Y1.compareTo(Y2);
                if (watch > 0){
                    return -1;
                }
                if (watch < 0){
                    return 1;
                }
                return 0;
            }
        };
        Collections.sort(movies, sortYear);
    }

    /**
     * Sorting Function for movies sorts by Year from Newest to Oldest
     */
    public void sortDateNew()
    {
        Comparator<Movie> sortYear = new Comparator<Movie>() {
            public int compare(Movie o1, Movie o2) {
                String Y1 = o1.getYear();
                String Y2 = o2.getYear();
                int watch = Y1.compareTo(Y2);
                if (watch > 0){
                    return -1;
                }
                if (watch < 0){
                    return 1;
                }
                return 0;
            }
        };
        Collections.sort(movies, sortYear);
    }


    /**
     * takes in a string of genres or genre and filters the results into a sub moviedatabase containing only movies of a given genre
     * @param genres string of genres
     * @return submoviedatabase of movies that match the string of genres
     */
    public MovieDatabase filterGenre(String genres)
    {
        String genre[] = genres.split(", ");
        String dbgenre[];
        int matches = 0;
        MovieDatabase temp = new MovieDatabase();
        for (int i = 0; i < movies.size(); i++){
            matches = 0;
            dbgenre = movies.get(i).getGenre().split(", ");
            for(int j = 0; j < genre.length; j++)
            {
                for (int k = 0; k < dbgenre.length; k++) {
                    if (genre[j].compareTo(dbgenre[k]) == 0){
                        matches++;
                        //
                    }
                }
            }
            if(matches == genre.length) {
                temp.addMovie(movies.get(i));
            }
        }

        return temp;
    }


    /**
     * Filters movies by MPAA rating and returns a subdatabase of movies matching MPAA
     * @param MPAA MPAA rating to fitler by
     * @return subDatabase
     */
    public MovieDatabase filterMPAA(String MPAA)
    {
        MovieDatabase temp = new MovieDatabase();
        for (int i = 0; i < movies.size(); i++)
        {
            if (MPAA.compareTo(movies.get(i).getRated()) == 0){
                temp.addMovie(movies.get(i));
            }
        }
        return temp;
    }




}


/*


MovieAdapter tempmovieAdapter;
                tempmovieAdapter = gson.fromJson(tempstring, MovieAdapter.class);
                tempmovie = new Movie();
                tempmovie.setTitle(tempmovieAdapter.getTitle());
                tempmovie.setYear(tempmovieAdapter.getYear());
                tempmovie.setRated(tempmovieAdapter.getRated());
                if (tempmovieAdapter.getReleased() != "N/A")
                {
                    String temp = tempmovieAdapter.getReleased();
                    Date temp1 = temp;
                    tempmovie.setReleased(tempmovieAdapter.getReleased());
                }









Gson gson = new Gson();
        File file = new File(filename);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String temp = null;

        while (scan.hasNextLine())
        {
            temp = temp + scan.nextLine();
        }

        Type simpleMovieArrayListType = new TypeToken<ArrayList<Movie>>(){}.getType();  // gson type token
        ArrayList<Movie> arrayList2 = gson.fromJson(temp, simpleMovieArrayListType);



        temp = "bruh";
 */