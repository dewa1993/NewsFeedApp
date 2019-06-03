package com.upadhyay.newsfeedapplication.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "rss", strict = false)
public class FeedRss {

    @Element(name = "channel")
    private FeedChannel channel;

    @Attribute(name = "version", required = false)
    private String version;

    public FeedChannel getChannel() {
        return channel;
    }

    public void setChannel(FeedChannel channel) {
        this.channel = channel;
    }
}
