package com.company;

import com.company.Model.Collections;
import com.company.Model.Login;
import com.company.Model.MovieDatabase;
import com.company.Model.UserProfile;
import com.company.View.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	LoginPage Login = new LoginPage();
    /*
    Login login = new Login();
    login.loadProfile("Willsure");
        JFrame frame = new JFrame();
        MainPage m1 = new MainPage();
      //  int i = 28;
        m1.createPage(frame, null, null,login.getUser());

     */
    Login.login();













    }
}


/*

//LoginPage Login = new LoginPage();
    Login login = new Login();
    //login.loadProfile("Willsure");
    //Login.login();
    //login.createUser("Will", "Sure");
    //login.createUser("test", "1");
    //login.createUser("test", "2");
    //login.storeUserList();
        login.loadUserList();


        MovieDatabase bruh = new MovieDatabase();
        Collections test = new Collections();
        test.setCollectionname("test collect name");
        test.setDescription("test desc name");

        bruh.buildDatabaseJson("SampleMovieFile (2).json");
        test.setDatabase(bruh.filterMPAA("R"));
        //bruh.sortAlphaAZ();
        MovieDescription swag = new MovieDescription();
        JFrame frame = new JFrame();
        MainPage m1 = new MainPage();
        int i = 28;
        // m1.createPage(frame, bruh.getMovies().get(i));
        // LoginPage l1 = new LoginPage();
        // l1.login();
        bruh.buildDatabaseJson("SampleMovieFile (2).json");

        UserProfile prof = new UserProfile();
        prof.changeUsername("Test");
        prof.changePassword("2");
        prof.addPreference("Action");
        prof.addPreference("Adventure");
        //prof.addPreference("Drama");
        prof.createCollection(test);
        prof.storeProfile();






 UserProfile prof = new UserProfile();
        prof.changeUsername("Will");
        prof.changePassword("sure");
        MovieDatabase bruh = new MovieDatabase();
        Collections test = new Collections();
        test.setCollectionname("test collect name");
        test.setDescription("test desc name");
        bruh.buildDatabaseJson("SampleMovieFile (2).json");
        test.setDatabase(bruh.filterMPAA("R"));
        prof.addPreference("Action");
        prof.addPreference("Adventure");
        prof.addPreference("Drama");
        prof.createCollection(test);
        Collections test1 = new Collections();
        test1.setMovies(bruh.filterGenre("Action, Adventure, Drama"));
        test1.setDescription("Collection 2 Test Description");
        test1.setCollectionname("asdasdwdedsdse");
        prof.createCollection(test1);
        prof.storeProfile();
 */