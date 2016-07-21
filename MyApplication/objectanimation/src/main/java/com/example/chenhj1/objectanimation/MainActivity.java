package com.example.chenhj1.objectanimation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageview);

        imageView.setPivotX(0);
        imageView.setPivotY(0);
        ObjectAnimator anim = getScaleAnim();
        setAnimDetail(anim);

    }

    private ObjectAnimator getRotateAnim(){
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(imageView,"rotation",0.0f,360.0f);
        return  rotateAnim;
    }

    private ObjectAnimator getScaleAnim(){
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(imageView,"scaleX",0f,1.2f,1.0f,1.5f,1.0f);
        return scaleAnim;
    }

    private ObjectAnimator getBackgroundAnim(){
        ObjectAnimator
    }

    private void setAnimDetail(ObjectAnimator anim){
        anim.setDuration(5000);
        anim.setInterpolator(new AccelerateInterpolator());
//        anim.setRepeatCount(-1);
        anim.setRepeatMode(Animation.RESTART);
        anim.start();
    }
}
