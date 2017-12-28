package com.example.stek3.childregistry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class RegisterPatientActivity extends AppCompatActivity {


    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_patient_register_content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        this.menu = menu;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return true;
    }
}
