package com.upadhyay.newsfeedapplication.di.component;


import android.app.Application;

import com.upadhyay.newsfeedapplication.NewFeedApplication;
import com.upadhyay.newsfeedapplication.di.modules.ActivityModule;
import com.upadhyay.newsfeedapplication.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        ActivityModule.class
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
