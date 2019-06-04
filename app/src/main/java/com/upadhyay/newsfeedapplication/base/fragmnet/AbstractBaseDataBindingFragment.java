package com.upadhyay.newsfeedapplication.base.fragmnet;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.upadhyay.newsfeedapplication.base.contract.BaseContract;
import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;


/*
 * Add Data Binding layer to Abstract Fragment
 * */
public abstract class AbstractBaseDataBindingFragment<P extends BaseContract, V extends AbstractViewModel<P>, T extends ViewDataBinding>
        extends AbstractBaseFragment<P, V> {

    private T binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @NonNull
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    public T getBinding() {
        if (binding == null) {
            throw new ExceptionInInitializerError("Please try this method after onCreateView() lifecycle call");
        }
        return binding;
    }
}
