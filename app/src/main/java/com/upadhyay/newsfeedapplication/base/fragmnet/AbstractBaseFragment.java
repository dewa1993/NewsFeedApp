package com.upadhyay.newsfeedapplication.base.fragmnet;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;


import com.upadhyay.newsfeedapplication.base.contract.BaseContract;
import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;

import javax.inject.Inject;

public abstract class AbstractBaseFragment<P extends BaseContract, VM extends AbstractViewModel<P>>
        extends Fragment implements InjectableFragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private P contract;
    private VM viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModels());
        contract = viewModel.getViewModel();
    }


    public P getViewModel() {
        return contract;
    }

    protected abstract Class<VM> getViewModels();

    protected abstract @LayoutRes
    int getLayout();

}
