package com.upadhyay.newsfeedapplication.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.upadhyay.newsfeedapplication.db.dao.UserRegistrationDao;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;


@Database(entities = {UserProfile.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserRegistrationDao provideUserRegistrationDao();
}
