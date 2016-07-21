package com.example.chenhj1.singletouchgesture;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SingleTouchActivity extends AppCompatActivity {
    private SingleTouchView2 singleTouchView;
    private SingleTouchView2 singleTouchViewTxt;
    private RelativeLayout activityLayout;

    private TextView addText;
    private ImageView addImage1;
    private ImageView addImage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_single_touch);

        activityLayout = (RelativeLayout)findViewById(R.id.activity_layout);

        addImage1 = (ImageView)findViewById(R.id.add_picture_bt1);
        addImage2 = (ImageView)findViewById(R.id.add_picture_bt2);
        addText = (TextView)findViewById(R.id.add_text_bt);

        addImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //activityLayout.removeView(singleTouchView);
                /*singleTouchView = new SingleTouchView2(SingleTouchActivity.this);
                singleTouchView.setImageResource(R.drawable.ic_launcher);
                activityLayout.addView(singleTouchView);
                singleTouchView.setImageResource(R.drawable.ic_launcher);*/

                if (singleTouchView == null) {
                    singleTouchView = new SingleTouchView2(SingleTouchActivity.this);
                    activityLayout.addView(singleTouchView);
                }
                singleTouchView.setImageResource(R.drawable.ic_launcher);
            }
        });

        addImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (singleTouchView == null) {
                    singleTouchView = new SingleTouchView2(SingleTouchActivity.this);
                    activityLayout.addView(singleTouchView);
                }
                singleTouchView.setImageResource(R.drawable.bg);
            }
        });

        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (singleTouchViewTxt == null) {
                    singleTouchViewTxt = new SingleTouchView2(SingleTouchActivity.this);
                    activityLayout.addView(singleTouchViewTxt);
                }
                singleTouchViewTxt.setImageBitamp(createTextBitmap());
//                singleTouchViewTxt.setImageDrawable(createTextDrawable());
            }
        });


        activityLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (singleTouchView != null) {
                    singleTouchView.setEditable(false);
                }
            }
        });


    }

    private Bitmap createTextBitmap(){
        String str = "中国厉害吧";

        Rect rect = new Rect();
        Paint paint  = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(40);
        Canvas canvas = new Canvas();
        canvas.drawText(str, 0, 0, paint);
        paint.getTextBounds(str, 0, str.length(), rect);
        int w = rect.width();
        int h = rect.height();

        Bitmap bitmap = Bitmap.createBitmap(w+10, h+10, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        c.drawText(str, 0, ((paint.getTextSize()-10)+paint.getTextSize())/2, paint);

        return bitmap;
    }

    private Drawable createTextDrawable(){
        BitmapDrawable bitmapDrawable = new BitmapDrawable(){
            @Override
            public void draw(Canvas canvas) {
                super.draw(canvas);
                Paint paint  = new Paint();
                paint.setColor(Color.RED);
                paint.setTextSize(40);
                canvas.drawText("中国牛逼吧", 50, 50, paint);
            }
        };
        return bitmapDrawable;
    }
}
