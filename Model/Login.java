package com.company;
import java.util.ArrayList;
public class Login extends UserProfile {

    /**
     * This array stores the Users that will be created for the UserProfile type
     */
    ArrayList<UserProfile>Users = new ArrayList<>();

    /**
     * Basic constructor for the UserProfile class
     * @param user : UserProfile userName field
     * @param pass : UserProfile password field
     */
    public Login(String user, String pass) {
        super(user, pass);
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
    public void createUser(String aUser, String aPass) {
        UserProfile newUser = new UserProfile(aUser, aPass);
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
}

