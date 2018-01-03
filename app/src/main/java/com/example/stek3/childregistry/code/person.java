package com.example.stek3.childregistry.code;

import java.util.Date;

/**
 * Created by Stek3 on 22-Dec-17.
 */

public abstract class person {


    private int ID;
    private String FirstName;
    private String LastName;
    private String MiddleName;
    private Date DOB;
    private int Gender;

    public int getID(){

        return ID;
    }

    public void setID(int id){

        this.ID=id;
    }

    public String getFirstName() {

        return FirstName;
    }

    public void setFirstName(String firstName) {


            this.FirstName = firstName;

    }

    public String getLastName() {

        return LastName;
    }

    public void setLastName(String lastName) {

        this.LastName = lastName;
    }

    public String getMiddleName() {

        return MiddleName;
    }

    public void setMiddleName(String middleName) {

        this.MiddleName = middleName;
    }

    public Date getDOB() {

        return DOB;
    }

    public void setDOB(Date dob) {

        this.DOB = dob;
    }
}
