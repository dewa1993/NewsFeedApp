package com.upadhyay.newsfeedapplication.ui.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentLoginBinding;
import com.upadhyay.newsfeedapplication.ui.login.contract.LoginContract;
import com.upadhyay.newsfeedapplication.utils.AppConstants;
import com.upadhyay.newsfeedapplication.utils.SharedPreferenceHelper;
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

import javax.inject.Inject;

public class LoginFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentLoginBinding> {

    private String userName;
    private String password;

    @Inject
    SharedPreferenceHelper sharedPreferenceHelper;

    public static Fragment getInstance() {
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
        getUiInteraction().setToolbar(false);
        Glide.with(this).load(AppConstants.LOGO_URL).into(getBinding().ivBackground);

        getBinding().tvRegisterUser.setOnClickListener(click ->
                getUiInteraction().getNavigationController().navigateToRegisterScreen());

        getBinding().btnLogin.setOnClickListener(click -> {
            if (validate()) {
                getBinding().pbRegistration.setVisibility(View.VISIBLE);
                getViewModel().verifyUser(userName, password).observe(this, response -> {

                    if (response != null && response.data != null && response.status == StatusConstant.SUCCESS) {

                        if (response.data) {
                            sharedPreferenceHelper.putValue(AppConstants.SP_LOGIN, true);
                            getUiInteraction().getNavigationController().navigateToNewsFeedFragment();
                        } else
                            presentToast("Incorrect Password");

                        getBinding().pbRegistration.setVisibility(View.GONE);

                    } else if (response != null && response.status == StatusConstant.ERROR) {
                        presentToast(response.message);
                        getBinding().pbRegistration.setVisibility(View.GONE);
                    }
                });
            }
        });
    }

    private boolean validate() {
        userName = getBinding().tilUserName.getEditText().getText().toString();
        password = getBinding().tilPassword.getEditText().getText().toString();

        if (userName.isEmpty()) {
            presentToast("Please Enter User Name");
            return false;
        } else if (password.isEmpty()) {
            presentToast("Please Enter Password");
            return false;
        }

        return true;
    }

    private void presentToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
