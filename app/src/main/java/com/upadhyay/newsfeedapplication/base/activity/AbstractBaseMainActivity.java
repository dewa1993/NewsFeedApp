package com.upadhyay.newsfeedapplication.base.activity;


import com.upadhyay.newsfeedapplication.base.navigation.ActivityNavigationController;

public abstract class AbstractBaseMainActivity extends AbstractBaseNormalActivity {

    public interface UiInteraction {
        ActivityNavigationController getNavigationController();
    }
}
