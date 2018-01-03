package com.example.stek3.childregistry.views;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Camera;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.stek3.childregistry.R;
import com.example.stek3.childregistry.RegisterPatientActivity;
import com.example.stek3.childregistry.code.returner;
import com.example.stek3.childregistry.register_parents;

/**
 * Created by Stek3 on 27-Dec-17.
 */

public class bio_card extends LinearLayout {

    LayoutInflater inflater;
    Context context;

    EditText FirstName, LastName, MiddleName, DateOfBirth;

    private String Bio_Handler=null;

    public String getBio_Handler(){

        return Bio_Handler;
    }

    public void setBio_Handler(String handler){

        this.Bio_Handler=handler;
    }

    public bio_card(Context context) {
        super(context);
        init(context);
    }

    public bio_card(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public bio_card(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public bio_card(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init(final Context context) {

        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bio_card, this, true);

        FirstName = (EditText) findViewById(R.id.firstname);
        LastName = (EditText) findViewById(R.id.lastname);
        MiddleName = (EditText) findViewById(R.id.middlename);
        DateOfBirth = (EditText) findViewById(R.id.DoB);

        Button CameraButton=(Button) findViewById(R.id.camerabtn);

        final int MY_CAMERA_REQUEST_CODE = 100;

        CameraButton.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                if (((Activity)getContext()).checkSelfPermission(Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ((Activity)getContext()).requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_REQUEST_CODE);

                }

                try {

                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    ((Activity) getContext()).startActivityForResult(intent, 0);
                }
                catch (Exception ex){

                }
            }
        });

        Button UploadButton=(Button) findViewById(R.id.upload);

        UploadButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                ((Activity) getContext()).startActivityForResult(photoPickerIntent,1);
            }
        });

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public returner DataValid() {

        returner returns = new returner();
        returns.result = false;

        if (FirstName.getText().toString().isEmpty()) {

            returns.result = false;
            returns.message = String.format("Please Enter %s's First Name", getBio_Handler());
        } else if (LastName.getText().toString().isEmpty()) {

            returns.result = false;
            returns.message = String.format("Please Enter %s's Last Name", getBio_Handler());
        } else {

            returns.result=true;

        }

        return returns;
    }



}
