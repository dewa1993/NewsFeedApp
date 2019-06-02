package com.upadhyay.newsfeedapplication.ui.login.fragment;

import android.support.v4.app.Fragment;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentRegisterUserBinding;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

public class RegisterUserFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentRegisterUserBinding> {

    public static Fragment getInstance(){
        return new RegisterUserFragment();
    }

    @Override
    protected Class<LoginViewModel> getViewModels() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_user;
    }
}
