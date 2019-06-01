package com.upadhyay.newsfeedapplication.base.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.upadhyay.newsfeedapplication.R;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class AbstractBaseNormalActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    public void updateToolbar(final boolean isBackNavigation, final String title, final ToolbarListener toolbarListener) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar == null) {
            return;
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(isBackNavigation);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setTitle(title);

        toolbar.setNavigationOnClickListener(view -> {
            if (toolbarListener == null) {
                onBackPressed();
            } else {
                toolbarListener.toolbarButtonPressed();
            }
        });
    }


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    public interface ToolbarListener {
        void toolbarButtonPressed();
    }

}
