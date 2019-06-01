package com.upadhyay.newsfeedapplication.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.activity.AbstractBaseMainActivity;
import com.upadhyay.newsfeedapplication.base.activity.AbstractBaseNormalActivity;
import com.upadhyay.newsfeedapplication.ui.ActivityNavigationController;

import javax.inject.Inject;

public class MainActivity  extends AbstractBaseNormalActivity implements AbstractBaseMainActivity.UiInteraction {


    @Inject
    ActivityNavigationController navigationController;

    @Override
    public ActivityNavigationController getNavigationController() {
        return navigationController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationController.navigateToIntroduction();

    }
}
