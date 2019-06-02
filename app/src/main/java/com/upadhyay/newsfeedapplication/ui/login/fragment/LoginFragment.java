package com.upadhyay.newsfeedapplication.ui.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.bumptech.glide.Glide;
import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentLoginBinding;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

public class LoginFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentLoginBinding> {

    public static Fragment getInstance(){
        return new LoginFragment();
    }

    @Override
    protected Class<LoginViewModel> getViewModels() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide.with(this).load("https://png.icons8.com/color/newsfeed/96").into(getBinding().ivBackground);
    }
}