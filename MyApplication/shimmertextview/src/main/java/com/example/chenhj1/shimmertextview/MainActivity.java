package com.example.chenhj1.shimmertextview;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity {
    private ShimmerTextView shimmerTextView ;
    private ShimmerButton shimmerButton;
    private Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shimmerTextView = (ShimmerTextView)findViewById(R.id.shimmer_tv);
        shimmerButton = (ShimmerButton)findViewById(R.id.shimmer_button);
        shimmer = new Shimmer();
        shimmer.start(shimmerTextView);
        shimmer.start(shimmerButton);


        //可以通过shimmer控制闪闪发亮动画
        shimmer.setRepeatCount(20)
                .setDuration(1000)
                .setStartDelay(300)
                .setDirection(Shimmer.ANIMATION_DIRECTION_LTR);
    }
}
