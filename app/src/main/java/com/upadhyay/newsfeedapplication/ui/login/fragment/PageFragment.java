package com.upadhyay.newsfeedapplication.ui.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.bumptech.glide.Glide;
import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentPageBinding;
import com.upadhyay.newsfeedapplication.model.IntroContent;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

public class PageFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentPageBinding> {

    private IntroContent introContent;
    private static final int LAST_PAGE = 3;

    public static Fragment getInstance(IntroContent introContent) {
        PageFragment pageFragment = new PageFragment();
        pageFragment.introContent = introContent;
        return pageFragment;
    }

    @Override
    protected Class<LoginViewModel> getViewModels() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_page;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUiInteraction().setToolbar(false);
        Glide.with(this).
                load(introContent.getImagePath()).
                into(getBinding().ivBackground);
        getBinding().tvDescription.setText(introContent.getDescription());

        if (introContent.getId() == LAST_PAGE)
            getBinding().btnLogin.setVisibility(View.VISIBLE);

        getBinding().btnLogin.setOnClickListener(click ->
                getUiInteraction().getNavigationController().navigateToLoginScreen());
    }
}
