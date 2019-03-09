package com.agarwal.newsapp.feature.newslisting;

import android.os.Bundle;
import com.agarwal.newsapp.common.ui.BaseActivity;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import com.agarwal.newsapp.feature.newslisting.ui.NewsListingView;
import java.util.List;

public class NewsListingActivity extends BaseActivity
    implements NewsListUseCase.Listener, NewsListingView.Listener {

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
  }

  @Override protected void onResume() {
    super.onResume();
    newsListUseCase.fetchEverything(query);
    newsListingView.showProgressBar();
  }

  @Override public void onSuccess(List<Articles> newsArticles) {
    newsListingView.hideProgressBar();
    newsListingView.bindNewsList(newsArticles);
  }

  @Override public void onFail(String message) {
    newsListingView.hideProgressBar();
    newsListingView.showZeroState();
  }

  @Override protected void onStop() {
    super.onStop();
    newsListingView.unregisterListener(this);
    newsListUseCase.unregisterListener(this);
  }
}
