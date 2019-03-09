package com.agarwal.newsapp.common.arch;

import android.view.LayoutInflater;
import com.agarwal.newsapp.feature.newslisting.ui.NewsListingView;
import com.agarwal.newsapp.feature.newslisting.ui.RealNewsListingViews;

public class ViewFactory {

  private final LayoutInflater layoutInflater;

  public ViewFactory(LayoutInflater layoutInflater) {
    this.layoutInflater = layoutInflater;
  }

  public NewsListingView getNewsListView() {
    return new RealNewsListingViews(layoutInflater);
  }
}
