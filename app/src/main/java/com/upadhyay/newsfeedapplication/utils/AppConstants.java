package com.upadhyay.newsfeedapplication.utils;

public class AppConstants {

    private AppConstants() {
    }

    public static final String LOGO_URL = "https://png.icons8.com/color/feed/96";
    public static final String DATABASE_NAME = "news-feed-db";
    public static final int ITERATIONS = 65536;
    public static final int KEY_LENGTH = 512;
    public static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    // Shared preferences
    public static final String SP_KEY = "com.upadhyde.newsfeedapplication";
    public static final String SP_LOGIN = "KEY_SP_LOGIN";

    // HTML Formatter
    public static final String REQUEST_AGENT = "Opera/12.02 (Android 4.1; Linux; Opera Mobi/ADR-1111101157; U; en-US) Presto/2.9.201 Version/12.02";
    public static final String HTML_JUNK_1 = "header";
    public static final String HTML_JUNK_2 = "overlay";
    public static final String HTML_JUNK_3 = "footer_actions";
    public static final String HTML_JUNK_4 = "lowend_nav";
    public static final String HTML_JUNK_5 = "footer_container";
    public static final String HTML_JUNK_6 = "sticky_ad_header";
    public static final String HTML_JUNK_7 = "article_comments_share";
    public static final String HTML_JUNK_8 = "article_byline";
    public static final String HTML_JUNK_9 = "social_sharing_bottom";
    public static final String HTML_JUNK_10 = "OUTBRAIN";
    public static final String HTML_JUNK_11 = "header-ad 24advert southernx";
    public static final String HTML_JUNK_12 = "page_content content_with_ad content";

    public static final String MIME_TYPE = "text/html";
    public static final String ENCODING_TYPE = "utf-8";


    // Dummy text for Intro

    public static final String DUMMY_CONTENT = "Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum";
    public static final String DUMMY_CONTENT_ICON_1 = "https://png.icons8.com/color/facebook/96";
    public static final String DUMMY_CONTENT_ICON_2 = "https://png.icons8.com/color/gmail/96";
    public static final String DUMMY_CONTENT_ICON_3 = "https://png.icons8.com/color/instagram/96";


}
