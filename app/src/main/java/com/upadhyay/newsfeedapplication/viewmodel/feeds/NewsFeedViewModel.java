package com.upadhyay.newsfeedapplication.viewmodel.feeds;

import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;
import com.upadhyay.newsfeedapplication.ui.feeds.contract.FeedsContract;

import javax.inject.Inject;

public class NewsFeedViewModel extends AbstractViewModel<FeedsContract> implements FeedsContract {

    @Inject
    NewsFeedViewModel() {
    }

    @Override
    public FeedsContract getViewModel() {
        return this;
    }
}
