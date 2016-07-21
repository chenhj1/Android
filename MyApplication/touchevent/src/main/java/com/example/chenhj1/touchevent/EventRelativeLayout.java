package com.example.chenhj1.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by chenhj1 on 2016/7/11.
 */
public class EventRelativeLayout extends RelativeLayout{
    public EventRelativeLayout(Context context) {
        super(context);
    }

    public EventRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("tag","dispatchTouchEvent RelativeLayout");
//        return super.dispatchTouchEvent(ev);
        super.dispatchTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("tag","onInterceptTouchEvent RelativeLayout ");
        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("tag","onTouchEvent RelativeLayout");
        return super.onTouchEvent(event);
//        return true;
    }
}
