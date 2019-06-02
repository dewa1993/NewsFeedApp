package com.upadhyay.newsfeedapplication.utils;

import android.databinding.BindingAdapter;
import android.view.View;


public class UiBindingAdapter {

    UiBindingAdapter() {
        //Empty constructor
    }

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
