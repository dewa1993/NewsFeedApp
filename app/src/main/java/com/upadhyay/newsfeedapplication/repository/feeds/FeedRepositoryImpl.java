package com.upadhyay.newsfeedapplication.repository.feeds;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.upadhyay.newsfeedapplication.db.dao.NewsFeedDao;
import com.upadhyay.newsfeedapplication.db.table.NewsFeed;
import com.upadhyay.newsfeedapplication.model.FeedItem;
import com.upadhyay.newsfeedapplication.model.FeedRss;
import com.upadhyay.newsfeedapplication.network.NewsService;
import com.upadhyay.newsfeedapplication.utils.AppExecutors;
import com.upadhyay.newsfeedapplication.utils.ResourcesResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedRepositoryImpl implements FeedRepository {

    private AppExecutors appExecutors;
    private NewsService newsService;
    private NewsFeedDao newsFeedDao;

    @Inject
    public FeedRepositoryImpl(AppExecutors appExecutors, NewsService newsService, NewsFeedDao newsFeedDao) {
        this.appExecutors = appExecutors;
        this.newsService = newsService;
        this.newsFeedDao = newsFeedDao;
    }

    @Override
    public LiveData<ResourcesResponse<List<NewsFeed>>> getNewsFeeds() {
        MutableLiveData<ResourcesResponse<List<NewsFeed>>> resourcesResponseMutableLiveData = new MutableLiveData<>();
        newsService.getAllFeed().enqueue(new Callback<FeedRss>() {
            @Override
            public void onResponse(@NonNull Call<FeedRss> call,
                                   @NonNull Response<FeedRss> response) {
                if (response.isSuccessful()) {
                    appExecutors.getNetworkOp().execute(() -> {
                        List<NewsFeed> newsFeedList = getNewsFeedsForData(response.body());
                        if (newsFeedList != null && !newsFeedList.isEmpty())
                            newsFeedDao.updateNewFeeds(newsFeedList);

                        newsFeedList = newsFeedDao.getAllNewsFeeds();

                        if (newsFeedList != null)
                            resourcesResponseMutableLiveData.postValue(ResourcesResponse.success(newsFeedList));
                        else
                            resourcesResponseMutableLiveData.postValue(ResourcesResponse.error("No Data", null));
                    });

                }
            }

            /*
             * In case Network gives error load data from SqLite
             */
            @Override
            public void onFailure(@NonNull Call<FeedRss> call, @NonNull Throwable t) {

                appExecutors.getDiskOp().execute(() -> {
                    List<NewsFeed> newsFeedList = newsFeedDao.getAllNewsFeeds();
                    if (newsFeedList != null)
                        resourcesResponseMutableLiveData.postValue(ResourcesResponse.success(newsFeedList));
                    else
                        resourcesResponseMutableLiveData.postValue(ResourcesResponse.error("No Data", null));
                });

            }
        });

        return resourcesResponseMutableLiveData;
    }


    /*
     * Map XML Response Entity to SqLite Database Entity
     */
    private List<NewsFeed> getNewsFeedsForData(FeedRss feedRss) {
        List<NewsFeed> newsFeedList = new ArrayList<>();
        if (feedRss != null) {

            for (FeedItem item : feedRss.getChannel().getFeedItemList()) {

                NewsFeed newsFeedItem = new NewsFeed();
                newsFeedItem.setDescription(item.getDescription());
                newsFeedItem.setTitle(item.getTitle());
                newsFeedItem.setUrl(item.getEnclosure().getUrl());
                newsFeedItem.setLink(item.getLink());
                newsFeedItem.setPubDate(item.getPubDate());

                newsFeedList.add(newsFeedItem);
            }

            return newsFeedList;

        } else
            return newsFeedList;

    }


    @Override
    public LiveData<ResourcesResponse<Document>> getCleanUpDocument(String baseUrl) {
        MutableLiveData<ResourcesResponse<Document>> resourcesResponseMutableLiveData = new MutableLiveData<>();

        appExecutors.getDiskOp().execute(() -> {
            Document document = null;
            try {
                document = Jsoup.connect(baseUrl).userAgent("Opera/12.02 (Android 4.1; Linux; Opera Mobi/ADR-1111101157; U; en-US) Presto/2.9.201 Version/12.02").get();
                document.getElementsByClass("header").remove();
                document.getElementsByClass("overlay").remove();
                document.getElementsByClass("footer_actions").remove();
                document.getElementsByClass("lowend_nav").remove();
                document.getElementsByClass("footer_container").remove();
                document.getElementsByClass("sticky_ad_header").remove();
                document.getElementsByClass("article_comments_share").remove();
                document.getElementsByClass("article_byline").remove();
                document.getElementsByClass("social_sharing_bottom").remove();
                document.getElementsByClass("OUTBRAIN").remove();
                document.getElementsByClass("header-ad 24advert southernx").remove();
                document.getElementsByClass("page_content content_with_ad content").removeClass("page_content content_with_ad content");

                resourcesResponseMutableLiveData.postValue(ResourcesResponse.success(document));

            } catch (IOException e) {
                resourcesResponseMutableLiveData.postValue(ResourcesResponse.error("Error Parsing HTML", document));
            }
        });

        return resourcesResponseMutableLiveData;
    }
}