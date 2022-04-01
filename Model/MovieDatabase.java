package Model;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieDatabase
{
    private ArrayList<Movie> movies;

    public MovieDatabase()
    {
        movies = new ArrayList<Movie>();
    }

    public void addMovie(Movie movie)
    {
        movies.add(movie);
    }

    public void buildDatabaseJson(String filename)
    {
        Gson gson = new Gson();
        JsonArray movielist = new JsonArray();
        JsonParser jsonParser = new JsonParser();
        try (FileReader reader = new FileReader("SampleMovieFile (2).json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            movielist = (JsonArray) obj;
           // System.out.println(employeeList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < movielist.size(); i++)
        {
            String tempstring = movielist.get(i).toString();
            Movie tempmovie;
            tempmovie = gson.fromJson(tempstring, Movie.class);
            movies.add(tempmovie);
        }

    }



}


/*
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