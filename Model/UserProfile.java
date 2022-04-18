package com.company.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UserProfile {

    /**
     *  Setting the attributes of the Class to protected
     */
    protected String userName; protected String password;



    /**
     * Creating the Collections and Preferences arrays of MovieDatabase type
     */
    ArrayList<MovieDatabase>Collections;
    ArrayList<String>Preferences;

    /**
     Basic constructor for the UserProfile class
     */
    public UserProfile(String user, String pass)
    {
        userName = user;
        password = pass;
    }

    public UserProfile(){
        Collections = new ArrayList<>();
        Preferences = new ArrayList<>();
    }

    /**
     * This changes the UserProfile's set username
     * @param userInput : UserProfile field
     */
    public void changeUsername(String userInput){
        userName = userInput;
    }

    /**
     * This changes the UserProfile's set password
     * @param passwordInput : UserProfile field
     */
    public void changePassword(String passwordInput){
        password = passwordInput;
    }

    /**
     * This method adds a Collection of MovieDatabase
     * type to the collections array
     * @param Collection : MovieDatabase type that gets added to
     *                     the collections array
     */
    public void createCollection(MovieDatabase Collection){
        Collections.add(Collection);
    }

    /**
     * This method removes a Collection of MovieDatabase
     * type from the collections array
     * @param Collection : MovieDatabase type that gets removed
     *                     from the collections array
     */
    public void deleteCollection(MovieDatabase Collection){
        Collections.remove(Collection);
    }

    /**
     * This method adds the preference of MovieDatabase type to the array
     * @param Preference : MovieDatabase fields
     */
    public void addPreference(String Preference){
        Preferences.add(Preference);
    }

    /**
     * This method removes the preference of MovieDatabase type from the array
     * @param Preference : MovieDatabase fields
     */
    public void deletePreference(MovieDatabase Preference){
        Preferences.remove(Preference);
    }


    public ArrayList<MovieDatabase> getCollections() {
        return Collections;
    }


    public MovieDatabase getCollection(int i) {
        return Collections.get(i);
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    /** storeProfile Function
     *  preliminary method for saving UserProfile data
     *  Uses the users username and password as a file name to make storing and retrieveing easier
     *
     */
    public void storeProfile() {
        //GsonBuilder gson = new GsonBuilder();
        //gson.serializeNulls();
        //gson.setPrettyPrinting().disableHtmlEscaping();
        Gson gson1 = new GsonBuilder()
                .setPrettyPrinting()
                .disableHtmlEscaping()
                .create();
        String temp;
        temp = userName + password;
        File tempFile = new File(temp + ".json");
        UserProfile tempprof = this;
        try {
            FileWriter a = new FileWriter(tempFile);
            tempFile.createNewFile();
            gson1.toJson(tempprof, a);
            a.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (IllegalStateException e){
            e.printStackTrace();
        }
    }
}
