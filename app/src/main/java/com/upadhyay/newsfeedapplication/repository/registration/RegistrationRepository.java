package com.upadhyay.newsfeedapplication.repository.registration;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.db.table.UserProfile;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

public interface RegistrationRepository {

    LiveData<ResourcesResponse<UserProfile>> saveUserProfile(String userName, String password);

    LiveData<ResourcesResponse<Boolean>> verifyUser(String userName, String password);
}
