package com.upadhyay.newsfeedapplication.ui.feeds.contract;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.base.contract.BaseContract;
import com.upadhyay.newsfeedapplication.db.table.NewsFeed;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;


import org.jsoup.nodes.Document;

import java.util.List;

public interface FeedsContract extends BaseContract {

    LiveData<ResourcesResponse<List<NewsFeed>>> getNewsFeeds();

    LiveData<ResourcesResponse<Document>> getCleanUpDocument(String baseUrl);
}
