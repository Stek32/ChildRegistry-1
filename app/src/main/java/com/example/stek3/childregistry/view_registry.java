package com.example.stek3.childregistry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.stek3.childregistry.views.patient_card;

public class view_registry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_patient_records);

        patient_card pc = new patient_card(this);

        // ListView patients=(ListView)findViewById(R.id.patientlist);

        //  patients.setAdapter(pc);

        // patients.setBackgroundColor(Color.BLUE);

    }
}
