package com.agarwal.newsapp.feature.newslisting.network;

import com.agarwal.newsapp.common.network.Endpoints;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface NewsListingApi {

  @GET(Endpoints.NEWS_LIST_EVERYTHING) Call<NewsListSchema> getNewsList(
      @QueryMap HashMap<String, String> queryMap);

  @GET(Endpoints.NEWS_LIST_HEADLINES) Call<NewsListSchema> getHeadLines(
      @QueryMap HashMap<String, String> queryMap);
}
