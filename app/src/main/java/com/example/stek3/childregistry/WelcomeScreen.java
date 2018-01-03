package com.example.stek3.childregistry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stek3.childregistry.code.User;

public class WelcomeScreen extends AppCompatActivity {

    db database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent  intent = new Intent(getApplicationContext(),LoginScreen.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();

        initialize();

    }

    private void initialize(){

        database =new db(this);

        database.AddUsers(new User(){
            @Override
            public String getUserName() {
                return "Gilbert";
            }

            @Override
            public String getPassword() {
                return "Password";
            }
        });

    }
}
