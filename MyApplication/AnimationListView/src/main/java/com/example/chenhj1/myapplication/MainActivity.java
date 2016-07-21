package com.example.chenhj1.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MyListView.OnNewPageListener {

    private MyListView listView;
    private LayoutInflater inflater;

    private BaseAdapter listViewAdapter;//测试用

    private ArrayList<Integer>arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView(){
        inflater = getLayoutInflater();
        listView = (MyListView)findViewById(R.id.listView);

    }

    private void initData(){
        expendArrayList();
        listViewAdapter = new BaseAdapter() {
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
                            ,listView.getSpeed()>MyListView.MAX_SPEED?MyListView.MAX_SPEED:listView.getSpeed(),0);
                    translateAnimation.setDuration(500);
                    translateAnimation.setInterpolator(new DecelerateInterpolator());
                    convertView.startAnimation(translateAnimation);
                }

                return convertView;
            }
        };

        listView.setAdapter(listViewAdapter);
        listView.setOnNewPageListener(this);
    }

    public void expendArrayList(){
        int size = arrayList.size();
        if(size>50)
            return;
        for(int i=0;i<20;i++){
            arrayList.add(size+i);
        }
    }


    @Override
    public void onNewPage(int newPageNo) {
        expendArrayList();
        listViewAdapter.notifyDataSetChanged();
    }
}
