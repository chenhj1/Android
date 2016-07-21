package com.example.chenhj1.parallaxviewpager;

import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cn.yangbingqiang.android.parallaxviewpager.ParallaxViewPager;
import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {
    private ParallaxViewPager viewPager;
    private List<View>imageList = new ArrayList<>();
    private LayoutInflater inflater;

    private PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageList();
        viewPager = (ParallaxViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(pagerAdapter);
    }

    private void initImageList(){
        inflater = getLayoutInflater();
        for(int i = 0;i<3;i++){
            View v = inflater.inflate(R.layout.viewpager_item_view,null);

            //以下注释的代码供缩放功能使用
            /*ImageView imageView = (ImageView) v.findViewById(R.id.imageview);
            // Set the Drawable displayed
            Drawable bitmap = getResources().getDrawable(R.drawable.picture);
            imageView.setImageDrawable(bitmap);

            // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
            // (not needed unless you are going to change the drawable later)
            mAttacher = new PhotoViewAttacher(imageView);*/

            imageList.add(v);
        }
    }

    private class ViewPagerAdapter extends PagerAdapter {

        // 获取要滑动的控件的数量，在这里我们以滑动的广告栏为例，那么这里就应该是展示的广告图片的ImageView数量
        @Override
        public int getCount() {
            return imageList.size();
        }

        // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        // PagerAdapter只缓存三张要显示的图片，如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片销毁
        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView(imageList.get(position));
        }

        // 当要显示的图片可以进行缓存的时候，会调用这个方法进行显示图片的初始化，我们将要显示的ImageView加入到ViewGroup中，然后作为返回值返回即可
        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            view.addView(imageList.get(position));
            return imageList.get(position);
        }
    }


}
