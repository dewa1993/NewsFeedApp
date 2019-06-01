package com.upadhyay.newsfeedapplication.base.navigation;

import android.support.v4.app.FragmentManager;

abstract class BaseNavigationController {

    private FragmentManager fragmentManager;

    protected BaseNavigationController(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    protected FragmentManager getFragmentManager() {
        return fragmentManager;
    }


}
