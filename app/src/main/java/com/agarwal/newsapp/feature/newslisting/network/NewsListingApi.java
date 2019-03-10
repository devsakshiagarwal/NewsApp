package com.agarwal.newsapp.feature.newslisting.network;

import com.agarwal.newsapp.common.network.Endpoints;
import java.util.HashMap;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Interface that helps retrofit in hitting the api for fetching news list
 */
public interface NewsListingApi {

  /**
   * fetches the response for newsList from server related to a particular query
   *
   * @param queryMap expects HashMap that contains at least a query and an apiKey
   * @return NewsListSchema in success response of api call
   */
  @GET(Endpoints.NEWS_LIST_EVERYTHING) Call<NewsListSchema> getNewsList(
      @QueryMap HashMap<String, String> queryMap);
}
