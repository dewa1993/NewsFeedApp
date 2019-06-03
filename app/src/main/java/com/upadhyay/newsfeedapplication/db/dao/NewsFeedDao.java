package com.upadhyay.newsfeedapplication.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.upadhyay.newsfeedapplication.db.table.NewsFeed;

import java.util.List;

@Dao
public interface NewsFeedDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void updateNewFeeds(List<NewsFeed> newsFeedList);


    @Query("SELECT * FROM NewsFeed")
    List<NewsFeed> getAllNewsFeeds();
}
