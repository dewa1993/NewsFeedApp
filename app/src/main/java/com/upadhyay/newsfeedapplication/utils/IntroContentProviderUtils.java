package com.upadhyay.newsfeedapplication.utils;

import com.upadhyay.newsfeedapplication.model.IntroContent;

import java.util.ArrayList;
import java.util.List;

public class IntroContentProviderUtils {


    public static List<IntroContent> getStaticIntroContentList(){
        List<IntroContent> introContents = new ArrayList<>();
        IntroContent page1 = new IntroContent("Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum", "https://png.icons8.com/color/facebook/96");
        IntroContent page2 = new IntroContent("Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum", "https://png.icons8.com/color/gmail/96");
        IntroContent page3 = new IntroContent("Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum Lorsum Ipsum", "https://png.icons8.com/color/instagram/96");
        introContents.add(page1);
        introContents.add(page2);
        introContents.add(page3);
        return introContents;
    }
}
