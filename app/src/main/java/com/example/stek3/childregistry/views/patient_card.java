package com.example.stek3.childregistry.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stek3.childregistry.R;

/**
 * Created by Stek3 on 23-Dec-17.
 */

public class patient_card extends BaseAdapter {


    Context Context;
    LayoutInflater inflator;

    String[] myarray = {"Steven", "Gilbert", "Phionah", "Patricia", "Malaika", "Derrick", "Hassan", "Fahad", "Timothy", "Moses", "Denis", "Angel"};
    int[] Age = {2, 3, 4, 5, 66, 65, 43, 524, 5, 23, 5, 32};

    public patient_card(Context context) {

        super();
        this.Context = context;
        inflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {

        return myarray.length;
    }

    @Override
    public Object getItem(int position) {

        return myarray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflator.inflate(R.layout.view_patient_card, parent, false);

        TextView firstname = (TextView) convertView.findViewById(R.id.firstname);
        firstname.setText(myarray[position]);

        TextView age = (TextView) convertView.findViewById(R.id.dateofbirth);
        age.setText(String.valueOf(Age[position]));

        return convertView;

    }
}
