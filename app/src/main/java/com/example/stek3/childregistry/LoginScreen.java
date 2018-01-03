package com.example.stek3.childregistry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    EditText UserName,Password;
    db database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        database=new db(this);

        UserName=(EditText)findViewById(R.id.usernameedit);
        Password=(EditText)findViewById(R.id.passwordedit);

        Button LoginButton=(Button) findViewById(R.id.login_btn);
        LoginButton.setOnClickListener(new View.OnClickListener() {

             @Override
            public void onClick(View v) {


                if(database.Authenticated(UserName.getText().toString(),Password.getText().toString())){

                     Intent intent=new Intent(getBaseContext(),MainActivity.class);
                     startActivity(intent);

                 }
                 else {

                    Toast.makeText(getBaseContext(),"Sorry, Wrong User Name orr Password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }





}
