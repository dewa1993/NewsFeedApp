package com.upadhyay.newsfeedapplication.ui.feeds.fragment;

import android.support.v4.app.Fragment;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentFeedsBinding;
import com.upadhyay.newsfeedapplication.ui.feeds.contract.FeedsContract;
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
}
