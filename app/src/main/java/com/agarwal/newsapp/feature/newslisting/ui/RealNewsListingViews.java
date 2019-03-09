package com.agarwal.newsapp.feature.newslisting.ui;

import android.view.LayoutInflater;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.agarwal.newsapp.R;
import com.agarwal.newsapp.common.arch.BaseObservableView;
import com.agarwal.newsapp.feature.newslisting.NewsListingAdapter;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import java.util.List;

public class RealNewsListingViews extends BaseObservableView<NewsListingView.Listener>
    implements NewsListingView {

  private NewsListingAdapter newsListingAdapter;

  @BindView(R.id.rv_news_list)
  RecyclerView rvNewsList;

  public RealNewsListingViews(LayoutInflater inflater) {
    setRootView(inflater.inflate(R.layout.activity_news_listing, null, false));
    initViews();
  }

  private void initViews() {
    newsListingAdapter = new NewsListingAdapter(getContext());
    rvNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
    rvNewsList.setAdapter(newsListingAdapter);
  }

  private void setUpViews(List<Articles> newsList) {
    newsListingAdapter.setNewsList(newsList);
  }

  @Override
  public void bindNewsList(List<Articles> newsList) {
    if (newsList != null && !newsList.isEmpty()) {
      setUpViews(newsList);
    } else {
      showError();
    }
  }

  private void showError() {

  }

  @Override
  public void showZeroState() {
    showError();
  }

  @Override
  public void showProgressBar() {

  }

  @Override
  public void hideProgressBar() {

  }
}
