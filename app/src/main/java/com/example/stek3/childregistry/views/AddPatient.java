package com.example.stek3.childregistry.views;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stek3.childregistry.R;
import com.example.stek3.childregistry.code.child;
import com.example.stek3.childregistry.db;
import com.example.stek3.childregistry.register_parents;

/**
 * Created by Stek3 on 26-Dec-17.
 */

public class AddPatient extends LinearLayout {

    LayoutInflater inflater;
    View RegistryView;
    Button CancelButton;

    TextView FirstName, LastName, MiddleName, DateOfBirth, BirthWeight;


    public AddPatient(Context context) {
        super(context);
        Init(context);

    }

    public AddPatient(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public AddPatient(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public AddPatient(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        super(context, attrs, defStyleAttr, defStyleRes);

    }

    public void Init(final Context context) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        RegistryView = inflater.inflate(R.layout.view_register_child, this, true);

        Button NextButton = (Button) this.findViewById(R.id.next_btn);

        FirstName = (TextView) findViewById(R.id.firstname_edit);
        LastName = (TextView) findViewById(R.id.lastname_edit);
        MiddleName = (TextView) findViewById(R.id.middlename_edit);
        DateOfBirth = (TextView) findViewById(R.id.dateofbirthedit);

        NextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                getChildData();

                Intent intent = new Intent(context, register_parents.class);
                context.startActivity(intent);
            }

        });

        CancelButton = (Button) this.findViewById(R.id.cancelbtn);

        CancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You have clicked the Cancel Button", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getChildData() {

        child Child = new child();

        Child.setFirstName(FirstName.getText().toString());

        Child.setLastName(LastName.getText().toString());

        Child.setMiddleName(MiddleName.getText().toString());

        // Child.setDOB(java.sql.Date.valueOf(DateOfBirth.getText().toString()));

        db Database = new db(getContext());

        boolean result = Database.AddChild(Child);
        String message;


        if (result) {

            message = "You have added a child to the registry";

            LinearLayout ll = (LinearLayout) findViewById(R.id.patients_layout);


        } else {

            message = "Something is wrong with your database";

        }

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }


}
