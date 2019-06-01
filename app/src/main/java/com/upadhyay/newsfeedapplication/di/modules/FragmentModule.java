package com.upadhyay.newsfeedapplication.di.modules;


import com.upadhyay.newsfeedapplication.ui.introduction.fragmnet.IntroductionFragment;
import com.upadhyay.newsfeedapplication.ui.introduction.fragmnet.PageFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    public abstract IntroductionFragment contributeIntroductionFragment();

    @ContributesAndroidInjector
    public abstract PageFragment contributePageFragment();
}
