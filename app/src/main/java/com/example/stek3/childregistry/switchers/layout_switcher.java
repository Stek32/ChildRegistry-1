package com.example.stek3.childregistry.switchers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Stek3 on 27-Dec-17.
 */

public class layout_switcher {

    Context context;

    public layout_switcher(Context context) {

        this.context = context;
    }

    public void Switch_Layout(View v, LinearLayout Parent) {

        Parent.removeAllViews();

        Parent.addView(v);

    }

}
