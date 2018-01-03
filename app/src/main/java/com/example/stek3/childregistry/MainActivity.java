package com.example.stek3.childregistry;

import android.app.Application;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.stek3.childregistry.views.AddPatient;
import com.example.stek3.childregistry.views.patient_card;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    AddPatient ap;
    Menu menu;
    SearchView searchView;
    MenuItem searchMenuItem;

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

//        minflator.inflate(R.menu.search_menu,menu);
//
//        SearchManager searchManager = (SearchManager)
//                getSystemService(Context.SEARCH_SERVICE);
//
//        searchMenuItem = menu.findItem(R.id.search);
//        searchView = (SearchView) searchMenuItem.getActionView();
//
//        searchView.setSearchableInfo(searchManager.
//                getSearchableInfo(getComponentName()));
//        searchView.setSubmitButtonEnabled(true);
//        searchView.setOnQueryTextListener(this);


        MenuItem addPatientBtn = (MenuItem) menu.findItem(R.menu.add_patient_button);

        return true;
    }

    @Override
    public void onBackPressed(){

       // finish();
       // Toast.makeText(this,"Sorry, Can't go back",Toast.LENGTH_LONG).show();
      //  System.exit(0);

        moveTaskToBack(true);
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


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
