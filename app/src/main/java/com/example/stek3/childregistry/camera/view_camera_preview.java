package com.example.stek3.childregistry.camera;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.stek3.childregistry.R;

/**
 * Created by Stek3 on 29-Dec-17.
 */

public class view_camera_preview extends LinearLayout {

    private Camera mCamera;
    private CameraPreview mPreview;
    LayoutInflater inflater;

    public view_camera_preview(Context context) {
        super(context);
        Init(context);
    }

    public view_camera_preview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(context);
    }

    public view_camera_preview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public view_camera_preview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void Init(Context context){

        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.camera_preview_layout,this,true);

        try
        {

            mCamera = Camera.open();
        }

        catch (Exception e){

        }

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(context,mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    }
}
