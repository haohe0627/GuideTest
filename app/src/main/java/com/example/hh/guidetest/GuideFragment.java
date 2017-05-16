package com.example.hh.guidetest;

import android.widget.ImageView;

import butterknife.BindView;

/**
 * Created by haohe on 2017/5/16 0016.
 */

public class GuideFragment extends BaseFragment {

    @BindView(R.id.img)
    ImageView imageView;

    private int resId;

    @Override
    protected int setLayoutId() {
        return R.layout.guide_fragment;
    }

    @Override
    protected void init() {
        imageView.setBackgroundResource(resId);
    }

    public void setResource(int resId){
        this.resId = resId;
    }
}
