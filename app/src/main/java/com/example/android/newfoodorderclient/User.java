package com.example.android.newfoodorderclient;

public class User {
    private String name;
    private String phone;
    private String password;

    public User(String name, String password) {

        this.name = name;
        this.password = password;
        //this.phone= phone;
    }

    public User() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
