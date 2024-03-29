package com.upadhyay.newsfeedapplication.ui.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentRegisterUserBinding;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.utils.AppConstants;
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;


public class RegisterUserFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentRegisterUserBinding> {

    private String userName;
    private String password;

    public static Fragment getInstance() {
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getUiInteraction().setToolbar(false);
        Glide.with(this).load(AppConstants.LOGO_URL).into(getBinding().ivBackground);
        getBinding().btnRegister.setOnClickListener(click -> {
            if (validateForm()) {
                getBinding().pbRegistration.setVisibility(View.VISIBLE);
                getViewModel().saveUserProfile(userName, password).observe(this, response -> {

                    if (response != null && response.data != null && response.status == StatusConstant.SUCCESS) {
                        presentToast("User Registered with Id - " + response.data.getUserId());
                        getBinding().pbRegistration.setVisibility(View.GONE);
                        getUiInteraction().getNavigationController().popBackStackImmediate();
                    } else if (response != null && response.status == StatusConstant.ERROR) {
                        presentToast("Failed to Register User");
                        getBinding().pbRegistration.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    private boolean validateForm() {
        userName = getBinding().tilUserName.getEditText().getText().toString();
        password = getBinding().tilPassword.getEditText().getText().toString();
        String confirmPassword = getBinding().tilConfirmPassword.getEditText().getText().toString();
        if (userName.isEmpty()) {
            presentToast("Please Specify User Name");
            return false;
        } else if (password.isEmpty()) {
            presentToast("Please Specify Password");
            return false;
        } else if (confirmPassword.isEmpty()) {
            presentToast("Please Specify Confirm Password");
            return false;
        } else if (!password.equals(confirmPassword)) {
            presentToast("Passwords do not match");
            return false;
        }
        return true;
    }

    private void presentToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


}
