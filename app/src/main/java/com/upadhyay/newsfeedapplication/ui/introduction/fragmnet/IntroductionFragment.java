/*
 * *
 *  Created by Dewashish on 5/31/19 6:42 PM
 * /
 */
package com.upadhyay.newsfeedapplication.ui.introduction.fragmnet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.upadhyay.newsfeedapplication.R;

import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentIntroductionBinding;
import com.upadhyay.newsfeedapplication.ui.introduction.contract.IntroductionContract;
import com.upadhyay.newsfeedapplication.viewmodel.introduction.IntroductionViewModel;

public class IntroductionFragment extends AbstractBaseMainFragment<IntroductionContract, IntroductionViewModel, FragmentIntroductionBinding> {

    public static IntroductionFragment getInstance() {
        return new IntroductionFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_introduction;
    }

    @Override
    protected Class<IntroductionViewModel> getViewModels() {
        return IntroductionViewModel.class;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getBinding().tvText.setText("test sting in text view...");
    }
}
