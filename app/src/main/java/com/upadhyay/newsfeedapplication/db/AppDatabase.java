package com.upadhyay.newsfeedapplication.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.upadhyay.newsfeedapplication.db.dao.NewsFeedDao;
import com.upadhyay.newsfeedapplication.db.dao.UserRegistrationDao;
import com.upadhyay.newsfeedapplication.db.table.NewsFeed;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;


@Database(entities = {UserProfile.class, NewsFeed.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserRegistrationDao provideUserRegistrationDao();

    public abstract NewsFeedDao provideNewsFeedDao();
}
