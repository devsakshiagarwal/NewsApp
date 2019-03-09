package com.agarwal.newsapp.feature.newslisting;

import android.os.Bundle;
import com.agarwal.newsapp.R;
import com.agarwal.newsapp.common.ui.BaseActivity;
import com.agarwal.newsapp.common.util.AppConstants;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import com.agarwal.newsapp.feature.newslisting.ui.NewsListingView;
import java.util.List;

public class NewsListingActivity extends BaseActivity
    implements NewsListUseCase.Listener, NewsListingView.Listener,
    NewsListingAdapter.NewsListingInteraction {

  private NewsListUseCase newsListUseCase;
  private NewsListingView newsListingView;
  private String query = "Majid Al Futtaim";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    newsListingView = getCompositionRoot().getViewFactory().getNewsListView();
    newsListUseCase = getCompositionRoot().getNewsListUseCase();
    setContentView(newsListingView.getRootView());
  }

  @Override protected void onStart() {
    super.onStart();
    newsListingView.registerListener(this);
    newsListUseCase.registerListener(this);
    newsListingView.showProgressBar();
    makeApiCall();
  }

  @Override public void onSuccess(List<Articles> newsArticles) {
    newsListingView.hideProgressBar();
    newsListingView.bindNewsList(newsArticles);
  }

  @Override public void onFail(String message) {
    newsListingView.hideProgressBar();
    newsListingView.showZeroState(message);
  }

  @Override protected void onStop() {
    super.onStop();
    newsListingView.unregisterListener(this);
    newsListUseCase.unregisterListener(this);
  }

  @Override public void onQueryChange(String query) {
    this.query = query;
    makeApiCall();
  }

  @Override public void onClick(String url) {
    Bundle bundle = new Bundle();
    bundle.putString(AppConstants.PARAM_URL, url);
    getCompositionRoot().getRouter().toNewsDetailActivity(bundle);
  }

  void makeApiCall() {
    if (getCompositionRoot().getConnectivityDetector().isConnected()) {
      newsListUseCase.fetchEverything(query);
    } else {
      onFail(getString(R.string.no_internet));
    }
  }
}
