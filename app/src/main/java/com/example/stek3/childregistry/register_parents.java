package com.example.stek3.childregistry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stek3.childregistry.views.bio_card;

public class register_parents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_parents);


        Button NextButton = (Button) this.findViewById(R.id.next_btn);

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bio_card BioCard = (bio_card) findViewById(R.id.biocard);
                bio_card BioCaard2 = (bio_card) findViewById(R.id.biocard2);

                if (BioCard.DataValid() && BioCaard2.DataValid()) {

                    Toast.makeText(getBaseContext(), "You ave dfg", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getBaseContext(), "You ave not dfg", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}
