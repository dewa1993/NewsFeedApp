package com.upadhyay.newsfeedapplication.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root(name = "item", strict = false)
public class FeedItem {

    @Element(name = "link")
    private String link;

    @Element(name = "description")
    private String description;

    @Element(name = "title")
    private String title;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "enclosure")
    private FeedEnclosure enclosure;

    @Root(name = "enclosure", strict = false)
    public static class FeedEnclosure {

        @Attribute(name = "length", required = false)
        private String length;

        @Attribute(name = "type", required = false)
        private String type;

        @Attribute(name = "url", required = false)
        private String url;

    }
}
