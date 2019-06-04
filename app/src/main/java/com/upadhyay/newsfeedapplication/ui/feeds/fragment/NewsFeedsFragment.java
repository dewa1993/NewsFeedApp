package com.upadhyay.newsfeedapplication.ui.feeds.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentFeedsBinding;
import com.upadhyay.newsfeedapplication.db.table.NewsFeed;
import com.upadhyay.newsfeedapplication.ui.feeds.adapter.FeedItemAdapter;
import com.upadhyay.newsfeedapplication.ui.feeds.adapter.RecyclerViewClickListener;
import com.upadhyay.newsfeedapplication.ui.feeds.contract.FeedsContract;
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.feeds.NewsFeedViewModel;

import java.util.List;

public class NewsFeedsFragment extends AbstractBaseMainFragment<FeedsContract, NewsFeedViewModel, FragmentFeedsBinding>
        implements RecyclerViewClickListener {

    private FeedItemAdapter feedItemAdapter;

    public static Fragment getInstance() {
        return new NewsFeedsFragment();
    }

    @Override
    protected Class<NewsFeedViewModel> getViewModels() {
        return NewsFeedViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_feeds;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getUiInteraction().setToolbar(true);

        getBinding().swipeContainer.setRefreshing(true);
        getViewModel().getNewsFeeds().observe(this, listResourcesResponse -> {
            if (listResourcesResponse != null && listResourcesResponse.data != null && listResourcesResponse.status == StatusConstant.SUCCESS) {
                setViewFromResult(listResourcesResponse.data);
                getBinding().swipeContainer.setRefreshing(false);
            }
        });

        getBinding().swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


        getBinding().swipeContainer.setOnRefreshListener(() -> {

            getViewModel().getNewsFeeds().observe(this, listResourcesResponse -> {
                if (listResourcesResponse != null && listResourcesResponse.data != null && listResourcesResponse.status == StatusConstant.SUCCESS) {
                    feedItemAdapter.clear();
                    feedItemAdapter.addAll(listResourcesResponse.data);
                    getBinding().swipeContainer.setRefreshing(false);
                }
            });
        });
    }

    private void setViewFromResult(List<NewsFeed> newsFeeds) {

        feedItemAdapter = new FeedItemAdapter(newsFeeds, this);
        RecyclerView.LayoutManager rvLayoutManager = new LinearLayoutManager(getContext());
        getBinding().rvFeeds.setLayoutManager(rvLayoutManager);
        getBinding().rvFeeds.setAdapter(feedItemAdapter);

    }

    @Override
    public void onRowClicked(NewsFeed newsFeed, int position) {
        getUiInteraction().getNavigationController().navigateToFeedDetails(newsFeed.getLink());
    }

}
