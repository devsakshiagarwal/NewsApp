package com.agarwal.newsapp.common.di;

import com.agarwal.newsapp.Configuration;
import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Responsible for all Application level methods which are supposed to be initiated only once when
 * required.
 */
public class CompRoot {
  private Retrofit retrofit;
  private static final int TIMEOUT = 30;

  public CompRoot() {
  }

  /**
   * @return retrofit instance for making api calls
   * connection timeout has been increased to 30 seconds as api is taking a little bit more time in
   * responding
   */
  private Retrofit getRetrofit() {
    if (retrofit == null) {
      OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
      httpBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
      httpBuilder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
      httpBuilder.writeTimeout(TIMEOUT, TimeUnit.SECONDS);
      retrofit = new Retrofit.Builder()
          .client(httpBuilder.build())
          .baseUrl(Configuration.BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

  /**
   * @return newsListing api interface
   */
  NewsListingApi getNewsListingApi() {
    return getRetrofit().create(NewsListingApi.class);
  }
}
