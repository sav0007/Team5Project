package com.company.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Login {
    private static final String UsersDatabaseFilename = "UserList.json";
    private static UserProfile CurrentUser;
    private static Map<String, LoginInfo> Users;
    
    public static UserProfile getCurrentUser() {
        return CurrentUser;
    }
    public static void createAccount(String username, String pass){

        if(Users == null){
            loadUserList();
        }
        final LoginInfo user = Users.get(username);
        if (user == null) {
            final LoginInfo newUser = new LoginInfo(username, pass);
            Users.put(username, newUser);

            final ArrayList<LoginInfo> users = returnUserList();
            users.add(newUser);
            saveUserList(users);

            final UserProfile profile = new UserProfile(username, pass);
            profile.storeProfile();
        }

    }

    public static boolean checkInfo(final String username, final String password){
        final LoginInfo user = Users.get(username);

        if (user != null) {
            if (password.compareTo(user.getPassword()) == 0) {
                final String tempS = username + password;
                CurrentUser = loadProfile(tempS);
                CurrentUser.setLoginInfo(user);
                return true;
            }
        }

        return false;
    }

    public static void logout(){
        CurrentUser.storeProfile();
        CurrentUser = null;
    }

    public static void enterAsGuest(String Username, String Pass) {
        CurrentUser = new UserProfile(Username, Pass);
    }

    public static UserProfile loadProfile(String prof)
    {
        final Gson gson = new Gson();
        try {
            final FileReader reader = new FileReader(prof + ".json");
            return gson.fromJson(reader, UserProfile.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<LoginInfo> returnUserList(){
        final Gson gson = new Gson();
        final JsonParser jsonParser = new JsonParser();
        try {
            final FileReader reader = new FileReader(UsersDatabaseFilename);
            final Object obj = jsonParser.parse(reader);
            final JsonArray loginInfoJsonObj = (JsonArray) obj;
            final ArrayList<LoginInfo> users = new ArrayList<LoginInfo>();
            for (int i = 0; i < loginInfoJsonObj.size(); i++) {
                final LoginInfo user = gson.fromJson(loginInfoJsonObj.get(i), LoginInfo.class);
                users.add(user);
            }
            return users;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void loadUserList(){
        final Gson gson = new Gson();

        final JsonParser jsonParser = new JsonParser();
        Users = new HashMap<>();

        try {
            final FileReader reader = new FileReader(UsersDatabaseFilename);
            final Object obj = jsonParser.parse(reader);
            final JsonArray loginInfoJsonObj = (JsonArray) obj;
            for (int i = 0; i < loginInfoJsonObj.size(); i++) {
                final LoginInfo user = gson.fromJson(loginInfoJsonObj.get(i), LoginInfo.class);
                Users.put(user.getUsername(), user);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void saveUserList(ArrayList<LoginInfo> users){
        for (int i =0; i < users.size(); i++)
        {
            Gson gson1 = new GsonBuilder()
                    .setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create();
            String temp;
            temp = "UserList";
            File tempFile = new File(temp + ".json");
            try {
                FileWriter a = new FileWriter(tempFile);
                tempFile.createNewFile();
                gson1.toJson(users, a);
                a.close();

            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
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
            ArrayList<LoginInfo> tempUsers = new ArrayList<>(Users.values());
            try {
                FileWriter a = new FileWriter(tempFile);
                tempFile.createNewFile();
                gson1.toJson(tempUsers, a);
                a.close();

            } catch (IOException | IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }



}


