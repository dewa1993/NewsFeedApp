package com.upadhyay.newsfeedapplication.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "rss", strict = false)
public class FeedRss {

    @Element(name = "channel")
    private FeedChannel channel;

    @Attribute(name = "version", required = false)
    private String version;

    @Root(name = "channel" ,strict = false)
    public static class FeedChannel {

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

        @ElementList(inline = true, name="item")
        private List<FeedItem> feedItemList;

    }


}
