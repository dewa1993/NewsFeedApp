package com.upadhyay.newsfeedapplication.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.upadhyay.newsfeedapplication.base.viewmodel.BaseViewModelFactory;
import com.upadhyay.newsfeedapplication.di.component.ViewModelKey;
import com.upadhyay.newsfeedapplication.viewmodel.feeds.NewsFeedViewModel;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);


    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    public abstract ViewModel bingLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedViewModel.class)
    public abstract ViewModel bindNewsFeedViewModel(NewsFeedViewModel newsFeedViewModel);


}
