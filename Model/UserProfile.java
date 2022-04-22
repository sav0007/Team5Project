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
    private LoginInfo loginInfo;


    /**
     * Creating the Collections and Preferences arrays
     */
    private ArrayList<Collections> UserCollections = new ArrayList<>();
    private ArrayList<String> Preferences = new ArrayList<>();

    /**
     Basic constructor for the UserProfile class
     */
    public UserProfile(String user, String pass)
    {
        loginInfo = new LoginInfo(user, pass);
    }

    /**
     * This changes the UserProfile's set username
     * @param userInput : UserProfile field
     */
    public void changeUsername(final String userInput) {
        this.loginInfo = new LoginInfo(userInput, loginInfo.getPassword());
    }

    /**
     * This changes the UserProfile's set password
     * @param passwordInput : UserProfile field
     */
    public void changePassword(final String passwordInput) {
        this.loginInfo = new LoginInfo(loginInfo.getUsername(), passwordInput);
    }

    /**
     * This method adds a Collection of MovieDatabase
     * type to the collections array
     * @param Collection : MovieDatabase type that gets added to
     *                     the collections array
     */
    public void createCollection(final Collections Collection){
        this.UserCollections.add(Collection);
    }

    /**
     * This method removes a Collection of MovieDatabase
     * type from the collections array
     * @param Collection : MovieDatabase type that gets removed
     *                     from the collections array
     */
    public void deleteCollection(final Collections Collection){
        this.UserCollections.remove(Collection);
    }

    public void deleteCollection(int i){
        UserCollections.remove(i);
    }


    /**
     * This method adds the preference of MovieDatabase type to the array
     * @param Preference : MovieDatabase fields
     */
    public void addPreference(final String Preference){
        this.Preferences.add(Preference);
    }

    /**
     * This method removes the preference of MovieDatabase type from the array
     * @param Preference : MovieDatabase fields
     */
    public void deletePreference(final MovieDatabase Preference){
        this.Preferences.remove(Preference);
    }

    /**
     * getter for UserCollection
     * @return returns the User Collection list
     */
    public ArrayList<Collections> getUserCollections() {
        return this.UserCollections;
    }

    /**
     * returns a specfic Collection from the Collection list
     * @param i the index of the given Collection
     * @return returns the Collection from the given index
     */
    public Collections getCollection(int i) {
        return this.UserCollections.get(i);
    }

    /**
     *  getter for userName
     * @return returns userName
     */
    public String getUserName() {
        return loginInfo.getUsername();
    }

    /**
     * getter for password
     * @return password
     */
    public String getPassword() {
        return loginInfo.getPassword();
    }

    /** storeProfile Function
     *  preliminary method for saving UserProfile data
     *  Uses the users username and password as a file name to make storing and retrieval easier
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
        temp = loginInfo.getUsername() + loginInfo.getPassword();
        File tempFile = new File(temp + ".json");
        UserProfile tempprof = this;
        try {
            FileWriter a = new FileWriter(tempFile);
            tempFile.createNewFile();
            gson1.toJson(tempprof, a);
            a.close();

        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }


}
