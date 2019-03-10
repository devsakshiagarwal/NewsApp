package com.agarwal.newsapp.common.arch;

import android.view.LayoutInflater;
import com.agarwal.newsapp.feature.newsdetail.ui.NewsDetailView;
import com.agarwal.newsapp.feature.newsdetail.ui.RealNewsDetailView;
import com.agarwal.newsapp.feature.newslisting.ui.NewsListingView;
import com.agarwal.newsapp.feature.newslisting.ui.RealNewsListingView;

/**
 * This class is responsible for handling the view implementation of activity/fragment
 * Should be called only from CompRootUi
 */
public class ViewFactory {

  private final LayoutInflater layoutInflater;

  public ViewFactory(LayoutInflater layoutInflater) {
    this.layoutInflater = layoutInflater;
  }

  /**
   * @return object of newsListingView
   */
  public NewsListingView getNewsListView() {
    return new RealNewsListingView(layoutInflater);
  }

  /**
   * @return object of newsDetailView
   */
  public NewsDetailView getNewsDetailView() {
    return new RealNewsDetailView(layoutInflater);
  }
}
