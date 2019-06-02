package com.upadhyay.newsfeedapplication.repository.registration;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.upadhyay.newsfeedapplication.db.dao.UserRegistrationDao;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;
import com.upadhyay.newsfeedapplication.utils.AppExecutors;
import com.upadhyay.newsfeedapplication.utils.PasswordUtils;
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
    public LiveData<ResourcesResponse<UserProfile>> saveUserProfile(String userName, String password) {
        MutableLiveData<ResourcesResponse<UserProfile>> resourcesResponseMutableLiveData = new MutableLiveData<>();

        appExecutors.getDiskOp().execute(() -> {
            String salt = PasswordUtils.getSalt(password.length());
            String encryptedPassword = PasswordUtils.generateSecurePassword(password, salt);
            UserProfile userProfile = new UserProfile(userName, encryptedPassword, salt);

            userRegistrationDao.registerUser(userProfile);

            UserProfile response = userRegistrationDao.getUserProfile(userProfile.getUserName());

            if (response != null)
                resourcesResponseMutableLiveData.postValue(ResourcesResponse.success(response));
            else
                resourcesResponseMutableLiveData.postValue(ResourcesResponse.error("Error", null));
        });

        return resourcesResponseMutableLiveData;
    }


    @Override
    public LiveData<ResourcesResponse<Boolean>> verifyUser(String userName, String providedPassword) {
        MutableLiveData<ResourcesResponse<Boolean>> responseMutableLiveData = new MutableLiveData<>();
        appExecutors.getDiskOp().execute(() -> {

            UserProfile existingUser = userRegistrationDao.getUserProfile(userName);
            if (existingUser != null) {
                boolean login = PasswordUtils.verifyUserPassword(providedPassword, existingUser.getPassword(), existingUser.getSalt());

                if (login)
                    responseMutableLiveData.postValue(ResourcesResponse.success(true));
                else
                    responseMutableLiveData.postValue(ResourcesResponse.success(false));
            } else
                responseMutableLiveData.postValue(ResourcesResponse.error("User not found, Please register user ", null));
        });


        return responseMutableLiveData;
    }
}
