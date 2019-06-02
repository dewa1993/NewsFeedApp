package com.upadhyay.newsfeedapplication.di.modules;


import com.upadhyay.newsfeedapplication.ui.login.fragment.IntroductionFragment;
import com.upadhyay.newsfeedapplication.ui.login.fragment.PageFragment;
import com.upadhyay.newsfeedapplication.ui.login.fragment.LoginFragment;
import com.upadhyay.newsfeedapplication.ui.login.fragment.RegisterUserFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector
    public abstract IntroductionFragment contributeIntroductionFragment();

    @ContributesAndroidInjector
    public abstract PageFragment contributePageFragment();

    @ContributesAndroidInjector
    public abstract LoginFragment contributeLoginFragment();

    @ContributesAndroidInjector
    public abstract RegisterUserFragment contributeRegisterFragment();
}
