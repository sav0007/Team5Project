package com.company.Model;

public class UserList {


    private String username;
    private String password;

    public UserList() {
        this.username = null;
        this.password = null;
    }


    public UserList(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
