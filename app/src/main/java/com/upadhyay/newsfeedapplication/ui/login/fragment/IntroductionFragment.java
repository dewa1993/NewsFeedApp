package com.upadhyay.newsfeedapplication.ui.login.fragment;

import android.os.Bundle;

import android.support.annotation.Nullable;

import com.upadhyay.newsfeedapplication.R;

import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentIntroductionBinding;
import com.upadhyay.newsfeedapplication.ui.login.adapter.ViewPagerAdapter;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

public class IntroductionFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentIntroductionBinding> {

    public static IntroductionFragment getInstance() {
        return new IntroductionFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_introduction;
    }

    @Override
    protected Class<LoginViewModel> getViewModels() {
        return LoginViewModel.class;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getViewModel().getIntroContent().observe(this, listResourcesResponse -> {
            if (listResourcesResponse != null && listResourcesResponse.data != null && listResourcesResponse.status == StatusConstant.SUCCESS) {
                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager(), listResourcesResponse.data);
                getBinding().viewPager.setAdapter(viewPagerAdapter);
                getBinding().tabDots.setupWithViewPager(getBinding().viewPager, true);
            }
        });
    }

}
