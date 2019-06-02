package com.upadhyay.newsfeedapplication.ui.login.contract;

import android.arch.lifecycle.LiveData;

import com.upadhyay.newsfeedapplication.base.contract.BaseContract;
import com.upadhyay.newsfeedapplication.db.table.UserProfile;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

public interface LoginContract extends BaseContract {

    LiveData<ResourcesResponse<UserProfile>> saveUserProfile(String userName, String password);

    LiveData<ResourcesResponse<Boolean>> verifyUser(String userName, String password);
}
