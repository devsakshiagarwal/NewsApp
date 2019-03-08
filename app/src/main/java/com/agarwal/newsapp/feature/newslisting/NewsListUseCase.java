package com.agarwal.newsapp.feature.newslisting;

import com.agarwal.newsapp.Configuration;
import com.agarwal.newsapp.feature.newslisting.network.NewsListSchema;
import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListUseCase {

  private final NewsListingApi newsListingApi;
  private final Listener listener;
  private static final String QUERY = "q";
  private static final String API_KEY = "apiKey";

  public NewsListUseCase(NewsListingApi newsListingApi, Listener listener) {
    this.newsListingApi = newsListingApi;
    this.listener = listener;
  }

  public void fetchEverything(String query) {
    newsListingApi.getNewsList(getQueryMap(query)).enqueue(new Callback<NewsListSchema>() {
      @Override
      public void onResponse(Call<NewsListSchema> call, Response<NewsListSchema> response) {
        listener.onSuccess(response.body().getArticles());
      }

      @Override public void onFailure(Call<NewsListSchema> call, Throwable t) {
        listener.onFail(t.getMessage());
      }
    });
  }

  public void fetchHeadLines(String query) {
    newsListingApi.getHeadLines(getQueryMap(query)).enqueue(new Callback<NewsListSchema>() {
      @Override
      public void onResponse(Call<NewsListSchema> call, Response<NewsListSchema> response) {
        listener.onSuccess(response.body().getArticles());
      }

      @Override public void onFailure(Call<NewsListSchema> call, Throwable t) {
        listener.onFail(t.getMessage());
      }
    });
  }

  private HashMap<String, String> getQueryMap(String query) {
    HashMap<String, String> queryMap = new HashMap<>();
    queryMap.put(QUERY, query);
    queryMap.put(API_KEY, Configuration.API_KEY);
    return queryMap;
  }

  interface Listener {
    void onSuccess(List<NewsListSchema.Articles> newsArticles);

    void onFail(String message);
  }
}
