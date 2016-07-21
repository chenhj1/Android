package com.example.chenhj1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chenhj1.myapplication.ListViewHolder;
import com.example.chenhj1.myapplication.MyListView;
import com.example.chenhj1.myapplication.R;

import java.util.ArrayList;

/**
 * Created by chenhj1 on 2016/7/8.
 */
public class MyAdapter extends BaseAdapter{

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private LayoutInflater inflater;
    private MyListView listView;

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder = null;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.listview_item_layout, null);
            listViewHolder = new ListViewHolder();
            listViewHolder.textView = (TextView)convertView.findViewById(R.id.textview);
            convertView.setTag(listViewHolder);
        }else {
            listViewHolder = (ListViewHolder)convertView.getTag();
        }
        listViewHolder.textView.setText(String.valueOf(position));


        //上滑动作，设置动画
        if(listView.getFlingState() == listView.FLING_STATE_FLING_UP ){
            TranslateAnimation translateAnimation = new TranslateAnimation(0,0
                    ,listView.getSpeed()> MyListView.MAX_SPEED?MyListView.MAX_SPEED:listView.getSpeed(),0);
            translateAnimation.setDuration(500);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            convertView.startAnimation(translateAnimation);
        }

        return convertView;
    }
}
