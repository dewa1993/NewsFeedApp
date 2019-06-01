package com.upadhyay.newsfeedapplication.di.component;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.upadhyay.newsfeedapplication.NewFeedApplication;
import com.upadhyay.newsfeedapplication.base.fragmnet.InjectableFragment;


import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

public class AppInjector {

    public static void initialize(NewFeedApplication application) {
        DaggerApplicationComponent
                .builder()
                .application(application)
                .build()
                .inject(application);

        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                injectActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                // empty method
            }

            @Override
            public void onActivityResumed(Activity activity) {
                // empty method
            }

            @Override
            public void onActivityPaused(Activity activity) {
                // empty method
            }

            @Override
            public void onActivityStopped(Activity activity) {
                // empty method
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                // empty method
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                // empty method
            }
        });
    }

    private static void injectActivity(Activity activity) {
        if (activity instanceof HasSupportFragmentInjector) {
            AndroidInjection.inject(activity);
        }

        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(
                            new FragmentManager.FragmentLifecycleCallbacks() {
                                @Override
                                public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                                    if (f instanceof InjectableFragment) {
                                        AndroidSupportInjection.inject(f);
                                    }
                                }
                            }, true);
        }
    }
}
