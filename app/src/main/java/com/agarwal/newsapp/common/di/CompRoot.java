package com.agarwal.newsapp.common.di;

import com.agarwal.newsapp.NewsApp;
import com.agarwal.newsapp.common.connectivity.ConnectivityDetector;
import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.agarwal.newsapp.Configuration.BASE_URL;

public class CompRoot {
  private final NewsApp newsApp;
  private Retrofit retrofit;
  private ConnectivityDetector connectivityDetector;

  public CompRoot(NewsApp newsApp) {
    this.newsApp = newsApp;
    getNetworkManager();
  }

  public final ConnectivityDetector getNetworkManager() {
    if (connectivityDetector == null) {
      connectivityDetector = new ConnectivityDetector(newsApp);
    }
    return connectivityDetector;
  }

  private Retrofit getRetrofit() {
    if (retrofit == null) {
      OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
      httpBuilder.connectTimeout(30, TimeUnit.SECONDS);
      httpBuilder.readTimeout(30, TimeUnit.SECONDS);
      httpBuilder.writeTimeout(30, TimeUnit.SECONDS);
      retrofit = new Retrofit.Builder()
          .client(httpBuilder.build())
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

  public NewsListingApi getNewsListingApi() {
    return getRetrofit().create(NewsListingApi.class);
  }
}
