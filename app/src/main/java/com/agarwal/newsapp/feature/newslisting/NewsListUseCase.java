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

/**
 * UseCase for fetching all news from the server.
 * Should be used for this purpose only.
 */
public class NewsListUseCase extends BaseObservable<NewsListUseCase.Listener> {

  private final NewsListingApi newsListingApi;
  private static final String QUERY = "q";
  private static final String API_KEY = "apiKey";
  private static final String OK = "ok";
  private static final String API_FAIL = "something went wrong";

  public NewsListUseCase(NewsListingApi newsListingApi) {
    this.newsListingApi = newsListingApi;
  }

  /**
   * Makes an api call for fetching all news related to a query param
   * Gives callback from NewsListUseCase.Listener interface.
   *
   * @param query for relevant news fetch.
   * should not be empty or null or else api will return fail
   */
  void fetchEverything(String query) {
    newsListingApi.getNewsList(getQueryMap(query)).enqueue(new Callback<NewsListSchema>() {
      @Override
      public void onResponse(Call<NewsListSchema> call, Response<NewsListSchema> response) {
        if (response.isSuccessful() && response.body() != null) {
          if (response.body().getStatus().equalsIgnoreCase(OK)) {
            onSuccess(response.body().getArticles());
          } else {
            onFail(response.body().getMessage());
          }
        } else {
          onFail(API_FAIL);
        }
      }

      @Override public void onFailure(Call<NewsListSchema> call, Throwable t) {
        onFail(t.getMessage());
      }
    });
  }

  /**
   * @param query for relevant news
   * @return hashmap of size 2 for query and apiKey
   */
  private HashMap<String, String> getQueryMap(String query) {
    HashMap<String, String> queryMap = new HashMap<>();
    queryMap.put(QUERY, query);
    queryMap.put(API_KEY, Configuration.API_KEY);
    return queryMap;
  }

  /**
   * @param newsList list of Articles object
   * returns response for Listener interface
   */
  private void onSuccess(List<Articles> newsList) {
    for (Listener listener : getListeners()) {
      listener.onSuccess(newsList);
    }
  }

  /**
   * @param message string message
   * returns response for Listener interface
   */
  private void onFail(String message) {
    for (Listener listener : getListeners()) {
      listener.onFail(message);
    }
  }

  /**
   * Should be implemented when @See com.agarwal.newsapp.feature.newslisting.NewsListUseCase
   * is used for getting the response of api hit
   */
  public interface Listener {
    void onSuccess(List<Articles> newsArticles);

    void onFail(String message);
  }
}
