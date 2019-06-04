package com.upadhyay.newsfeedapplication.ui.feeds.adapter;

import com.upadhyay.newsfeedapplication.db.table.NewsFeed;

public interface RecyclerViewClickListener {

    void onRowClicked(NewsFeed newsFeed, int position);
}
