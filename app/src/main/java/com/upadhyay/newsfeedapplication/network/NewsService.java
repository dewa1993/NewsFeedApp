package com.upadhyay.newsfeedapplication.network;


import com.upadhyay.newsfeedapplication.model.FeedRss;


import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("articles/Fin24/Tech/rss")
    Call<FeedRss> getAllFeed();

}
