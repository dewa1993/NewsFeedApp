package com.upadhyay.newsfeedapplication.base.activity;


import com.upadhyay.newsfeedapplication.ui.ActivityNavigationController;

public abstract class AbstractBaseMainActivity extends AbstractBaseNormalActivity {

    public interface UiInteraction {
        ActivityNavigationController getNavigationController();

        void setToolbar(boolean toolbar);
    }
}
