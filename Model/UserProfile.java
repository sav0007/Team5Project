package com.company.Model;

import java.util.ArrayList;

public class UserProfile {

    /**
     *  Setting the attributes of the Class to protected
     */
    protected String userName; protected String password;
    /**
     * Creating the Collections and Preferences arrays of MovieDatabase type
     */
    ArrayList<MovieDatabase>Collections = new ArrayList<>();
    ArrayList<MovieDatabase>Preferences = new ArrayList<>();

    /**
     Basic constructor for the UserProfile class
     */
    public UserProfile(String user, String pass)
    {
        userName = user;
        password = pass;
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
    public void addPreference(MovieDatabase Preference){
        Preferences.add(Preference);
    }

    /**
     * This method removes the preference of MovieDatabase type from the array
     * @param Preference : MovieDatabase fields
     */
    public void deletePreference(MovieDatabase Preference){
        Preferences.remove(Preference);
    }
}
