package com.agarwal.newsapp.common.arch;

import android.view.LayoutInflater;
import com.agarwal.newsapp.feature.newsdetail.ui.NewsDetailView;
import com.agarwal.newsapp.feature.newsdetail.ui.RealNewsDetailView;
import com.agarwal.newsapp.feature.newslisting.ui.NewsListingView;
import com.agarwal.newsapp.feature.newslisting.ui.RealNewsListingView;

public class ViewFactory {

  private final LayoutInflater layoutInflater;

  public ViewFactory(LayoutInflater layoutInflater) {
    this.layoutInflater = layoutInflater;
  }

  public NewsListingView getNewsListView() {
    return new RealNewsListingView(layoutInflater);
  }

  public NewsDetailView getNewsDetailView() {
    return new RealNewsDetailView(layoutInflater);
  }
}
