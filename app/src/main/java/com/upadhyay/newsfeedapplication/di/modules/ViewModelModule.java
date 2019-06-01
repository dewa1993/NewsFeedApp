package com.upadhyay.newsfeedapplication.di.modules;

import android.arch.lifecycle.ViewModelProvider;
import com.upadhyay.newsfeedapplication.base.viewmodel.BaseViewModelFactory;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);
}
