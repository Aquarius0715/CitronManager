package com.citronkids.citronkidsmanager.model;

import java.io.Serializable;

public class LoginPageMdl implements Serializable {
    private String username;
    private String password;
    public LoginPageMdl() {
    }
    public LoginPageMdl(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
