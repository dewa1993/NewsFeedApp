package com.upadhyay.newsfeedapplication.viewmodel.login;

import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;

import javax.inject.Inject;

public class LoginViewModel extends AbstractViewModel<LoginContract> implements LoginContract {

    @Inject
    LoginViewModel(){}

    @Override
    public LoginContract getViewModel() {
        return this;
    }
}
