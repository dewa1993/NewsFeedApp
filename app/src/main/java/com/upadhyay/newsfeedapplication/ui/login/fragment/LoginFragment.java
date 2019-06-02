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
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.login.LoginViewModel;

public class LoginFragment extends AbstractBaseMainFragment<LoginContract, LoginViewModel, FragmentLoginBinding> {

    private String userName;
    private String password;

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
        Glide.with(this).load(AppConstants.LOGO_URL).into(getBinding().ivBackground);

        getBinding().tvRegisterUser.setOnClickListener(click ->
                getUiInteraction().getNavigationController().navigateToRegisterScreen());

        getBinding().btnLogin.setOnClickListener(click -> {
            if (validate()) {
                getViewModel().verifyUser(userName, password).observe(this, response -> {
                    getBinding().setResource(response);
                    if (response != null && response.data != null && response.status == StatusConstant.SUCCESS) {

                        if (response.data) {
                            presentToast("Successful Log-in");
                        } else
                            presentToast("Invalid Password");

                    } else if (response != null && response.status == StatusConstant.ERROR) {
                        presentToast(response.message);
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
