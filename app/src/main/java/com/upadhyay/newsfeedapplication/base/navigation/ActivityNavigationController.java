package com.upadhyay.newsfeedapplication.base.navigation;


import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.navigation.AbstractNavigationController;
import com.upadhyay.newsfeedapplication.ui.main.MainActivity;

import javax.inject.Inject;

public class ActivityNavigationController extends AbstractNavigationController {

    @Inject
    ActivityNavigationController(MainActivity mainActivity) {
        super(mainActivity);
    }

    @Override
    protected int provideContainerId() {
        return R.id.container;
    }
}
