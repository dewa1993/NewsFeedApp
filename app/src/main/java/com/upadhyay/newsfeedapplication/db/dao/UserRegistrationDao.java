package com.upadhyay.newsfeedapplication.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.upadhyay.newsfeedapplication.db.table.UserProfile;

@Dao
public interface UserRegistrationDao {

    @Insert
    void registerUser(UserProfile userProfile);

    @Query("SELECT * FROM UserProfile WHERE UserProfile.userName = :userName ")
    UserProfile getUserProfile(String userName);

}
