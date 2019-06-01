package com.upadhyay.newsfeedapplication.base.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.upadhyay.newsfeedapplication.base.contract.BaseContract;

public abstract class AbstractViewModel<P extends BaseContract> extends ViewModel {

    public abstract P getViewModel();
}
