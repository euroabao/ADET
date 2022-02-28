package com.abao.onmic;

public class User {
    public String name, address, phonenumber, email, password;

    public User(String name, String address, String phonenumber, String email, String password) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
