package com.example.chenhj1.androidview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
//import android.view.Window;
import com.example.chenhj1.androidview.Window;

/**
 * Created by chenhj1 on 2016/7/18.
 */
public abstract class PhoneWindow extends Window /*implements MenuBuilder.Callback*/{

//    ......

    // This is the top-level view of the window, containing the window decor.
    private ViewPager.DecorView mDecor;

    // This is the view in which the window contents are placed. It is either
    // mDecor itself, or a child of mDecor where the contents go.
    private ViewGroup mContentParent;

    private TextView mTitleView;

    private CharSequence mTitle = null;

    private LayoutInflater mLayoutInflater;
//    ......

    public PhoneWindow(Context context) {
        super(context);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (mContentParent == null) {
            installDecor();
        } else {
            mContentParent.removeAllViews();
        }
        mLayoutInflater.inflate(layoutResID, mContentParent);
        final Callback cb = getCallback();
        if (cb != null) {
            cb.onContentChanged();
        }
    }

    private void installDecor() {
        if (mDecor == null) {
            mDecor = generateDecor();
//            ......
        }
        if (mContentParent == null) {
            mContentParent = generateLayout(mDecor);

            mTitleView = (TextView)findViewById(com.android.internal.R.id.title);
            if (mTitleView != null) {
                if ((getLocalFeatures() & (1 << FEATURE_NO_TITLE)) != 0) {
                    View titleContainer = findViewById(com.android.internal.R.id.title_container);
                    if (titleContainer != null) {
                        titleContainer.setVisibility(View.GONE);
                    } else {
                        mTitleView.setVisibility(View.GONE);
                    }
                    if (mContentParent instanceof FrameLayout) {
                        ((FrameLayout)mContentParent).setForeground(null);
                    }
                } else {
                    mTitleView.setText(mTitle);
                }
            }
        }
    }

//    ......
}
