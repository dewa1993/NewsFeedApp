package com.upadhyay.newsfeedapplication.di.component;


import android.app.Application;

import com.upadhyay.newsfeedapplication.NewFeedApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Singleton
@Component(modules = {
        AndroidInjectionModule.class
})
public interface ApplicationComponent {

    void inject(NewFeedApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
