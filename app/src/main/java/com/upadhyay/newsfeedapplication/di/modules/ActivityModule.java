package com.upadhyay.newsfeedapplication.di.modules;

import com.upadhyay.newsfeedapplication.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = FragmentModule.class)
    public abstract MainActivity contributeMainActivity();

}
