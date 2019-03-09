package com.agarwal.newsapp.common.di;

import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.agarwal.newsapp.Configuration.BASE_URL;

public class CompRoot {
  private Retrofit retrofit;
  private static final int TIMEOUT = 30;

  public CompRoot() {
  }

  private Retrofit getRetrofit() {
    if (retrofit == null) {
      OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
      httpBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
      httpBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
      httpBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS);
      retrofit = new Retrofit.Builder()
          .client(httpBuilder.build())
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

  NewsListingApi getNewsListingApi() {
    return getRetrofit().create(NewsListingApi.class);
  }
}
