package com.agarwal.newsapp.feature.newslisting.ui;

import com.agarwal.newsapp.common.arch.ObservableView;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import java.util.List;

public interface NewsListingView extends ObservableView<NewsListingView.Listener> {

  void showProgressBar();

  void hideProgressBar();

  void showZeroState(String message);

  void bindNewsList(List<Articles> newsList);

  interface Listener {
    void onQueryChange(String query);
  }
}
