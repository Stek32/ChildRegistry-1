package com.example.stek3.childregistry.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stek3.childregistry.R;
import com.example.stek3.childregistry.db;

/**
 * Created by Stek3 on 23-Dec-17.
 */

public class patient_card extends BaseAdapter {


    Context Context;
    LayoutInflater inflator;
    db Database;

    TextView firstname,lastname,middlename,age;

    String[] myarray = {"Steven", "Gilbert", "Phionah", "Patricia", "Malaika", "Derrick", "Hassan", "Fahad", "Timothy", "Moses", "Denis", "Angel"};
    int[] Age = {2, 3, 4, 5, 66, 65, 43, 524, 5, 23, 5, 32};

    public patient_card(Context context) {

        super();
        this.Context = context;
        inflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        Database=new db(context);


    }

    @Override
    public int getCount() {

        return Database.getPatients().size();
    }

    @Override
    public Object getItem(int position) {

        return Database.getPatients().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflator.inflate(R.layout.view_patient_card, parent, false);

        firstname = (TextView) convertView.findViewById(R.id.firstname);
        firstname.setText(Database.getPatients().get(position).getFirstName());
        lastname= (TextView) convertView.findViewById(R.id.lastname);
        lastname.setText(Database.getPatients().get(position).getLastName());

        //TextView age = (TextView) convertView.findViewById(R.id.dateofbirth);
        //age.setText(String.valueOf(Age[position]));

        return convertView;

    }
}
