package com.upadhyay.newsfeedapplication.base.fragmnet;

import android.content.Context;
import android.databinding.ViewDataBinding;

import com.upadhyay.newsfeedapplication.base.activity.AbstractBaseMainActivity;
import com.upadhyay.newsfeedapplication.base.contract.BaseContract;
import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;

/*
 * Abstraction layer to provide Fragment navigation
 * */

public abstract class AbstractBaseMainFragment<P extends BaseContract,
        V extends AbstractViewModel<P>, T extends ViewDataBinding>
        extends AbstractBaseDataBindingFragment<P, V, T> {

    private AbstractBaseMainActivity.UiInteraction uiInteraction;

    public AbstractBaseMainActivity.UiInteraction getUiInteraction() {
        return uiInteraction;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attach(context);
    }

    private void attach(Context activityOrContext) {
        uiInteraction = (AbstractBaseMainActivity.UiInteraction) activityOrContext;
        if (uiInteraction == null) {
            throw new NullPointerException("Please extends " + AbstractBaseMainActivity.UiInteraction.class.getName() + " interface to your calling activity");
        }
    }


}
