package com.example.stek3.childregistry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.stek3.childregistry.views.AddPatient;
import com.example.stek3.childregistry.views.patient_card;

public class MainActivity extends AppCompatActivity {

    AddPatient ap;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_patient_records);

        patient_card pc = new patient_card(this);

        ListView patients = (ListView) findViewById(R.id.patientlist);

        patients.setAdapter(pc);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        this.menu = menu;

        MenuInflater minflator = getMenuInflater();

        minflator.inflate(R.menu.add_patient_button, menu);

        MenuItem addPatientBtn = (MenuItem) menu.findItem(R.menu.add_patient_button);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.registry_adder:

                //this.menu.removeItem(R.id.registry_adder);

                Intent intent = new Intent(this, RegisterPatientActivity.class);
                startActivity(intent);

                return true;

            default:
                return false;
        }
    }

    public void InitializePatientCard(Context context) {

        //patient_card pc=new patient_card(context);

        //  pc.Init(context);

    }

}
