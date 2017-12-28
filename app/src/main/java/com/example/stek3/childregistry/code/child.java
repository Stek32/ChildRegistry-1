package com.example.stek3.childregistry.code;

/**
 * Created by Stek3 on 22-Dec-17.
 */

public class child extends person {


    private person Father;
    private person Mother;

    public person getFather() {
        return Father;

    }

    public void setFather(person father) {

        this.Father = father;
    }

    public person getMother() {
        return Mother;
    }

    public void setMother(person mother) {
        this.Mother = mother;
    }


    //Other Methods like Vaccination Methods from OpenSRP are handled thereafter from here
}
