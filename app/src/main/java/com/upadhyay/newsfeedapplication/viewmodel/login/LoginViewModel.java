package com.upadhyay.newsfeedapplication.viewmodel.login;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;
import com.upadhyay.newsfeedapplication.repository.registration.RegistrationRepository;
import com.upadhyay.newsfeedapplication.repository.registration.RegistrationRepositoryImpl;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

import javax.inject.Inject;

public class LoginViewModel extends AbstractViewModel<LoginContract> implements LoginContract {

    private RegistrationRepository registrationRepository;

    @Inject
    LoginViewModel(RegistrationRepositoryImpl registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public LoginContract getViewModel() {
        return this;
    }

    @Override
    public LiveData<ResourcesResponse<UserProfile>> saveUserProfile(UserProfile userProfile) {
        return registrationRepository.saveUserProfile(userProfile);
    }
}
