package cn.tinkling.sample;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.tinkling.widget.PointerView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PointerView pointerView = (PointerView) findViewById(R.id.myPointerView);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        MyPagerAdapter adapter = new MyPagerAdapter();
        viewPager.setAdapter(adapter);

        pointerView.setPointerCount(adapter.getCount());
        pointerView.setCurrentPosition(viewPager.getCurrentItem());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                pointerView.setCurrentPosition(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(container.getContext());
            tv.setTextSize(25);
            tv.setGravity(Gravity.CENTER);
            tv.setText("" + position);

            container.addView(tv);

            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
