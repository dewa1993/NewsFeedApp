package com.upadhyay.newsfeedapplication.ui.feeds.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.upadhyay.newsfeedapplication.R;
import com.upadhyay.newsfeedapplication.base.fragmnet.AbstractBaseMainFragment;
import com.upadhyay.newsfeedapplication.databinding.FragmentFeedDetailsBinding;
import com.upadhyay.newsfeedapplication.ui.feeds.contract.FeedsContract;
import com.upadhyay.newsfeedapplication.utils.StatusConstant;
import com.upadhyay.newsfeedapplication.viewmodel.feeds.NewsFeedViewModel;

import org.jsoup.nodes.Document;

public class NewsFeedDetailsFragment extends AbstractBaseMainFragment<FeedsContract, NewsFeedViewModel, FragmentFeedDetailsBinding> {

    private String url;

    public static Fragment getInstance(String mUrl) {
        NewsFeedDetailsFragment newsFeedDetailsFragment = new NewsFeedDetailsFragment();
        newsFeedDetailsFragment.url = mUrl;
        return newsFeedDetailsFragment;
    }

    @Override
    protected Class<NewsFeedViewModel> getViewModels() {
        return NewsFeedViewModel.class;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_feed_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getUiInteraction().setToolbar(false);
        getBinding().pbWebView.setVisibility(View.VISIBLE);
        getViewModel().getCleanUpDocument(url).observe(this, documentResourcesResponse -> {
            if (documentResourcesResponse != null && documentResourcesResponse.data != null && documentResourcesResponse.status == StatusConstant.SUCCESS) {
                setWebViewWithDocument(documentResourcesResponse.data);
            }
        });
    }


    void setWebViewWithDocument(Document document) {
        getBinding().webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        getBinding().webView.getSettings().setBuiltInZoomControls(false);
        getBinding().webView.getSettings().setDomStorageEnabled(true);
        getBinding().webView.getSettings().setDatabaseEnabled(true);
        getBinding().webView.getSettings().setAppCacheEnabled(true);
        getBinding().webView.loadData(document.toString(), "text/html", "utf-8");
        getBinding().webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    getBinding().pbWebView.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }
}
