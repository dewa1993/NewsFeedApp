package com.upadhyay.newsfeedapplication.ui.introduction.fragmnet;

import android.support.v4.app.Fragment;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentPageBinding;
import com.upadhyay.newsfeedapplication.ui.introduction.contract.IntroductionContract;
import com.upadhyay.newsfeedapplication.viewmodel.introduction.IntroductionViewModel;

public class PageFragment extends AbstractBaseMainFragment<IntroductionContract, IntroductionViewModel, FragmentPageBinding> {

    public static Fragment getInstance() {
        return new PageFragment();
    }

    @Override
    protected Class<IntroductionViewModel> getViewModels() {
        return IntroductionViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_page;
    }
}
