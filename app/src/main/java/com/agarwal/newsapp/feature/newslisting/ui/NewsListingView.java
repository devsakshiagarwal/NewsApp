package com.agarwal.newsapp.feature.newslisting.ui;

import com.agarwal.newsapp.common.arch.ObservableView;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import java.util.List;

/**
 * interface for interaction between NewsListingActivity and it's views implementation
 */
public interface NewsListingView extends ObservableView<NewsListingView.Listener> {

  /**
   * shows loader when between api hit starts
   */
  void showProgressBar();

  /**
   * hides loader when api gives response
   */
  void hideProgressBar();

  /**
   * shows error response in case of failure
   */
  void showZeroState(String message);

  /**
   * binds list of articles to the RecyclerView
   */
  void bindNewsList(List<Articles> newsList);

  /**
   * interface for interaction between RealNewsListingView and NewsListingActivity
   */
  interface Listener {
    void onQueryChange(String query);
  }
}
