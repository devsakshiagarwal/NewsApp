package com.agarwal.newsapp.feature.newslisting;

import com.agarwal.newsapp.Configuration;
import com.agarwal.newsapp.common.arch.BaseObservable;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import com.agarwal.newsapp.feature.newslisting.network.NewsListSchema;
import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListUseCase extends BaseObservable<NewsListUseCase.Listener> {

  private final NewsListingApi newsListingApi;
  private static final String QUERY = "q";
  private static final String API_KEY = "apiKey";

  public NewsListUseCase(NewsListingApi newsListingApi) {
    this.newsListingApi = newsListingApi;
  }

  public void fetchEverything(String query) {
    newsListingApi.getNewsList(getQueryMap(query)).enqueue(new Callback<NewsListSchema>() {
      @Override
      public void onResponse(Call<NewsListSchema> call, Response<NewsListSchema> response) {
        if (response.isSuccessful()) {
          if (response.body().getStatus().equalsIgnoreCase("ok")) {
            onSuccess(response.body().getArticles());
          } else {
            onFail(response.body().getMessage());
          }
        } else {
          onFail("Something went wrong");
        }
      }

      @Override public void onFailure(Call<NewsListSchema> call, Throwable t) {
        onFail(t.getMessage());
      }
    });
  }

  public void fetchHeadLines(String query) {
    newsListingApi.getHeadLines(getQueryMap(query)).enqueue(new Callback<NewsListSchema>() {
      @Override
      public void onResponse(Call<NewsListSchema> call, Response<NewsListSchema> response) {
        if (response.isSuccessful()) {
          if (response.body().getStatus().equalsIgnoreCase("ok")) {
            onSuccess(response.body().getArticles());
          } else {
            onFail(response.body().getMessage());
          }
        } else {
          onFail("Something went wrong");
        }
      }

      @Override public void onFailure(Call<NewsListSchema> call, Throwable t) {
        onFail(t.getMessage());
      }
    });
  }

  private HashMap<String, String> getQueryMap(String query) {
    HashMap<String, String> queryMap = new HashMap<>();
    queryMap.put(QUERY, query);
    queryMap.put(API_KEY, Configuration.API_KEY);
    return queryMap;
  }

  private void onSuccess(List<Articles> newsList) {
    for (Listener listener : getListeners()) {
      listener.onSuccess(newsList);
    }
  }

  private void onFail(String message) {
    for (Listener listener : getListeners()) {
      listener.onFail(message);
    }
  }

  public interface Listener {
    void onSuccess(List<Articles> newsArticles);

    void onFail(String message);
  }
}
