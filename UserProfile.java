package com.company;
import java.util.ArrayList;

public class UserProfile {

    /**
     *  Setting the attributes of the Class to private
     */
    private String userName; private String password;
    ArrayList<MovieDatabase>Collections = new ArrayList<>();


    public UserProfile(){
        userName = "unknown";
        password = "unknown";
    }

    /**
     Basic constructor for the UserProfile class
     */
    public UserProfile(String user, String pass)
    {
        userName = user;
        password = pass;
    }


    public void changeUsername(String userInput){
        userName = userInput;
    }
    public void changePassword(String passwordInput){
        password = passwordInput;
    }
    public void createCollection(MovieDatabase Collection){
        Collections.add(Collection);
    }
    public void deleteCollection(MovieDatabase Collection){
        Collections.remove(Collection);
    }
    public void addPreference(){

    }
    public void deletePreference(){

    }
}
