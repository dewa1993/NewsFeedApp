package com.upadhyay.newsfeedapplication.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "channel", strict = false)
public class FeedChannel {

    @Element(name = "title")
    private String title;

    @Element(name = "link")
    private String link;

    @Element(name = "docs")
    private String docs;

    @Element(name = "lastBuildDate")
    private String lastBuildDate;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "generator")
    private String generator;

    @ElementList(inline = true, name = "item")
    private List<FeedItem> feedItemList;

    public List<FeedItem> getFeedItemList() {
        return feedItemList;
    }

    public void setFeedItemList(List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
    }
}
