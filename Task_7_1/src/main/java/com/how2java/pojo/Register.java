package com.how2java.pojo;

/**
 * Created by Administrator on 2017/7/18.
 */
public class Register {
    private String username;
    private String email;
    private String password;
    private String portraitpath;


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPortraitpath(String portraitpath) {
        this.portraitpath = portraitpath;
    }

    public String getPortraitpath() {
        return portraitpath;
    }
    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", portraitpath='" + portraitpath + '\'' +
                '}';
    }
}
