package com.upadhyay.newsfeedapplication.viewmodel.login;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;
import com.upadhyay.newsfeedapplication.model.IntroContent;
import com.upadhyay.newsfeedapplication.repository.registration.LoginRepository;
import com.upadhyay.newsfeedapplication.repository.registration.LoginRepositoryImpl;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

import java.util.List;

import javax.inject.Inject;

public class LoginViewModel extends AbstractViewModel<LoginContract> implements LoginContract {

    private LoginRepository loginRepository;

    @Inject
    LoginViewModel(LoginRepositoryImpl registrationRepository) {
        this.loginRepository = registrationRepository;
    }

    @Override
    public LiveData<ResourcesResponse<List<IntroContent>>> getIntroContent() {
        return loginRepository.getIntroContent();
    }

    @Override
    public LoginContract getViewModel() {
        return this;
    }

    @Override
    public LiveData<ResourcesResponse<UserProfile>> saveUserProfile(String userName, String password) {
        return loginRepository.saveUserProfile(userName, password);
    }


    @Override
    public LiveData<ResourcesResponse<Boolean>> verifyUser(String userName, String password) {
        return loginRepository.verifyUser(userName, password);
    }
}
