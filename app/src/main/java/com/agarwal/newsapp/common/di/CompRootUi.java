package com.agarwal.newsapp.common.di;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.common.arch.Router;
import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;

public class CompRootUi {

  private final CompRoot compRoot;
  private final AppCompatActivity activity;

  public CompRootUi(CompRoot compositionRoot, AppCompatActivity activity) {
    compRoot = compositionRoot;
    this.activity = activity;
  }

  private AppCompatActivity getActivity() {
    return activity;
  }

  private Context getContext() {
    return activity;
  }

  public Router getRouter() {
    return new Router(getActivity());
  }

  public NewsListingApi getNewsListingApi() {
    return compRoot.getNewsListingApi();
  }
}
