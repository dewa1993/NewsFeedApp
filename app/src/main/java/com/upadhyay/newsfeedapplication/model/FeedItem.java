package com.upadhyay.newsfeedapplication.model;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public FeedEnclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(FeedEnclosure enclosure) {
        this.enclosure = enclosure;
    }
}
