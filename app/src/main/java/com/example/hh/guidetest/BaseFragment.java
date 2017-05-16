package com.example.hh.guidetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by haohe on 2017/5/16 0016.
 */

public abstract class BaseFragment extends Fragment{

    protected View rootView;
    protected Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView != null){
//            ViewGroup parent = (ViewGroup) rootView.getParent();
//            if (parent != null)
//                parent.removeView(rootView);
        }else{
            rootView = inflater.inflate(setLayoutId(), container, false);
            unbinder = ButterKnife.bind(this, rootView);
            init();
        }

        return rootView;
    }

    protected abstract int setLayoutId();
    protected abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
