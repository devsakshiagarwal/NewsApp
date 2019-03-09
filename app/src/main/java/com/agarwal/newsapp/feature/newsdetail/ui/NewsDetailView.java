package com.agarwal.newsapp.feature.newsdetail.ui;

import com.agarwal.newsapp.common.arch.ObservableView;

public interface NewsDetailView extends ObservableView<NewsDetailView.Listener> {

  void bindNewsDetail(String url);

  interface Listener {
  }
}