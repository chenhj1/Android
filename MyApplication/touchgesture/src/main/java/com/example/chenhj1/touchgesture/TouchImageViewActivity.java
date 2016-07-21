package com.example.chenhj1.touchgesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class TouchImageViewActivity extends AppCompatActivity {
    private TouchImageView touchImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Log.e("tag", "0");

        /*TouchImageView img = new TouchImageView(this);
        setContentView(img);*/

        setContentView(R.layout.activity_touch_image_view);
        touchImageView = (TouchImageView)findViewById(R.id.touchImageView);

        /*RelativeLayout r = new RelativeLayout(this);
        TouchImageView img = new TouchImageView(this);
        r.addView(img);
        setContentView(r);*/
    }
}
