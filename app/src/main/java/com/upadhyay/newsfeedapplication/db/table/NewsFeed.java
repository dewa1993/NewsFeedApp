package com.upadhyay.newsfeedapplication.db.table;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;


@Entity(primaryKeys = {"feedItemId", "title"})
public class NewsFeed {

    @NonNull
    @ColumnInfo(name = "feedItemId")
    private int feedItemId;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "link")
    private String link;

    @ColumnInfo(name = "pubDate")
    private String pubDate;

    @ColumnInfo(name = "url")
    private String url;

    public int getFeedItemId() {
        return feedItemId;
    }

    public void setFeedItemId(int feedItemId) {
        this.feedItemId = feedItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
