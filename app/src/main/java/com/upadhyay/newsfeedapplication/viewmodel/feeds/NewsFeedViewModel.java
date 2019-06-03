package com.upadhyay.newsfeedapplication.viewmodel.feeds;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;
import com.upadhyay.newsfeedapplication.db.table.NewsFeed;

import com.upadhyay.newsfeedapplication.repository.feeds.FeedRepository;
import com.upadhyay.newsfeedapplication.repository.feeds.FeedRepositoryImpl;
import com.upadhyay.newsfeedapplication.ui.feeds.contract.FeedsContract;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

import java.util.List;

import javax.inject.Inject;

public class NewsFeedViewModel extends AbstractViewModel<FeedsContract> implements FeedsContract {

    private FeedRepository feedRepository;

    @Inject
    NewsFeedViewModel(FeedRepositoryImpl feedRepository) {
        this.feedRepository = feedRepository;
    }

    @Override
    public FeedsContract getViewModel() {
        return this;
    }

    @Override
    public LiveData<ResourcesResponse<List<NewsFeed>>> getNewsFeeds() {
        return feedRepository.getNewsFeeds();
    }
}
