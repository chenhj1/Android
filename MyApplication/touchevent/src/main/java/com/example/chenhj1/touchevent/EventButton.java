package com.example.chenhj1.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by chenhj1 on 2016/7/11.
 */
class EventButton extends Button {
    public EventButton(Context context) {
        super(context);
    }

    public EventButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("tag","dispatchTouchEvent Button");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("tag","onTouchEvent Button");
        return super.onTouchEvent(event);
//        return false;
    }
}
