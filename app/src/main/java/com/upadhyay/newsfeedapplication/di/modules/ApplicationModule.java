package com.upadhyay.newsfeedapplication.di.modules;


import android.app.Application;
import android.arch.persistence.room.Room;

import com.upadhyay.newsfeedapplication.db.AppDatabase;
import com.upadhyay.newsfeedapplication.db.dao.UserRegistrationDao;
import com.upadhyay.newsfeedapplication.di.component.ApplicationScope;
import com.upadhyay.newsfeedapplication.utils.AppConstants;
import com.upadhyay.newsfeedapplication.utils.SharedPreferenceHelper;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class})
public class ApplicationModule {


    @ApplicationScope
    @Provides
    AppDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application, AppDatabase.class, AppConstants.DATABASE_NAME).build();
    }

    @ApplicationScope
    @Provides
    SharedPreferenceHelper provideSharedPreference(Application application) {
        return new SharedPreferenceHelper(application);
    }

    @ApplicationScope
    @Provides
    UserRegistrationDao provideUserRegistrationDao(AppDatabase appDatabase) {
        return appDatabase.provideUserRegistrationDao();
    }
}
