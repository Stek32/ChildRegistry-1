package com.example.stek3.childregistry.code;

/**
 * Created by Stek3 on 29-Dec-17.
 */

public class User extends person {


    private String UserName;
    private String Password;

    public String getUserName(){

        return  UserName;
    }

    public void setUserName(String Username){

        this.UserName=Username;
    }

    public String getPassword(){

        return Password;
    }

    public void setPassword(String Password){

        this.Password=Password;
    }
}
