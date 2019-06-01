package com.upadhyay.newsfeedapplication.ui;


import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.navigation.AbstractNavigationController;
import com.upadhyay.newsfeedapplication.ui.introduction.fragmnet.IntroductionFragment;
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

    /*
     * fragment not added to back-stack since back-press should close the activity.
     */
    public void navigateToIntroduction(){
        changeFragment(IntroductionFragment.getInstance(),false);
        updateFragment();
    }
}
