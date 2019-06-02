package com.upadhyay.newsfeedapplication.ui.login.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.upadhyay.newsfeedapplication.model.IntroContent;
import com.upadhyay.newsfeedapplication.ui.login.fragment.PageFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<IntroContent> introContents;

    public ViewPagerAdapter(FragmentManager fm, List<IntroContent> introContentList) {
        super(fm);
        this.introContents = introContentList;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.getInstance(introContents.get(position));
    }

    @Override
    public int getCount() {
        return introContents != null ? introContents.size() : 0;
    }
}
