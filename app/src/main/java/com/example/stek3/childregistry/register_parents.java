package com.example.stek3.childregistry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.stek3.childregistry.views.bio_card;

import java.io.IOException;

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
                BioCard.setBio_Handler("Father");
                BioCaard2.setBio_Handler("Mother");


                if (!BioCard.DataValid().result)
                {
                    Toast.makeText(getBaseContext(), BioCard.DataValid().message, Toast.LENGTH_SHORT).show();

                }

                else if(!BioCaard2.DataValid().result) {

                    Toast.makeText(getBaseContext(), BioCaard2.DataValid().message, Toast.LENGTH_SHORT).show();



                } else {

                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(),"Registration Successful", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.profileview);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
