package com.example.genealogv.entity;

public class User {
    private int User_id;
    private String User_name;
    private String User_password;

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + User_id +
                ", User_name='" + User_name + '\'' +
                ", User_password='" + User_password + '\'' +
                '}';
    }
}
