package com.upadhyay.newsfeedapplication.repository.feeds;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.db.table.NewsFeed;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

import org.jsoup.nodes.Document;

import java.util.List;

public interface FeedRepository {

    LiveData<ResourcesResponse<List<NewsFeed>>> getNewsFeeds();

    LiveData<ResourcesResponse<Document>> getCleanUpDocument(String baseUrl);
}
