package com.example.chenhj1.photoview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Any implementation of ImageView can be used!
        mImageView = (ImageView) findViewById(R.id.imageview);

        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.picture);
        mImageView.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        // (not needed unless you are going to change the drawable later)
        mAttacher = new PhotoViewAttacher(mImageView);
    }
}
