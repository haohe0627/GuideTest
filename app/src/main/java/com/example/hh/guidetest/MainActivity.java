package com.example.hh.guidetest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.point1)
    View point1;
    @BindView(R.id.point2)
    View point2;
    @BindView(R.id.point3)
    View point3;
    @BindView(R.id.vp)
    ViewPager vp;

    private View currentView;

    private GuideFragment fragment1;
    private GuideFragment fragment2;
    private GuideFragment fragment3;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        fragment1 = new GuideFragment();
        fragment2 = new GuideFragment();
        fragment3 = new GuideFragment();

        fragment1.setResource(R.drawable.guide1);
        fragment2.setResource(R.drawable.guide2);
        fragment3.setResource(R.drawable.guide3);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return fragment1;
                    case 1:
                        return fragment2;
                    case 2:
                        return fragment3;
                    default:
                        return fragment1;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        selectPoint(point1);
                        break;
                    case 1:
                        selectPoint(point2);
                        break;
                    case 2:
                        selectPoint(point3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        currentView = point1;
        selectPoint(currentView);
    }

    private void  selectPoint(View view){
        if(currentView != null){
            currentView.setSelected(false);
        }
        currentView = view;
        currentView.setSelected(true);
    }
}
