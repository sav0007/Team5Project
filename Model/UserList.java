package com.company.Model;

public class UserList {


    private String username;
    private String password;

    /**
     * default constructor for UserList
     */
    public UserList() {
        this.username = null;
        this.password = null;
    }

    /**
     * Parameterized Constructor
     * @param username the username that is to be set for the new user
     * @param password the password that is to be set for the new user
     */
    public UserList(String username, String password) {
        this.username = username;
        this.password = password;
    }


    /**
     *  getter for username
     * @return username value
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for username
     * @param username String that is to replace the current username value
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for password
     * @return password value
     */
    public String getPassword() {
        return password;
    }

    /**
     *  setter for password
     * @param password the String value that is to replace the current password value
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
