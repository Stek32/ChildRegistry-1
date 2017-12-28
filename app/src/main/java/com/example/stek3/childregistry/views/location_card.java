package com.example.stek3.childregistry.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.stek3.childregistry.R;

/**
 * Created by Stek3 on 27-Dec-17.
 */

public class location_card extends LinearLayout {

    Context context;
    LayoutInflater inflater;

    public location_card(Context context) {
        super(context);
        init(context);
    }

    public location_card(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public location_card(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public location_card(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init(Context context) {

        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_location_card, this, true);

    }
}
