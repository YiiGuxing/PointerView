# PointerView
ViewPagerIndicator

![PointerView Sample Screenshots][1]

用法：
=====

Gradle

        compile 'cn.tinkling.pointerview:pointerview:1.0.0@aar'

Maven

        <dependency>
            <groupId>cn.tinkling.pointerview</groupId>
            <artifactId>pointerview</artifactId>
            <version>1.0.0</version>
            <type>aar</type>
        </dependency>

1.drawable(pointer_selector.xml):

        <selector xmlns:android="http://schemas.android.com/apk/res/android">
            <item android:state_selected="true" android:drawable="@drawable/pointer_selected"/>
            <item android:drawable="@drawable/pointer"/>
        </selector>
        
2.layout xml:

        <cn.tinkling.pointerview.PointerView xmlns:app="http://schemas.android.com/apk/res-auto"
            android:id="@+id/pointerView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:pointerDrawable="@drawable/pointer"
            app:spacing="fill_center" />
            
3.code:

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ...
        final PointerView pointerView = (PointerView) findViewById(R.id.pointerView);
        pointerView.setPointerCount(viewPager.getAdapter().getCount());
        pointerView.setCurrentPosition(viewPager.getCurrentItem());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            pointerView.setCurrentPosition(position, positionOffset);
          }
          
          @Override
          public void onPageSelected(int position) {}
          
          @Override
          public void onPageScrollStateChanged(int state) {}
        });
        ...



[1]: https://raw.githubusercontent.com/Tinkling/PointerView/master/sample/sample.gif
