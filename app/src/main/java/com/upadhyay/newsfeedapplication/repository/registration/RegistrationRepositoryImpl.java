package com.upadhyay.newsfeedapplication.repository.registration;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.upadhyay.newsfeedapplication.db.dao.UserRegistrationDao;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;
import com.upadhyay.newsfeedapplication.utils.AppExecutors;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

import javax.inject.Inject;

public class RegistrationRepositoryImpl implements RegistrationRepository {

    private AppExecutors appExecutors;
    private UserRegistrationDao userRegistrationDao;

    @Inject
    RegistrationRepositoryImpl(AppExecutors appExecutors, UserRegistrationDao userRegistrationDao) {
        this.appExecutors = appExecutors;
        this.userRegistrationDao = userRegistrationDao;
    }

    @Override
    public LiveData<ResourcesResponse<UserProfile>> saveUserProfile(UserProfile userProfile) {
        MutableLiveData<ResourcesResponse<UserProfile>> resourcesResponseMutableLiveData = new MutableLiveData<>();

        appExecutors.getDiskOp().execute(() -> {
            userRegistrationDao.registerUser(userProfile);
            UserProfile response = userRegistrationDao.getUserProfile(userProfile.getUserName());
            if (response != null)
                resourcesResponseMutableLiveData.postValue(ResourcesResponse.success(response));
            else
                resourcesResponseMutableLiveData.postValue(ResourcesResponse.error("Error", null));
        });

        return resourcesResponseMutableLiveData;
    }
}
