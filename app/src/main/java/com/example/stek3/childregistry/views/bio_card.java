package com.example.stek3.childregistry.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.stek3.childregistry.R;

/**
 * Created by Stek3 on 27-Dec-17.
 */

public class bio_card extends LinearLayout {

    LayoutInflater inflater;
    Context context;

    EditText FirstName, LastName, MiddleName, DateOfBirth;

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

    public void init(Context context) {

        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.bio_card, this, true);

        FirstName = (EditText) findViewById(R.id.firstname);
        LastName = (EditText) findViewById(R.id.lastname);
        MiddleName = (EditText) findViewById(R.id.middlename);
        DateOfBirth = (EditText) findViewById(R.id.DoB);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public boolean DataValid() {

        if (FirstName.getText().length() != 0 && LastName.getText().length() != 0 && MiddleName.getText().length() != 0) {

            return true;
        } else {

            return false;
        }

    }

}
