package com.company.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
public class Login extends UserProfile {

    /**
     * This array stores the Users that will be created for the UserProfile type
     */
    ArrayList<UserList>Users = new ArrayList<>();



    private UserProfile User;
    /**
     * Basic constructor for the UserProfile class
     * @param user : UserProfile userName field
     * @param pass : UserProfile password field
     */
    public Login(String user, String pass) {
        super(user, pass);
    }

    public Login(){

    }


    /**
     * checkUserPass checks if the
     * @param aUser : UserProfile userName field
     * @param aPass : UserProfile password field
     * @return Returns true if the data fields matches up to a saved user. False otherwise
     */
    public boolean checkUserPass(String aUser, String aPass) {
        UserProfile tempUser = new UserProfile(aUser, aPass);
        if(Users.contains(tempUser)){
            return true;
        }
        return false;
    }

    /**
     * This method creates a new object with the entered fields and adds it to the arraylist
     * @param aUser : UserProfile userName field
     * @param aPass : UserProfile password field
     */
    public void createUser(String aUser, String aPass) { // needs more still
        UserList newUser = new UserList(aUser, aPass);
        Users.add(newUser);
    }

    /**
     * This function creates a tempUser with a garbage username and password
     * The garbage is used to iterate a new UserProfile object but
     * not one that will be saved under the arraylist
     */
    public void enterGuest() {
        String user = "Guest";
        String pass = "1234";
        UserProfile tempUser = new UserProfile(user, pass);
    }

    public UserProfile loadProfile(String prof)
    {
        Gson gson = new Gson();
        UserProfile bruh = new UserProfile();
        try {
            FileReader reader = new FileReader(prof + ".json");
            bruh = gson.fromJson(reader, UserProfile.class);
            User = bruh;
            return bruh;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bruh;
    }

    public UserProfile getUser() {
        return User;
    }
    public void setUser(UserProfile user) {
        User = user;
    }

    public void storeUserList(){
        for (int i =0; i < Users.size(); i++)
        {
            Gson gson1 = new GsonBuilder()
                    .setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create();
            String temp;
            temp = "UserList";
            File tempFile = new File(temp + ".json");
            ArrayList<UserList> tempUsers = Users;
            try {
                FileWriter a = new FileWriter(tempFile);
                tempFile.createNewFile();
                gson1.toJson(tempUsers, a);
                a.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (IllegalStateException e){
                e.printStackTrace();
            }
        }
    }

    public ArrayList<UserList> loadUserList(){
        Gson gson = new Gson();
        JsonArray tempuserList = new JsonArray();
        JsonParser jsonParser = new JsonParser();
        ArrayList<UserList> bruh = new ArrayList<>();
        try {
            FileReader reader = new FileReader("UserList.json");
            Object obj = jsonParser.parse(reader);
            tempuserList = (JsonArray) obj;
            UserList tempUL = new UserList();
            for (int i = 0; i < tempuserList.size(); i++) {
                tempUL = gson.fromJson(tempuserList.get(i), UserList.class);
                bruh.add(tempUL);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Users = bruh;
        return bruh;
    }

    public boolean checkInfo (String Username, String Pass){
        for (int i = 0; i < Users.size(); i++){
            if(Username.compareTo(Users.get(i).getUsername()) == 0 && Pass.compareTo(Users.get(i).getPassword()) == 0){
                String tempS = Username + Pass;
                User = loadProfile(tempS);
                return true;
            }
        }
        return false;
    }


}

