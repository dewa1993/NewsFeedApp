package com.upadhyay.newsfeedapplication.ui.feeds.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentFeedsBinding;
import com.upadhyay.newsfeedapplication.ui.feeds.contract.FeedsContract;
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.feeds.NewsFeedViewModel;

public class NewsFeedsFragment extends AbstractBaseMainFragment<FeedsContract, NewsFeedViewModel, FragmentFeedsBinding> {

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

        getViewModel().getNewsFeeds().observe(this, listResourcesResponse -> {
            getBinding().setResource(listResourcesResponse);
            if (listResourcesResponse != null && listResourcesResponse.data != null && listResourcesResponse.status == StatusConstant.SUCCESS) {
                Toast.makeText(getContext(), "list size" + listResourcesResponse.data.size(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
