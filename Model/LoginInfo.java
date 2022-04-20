package com.company.Model;

public class LoginInfo {
    private final String username;
    private final String password;

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
