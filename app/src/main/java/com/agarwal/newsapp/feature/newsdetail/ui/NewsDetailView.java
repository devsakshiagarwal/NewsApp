package com.agarwal.newsapp.feature.newsdetail.ui;

import com.agarwal.newsapp.common.arch.ObservableView;

/**
 * interface for interaction between NewsDetailActivity and it's views implementation
 */
public interface NewsDetailView extends ObservableView<NewsDetailView.Listener> {

  /**
   * binds url into the View
   *
   * @param url should not be empty
   */
  void bindNewsDetail(String url);

  interface Listener {
  }
}