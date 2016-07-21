package com.example.chenhj1.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by chenhj1 on 2016/3/23.
 * 动画从下向上滑
 */
public class MyListView extends ListView{
    private Context context;

    public static final int FLING_STATE_FLING_NONE = 0;
    public static final int FLING_STATE_FLING_UP = 1;
    public static final int FLING_STATE_FLING_DOWN = 2;

    public static final int MAX_SPEED = 800;//滑动速度上限，超过则使用此速度

    private LayoutInflater inflater;

    public OnMyListViewScrollListener onMyListViewScrollListener;
    public OnNewPageListener onNewPageListener;

    private int firstVisibleItemFlag = 0;
    private int firstVisibleItemFlagCache = 0;
    private int flingState = 0;//0:不处理 1：上滑 2：下滑

    private long previousEventTime = 0;
    private float speed = 0;//滑动速度

    private int currPageNo = 1;//当前页码

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inflater = LayoutInflater.from(context);
        //设置滑动监听，以便完成滑动速度和滑动状态的测量。注意调用的是super方法。
        super.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (onMyListViewScrollListener != null) {
                    onMyListViewScrollListener.onScrollStateChanged(view, scrollState);
                }

                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE: // 停止滚动
                        //翻页逻辑
                        if (view.getLastVisiblePosition() == view.getCount()-1){
                            MyListView.this.addFooterView(inflater.inflate(R.layout.listview_footerview,null));
                        }
                        firstVisibleItemFlag = firstVisibleItemFlagCache;
                        flingState = FLING_STATE_FLING_NONE;
                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL: // 正在滚动

                        break;
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING: // 手指做了抛的动作（手指离开屏幕前）
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (onMyListViewScrollListener != null) {
                    onMyListViewScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
                }

                //翻页逻辑
                if (view.getLastVisiblePosition() == view.getCount()-1){
                    if(onNewPageListener != null){
                        onNewPageListener.onNewPage(currPageNo+1);
                    }
                }
                //计算滑动速度
                if (firstVisibleItemFlagCache != firstVisibleItem) {
                    long currTime = System.currentTimeMillis();
                    long timeToScrollOneElement = currTime - previousEventTime;
                    speed = ((float) 1 / timeToScrollOneElement) * 80000;
                    firstVisibleItemFlagCache = firstVisibleItem;
                    previousEventTime = currTime;

                }
                //获得滑动状态
                if (firstVisibleItem > firstVisibleItemFlag) {
                    flingState = FLING_STATE_FLING_UP;
                } else if (firstVisibleItem < firstVisibleItemFlag) {
                    flingState = FLING_STATE_FLING_DOWN;
                } else {
                    flingState = FLING_STATE_FLING_NONE;
                }
                firstVisibleItemFlagCache = firstVisibleItem;
            }
        });
    }

    /**
     * 获取滑动速度
     * @return
     */
    public float getSpeed(){
        return speed;
    }

    /**
     * 获取上滑下滑和闲置状态
     * @return
     */
    public int getFlingState(){
        return flingState;
    }

    /**
     * 滑动状态回调接口。OnScrollListener在MyListView中处理其它业务，所以所有滑动都应该也必须走这个接口，完全替代OnScrollListener。
     */
    public interface OnMyListViewScrollListener{
        public void onScrollStateChanged(AbsListView view, int scrollState);
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount);
    }
    /**
     * 设置滑动状态回调接口。完全替代OnScrollListener。
     * @param listener
     */
    public void setOnMyListViewScrollListener(OnMyListViewScrollListener listener){
        onMyListViewScrollListener = listener;
    }

    @Override
    public void setOnScrollListener(OnScrollListener l) {
        //为了防止业务冲突，屏蔽掉用户setOnScrollListener方法。改由setOnMyListViewScrollListener完全替代。
        //super.setOnScrollListener(l);
    }

    /**
     * 列表翻页回调接口。
     */
    public interface OnNewPageListener{
        public void onNewPage(int newPageNo);
    }

    public void setOnNewPageListener(OnNewPageListener listener){
        onNewPageListener = listener;
    }

}
