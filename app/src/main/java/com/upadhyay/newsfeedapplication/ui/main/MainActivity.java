package com.upadhyay.newsfeedapplication.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.activity.AbstractBaseMainActivity;
import com.upadhyay.newsfeedapplication.base.activity.AbstractBaseNormalActivity;
import com.upadhyay.newsfeedapplication.databinding.ActivityMainBinding;
import com.upadhyay.newsfeedapplication.ui.ActivityNavigationController;
import com.upadhyay.newsfeedapplication.utils.AppConstants;
import com.upadhyay.newsfeedapplication.utils.SharedPreferenceHelper;

import javax.inject.Inject;

public class MainActivity extends AbstractBaseNormalActivity implements AbstractBaseMainActivity.UiInteraction {


    @Inject
    ActivityNavigationController navigationController;

    @Inject
    SharedPreferenceHelper sharedPreferenceHelper;

    private ActivityMainBinding activityMainBinding;

    @Override
    public ActivityNavigationController getNavigationController() {
        return navigationController;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateToolbar(false, "News Feeds");
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        boolean login = sharedPreferenceHelper.getBoolean(AppConstants.SP_LOGIN);
        if (login)
            navigationController.navigateToNewsFeedExistingFragment();
        else
            navigationController.navigateToIntroduction();
    }

    @Override
    public void setToolbar(boolean visible) {
        if (visible)
            activityMainBinding.toolbar.setVisibility(View.VISIBLE);
        else
            activityMainBinding.toolbar.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            getNavigationController().navigateToLoginScreen();
            sharedPreferenceHelper.putValue(AppConstants.SP_LOGIN, false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
