package com.upadhyay.newsfeedapplication.di.modules;


import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import com.upadhyay.newsfeedapplication.db.AppDatabase;
import com.upadhyay.newsfeedapplication.db.dao.NewsFeedDao;
import com.upadhyay.newsfeedapplication.db.dao.UserRegistrationDao;
import com.upadhyay.newsfeedapplication.di.component.ApplicationScope;
import com.upadhyay.newsfeedapplication.network.helper.LiveDataCallAdapterFactory;
import com.upadhyay.newsfeedapplication.network.NewsService;
import com.upadhyay.newsfeedapplication.utils.AppConstants;
import com.upadhyay.newsfeedapplication.utils.SharedPreferenceHelper;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


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
    @ApplicationScope
    @Provides
    NewsFeedDao provideNewsFeedDao(AppDatabase appDatabase) {
        return appDatabase.provideNewsFeedDao();
    }


    /*
     * SimpleXmlConverterFactory is deprecated without any replacement for Retrofit
     */

    @ApplicationScope
    @Provides
    NewsService getNewsNetworkService(Application application) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            @NonNull
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("Connection", "close").build();
                return chain.proceed(request);
            }
        }).build();

        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://feeds.news24.com/")
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(
                        new Persister(new AnnotationStrategy())))
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(NewsService.class);

    }
}
