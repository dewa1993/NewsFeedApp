package com.upadhyay.newsfeedapplication.ui;


import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.navigation.AbstractNavigationController;
import com.upadhyay.newsfeedapplication.ui.feeds.fragment.NewsFeedsFragment;
import com.upadhyay.newsfeedapplication.ui.login.fragment.IntroductionFragment;
import com.upadhyay.newsfeedapplication.ui.login.fragment.LoginFragment;
import com.upadhyay.newsfeedapplication.ui.login.fragment.RegisterUserFragment;
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
    public void navigateToIntroduction() {
        changeFragment(IntroductionFragment.getInstance(), false);
        updateFragment();
    }

    /*
     * fragment not added to back-stack since back-press should close the activity.
     */
    public void navigateToLoginScreen() {
        changeFragment(LoginFragment.getInstance(), false);
        updateFragment();
    }

    public void navigateToRegisterScreen() {
        changeFragment(RegisterUserFragment.getInstance(), true);
        updateFragment();
    }

    public void navigateToNewsFeedFragment() {
        changeFragment(NewsFeedsFragment.getInstance(), false);
        updateFragment();
    }
}
