package com.agarwal.newsapp.common.di;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.common.arch.Router;
import com.agarwal.newsapp.common.arch.ViewFactory;
import com.agarwal.newsapp.feature.newslisting.NewsListUseCase;
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

  private LayoutInflater getLayoutInflater() {
    return LayoutInflater.from(getContext());
  }

  public ViewFactory getViewFactory() {
    return new ViewFactory(getLayoutInflater());
  }

  public NewsListingApi getNewsListingApi() {
    return compRoot.getNewsListingApi();
  }

  public NewsListUseCase getNewsListUseCase() {
    return new NewsListUseCase(getNewsListingApi());
  }
}
