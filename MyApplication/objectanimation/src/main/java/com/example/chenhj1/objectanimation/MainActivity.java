package com.example.chenhj1.objectanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView(){
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageview);
        textView = (TextView)findViewById(R.id.textview);
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(textView,"scaleX",1f,1.5f);
        rotateAnim.setRepeatMode(Animation.REVERSE);
        rotateAnim.setRepeatCount(-1);

        ObjectAnimator rotateAnim2 = ObjectAnimator.ofFloat(textView,"scaleY",1f,1.5f);
        rotateAnim2.setRepeatMode(Animation.REVERSE);
        rotateAnim2.setRepeatCount(-1);

        set.playTogether(rotateAnim,rotateAnim2);
        set.setDuration(1000);
        set.start();

        /*imageView.setPivotX(0);
        imageView.setPivotY(0);
        ObjectAnimator anim = getScaleAnim();
        setAnimDetail(anim);*/

    }

    private ObjectAnimator getRotateAnim(){
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(imageView,"rotation",0.0f,360.0f);
        return  rotateAnim;
    }

    private ObjectAnimator getScaleAnim(){
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(imageView,"scaleXY",0f,1.2f,1.0f,1.5f,1.0f);
        return scaleAnim;
    }

    /*private ObjectAnimator getBackgroundAnim(){
        ObjectAnimator
    }*/

    private void setAnimDetail(ObjectAnimator anim){
        anim.setDuration(5000);
        anim.setInterpolator(new AccelerateInterpolator());
//        anim.setRepeatCount(-1);
        anim.setRepeatMode(Animation.RESTART);
        anim.start();
    }
}
