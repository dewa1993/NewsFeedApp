package com.upadhyay.newsfeedapplication.ui.feeds.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.upadhyay.newsfeedapplication.databinding.ItemFeedRecyclerBinding;
import com.upadhyay.newsfeedapplication.db.table.NewsFeed;

import java.util.List;

public class FeedItemAdapter extends RecyclerView.Adapter<FeedItemAdapter.RecyclerViewHolder> {

    private RecyclerViewClickListener listener;
    private List<NewsFeed> newsFeeds;

    public FeedItemAdapter(List<NewsFeed> newsFeedList, RecyclerViewClickListener recyclerViewClickListener) {
        this.newsFeeds = newsFeedList;
        this.listener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTy) {
        ItemFeedRecyclerBinding itemFeedRecyclerBinding = ItemFeedRecyclerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RecyclerViewHolder(itemFeedRecyclerBinding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.itemFeedRecyclerBinding.tvItemTitle.setText(newsFeeds.get(position).getTitle());
        holder.itemFeedRecyclerBinding.tvItemDescription.setText(newsFeeds.get(position).getDescription());
        Glide.with(holder.itemFeedRecyclerBinding.ivNewsImg.getContext())
                .load(newsFeeds.get(position).getUrl())
                .into(holder.itemFeedRecyclerBinding.ivNewsImg);
    }

    @Override
    public int getItemCount() {
        return newsFeeds != null ? newsFeeds.size() : 0;
    }

    public void clear() {
        newsFeeds.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<NewsFeed> newsFeedList) {
        newsFeeds.addAll(newsFeedList);
        notifyDataSetChanged();
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemFeedRecyclerBinding itemFeedRecyclerBinding;

        RecyclerViewHolder(ItemFeedRecyclerBinding itemFeedRecyclerBinding, RecyclerViewClickListener recyclerViewClickListener) {
            super(itemFeedRecyclerBinding.getRoot());
            this.itemFeedRecyclerBinding = itemFeedRecyclerBinding;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null)
                listener.onRowClicked(newsFeeds.get(getAdapterPosition()), getAdapterPosition());

        }
    }
}
