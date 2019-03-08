package com.agarwal.newsapp.feature.newslisting;

import android.os.Bundle;
import com.agarwal.newsapp.R;
import com.agarwal.newsapp.common.ui.BaseActivity;
import com.agarwal.newsapp.feature.newslisting.network.NewsListSchema;
import java.util.List;

public class NewsListingActivity extends BaseActivity implements NewsListUseCase.Listener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_listing);
  }

  @Override public void onSuccess(List<NewsListSchema.Articles> newsArticles) {

  }

  @Override public void onFail(String message) {

  }
}
