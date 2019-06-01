package com.upadhyay.newsfeedapplication.ui.introduction.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.upadhyay.newsfeedapplication.ui.introduction.fragmnet.PageFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return PageFragment.getInstance();
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
