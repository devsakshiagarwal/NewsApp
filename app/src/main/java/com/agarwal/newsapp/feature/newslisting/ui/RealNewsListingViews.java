package com.agarwal.newsapp.feature.newslisting.ui;

import android.os.Handler;
import android.os.Looper;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.agarwal.newsapp.R;
import com.agarwal.newsapp.common.arch.BaseObservableView;
import com.agarwal.newsapp.feature.newslisting.NewsListingAdapter;
import com.agarwal.newsapp.feature.newslisting.network.Articles;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RealNewsListingViews extends BaseObservableView<NewsListingView.Listener>
    implements NewsListingView {

  private NewsListingAdapter newsListingAdapter;

  @BindView(R.id.rv_news_list)
  RecyclerView rvNewsList;

  @BindView(R.id.search_view)
  SearchView searchView;

  @BindView(R.id.search_close_btn)
  ImageView searchCloseBtn;

  @BindView(R.id.pb_news)
  ProgressBar pbNews;

  @BindView(R.id.tv_error)
  AppCompatTextView tvError;
  public static final long DELAY = 300;

  public RealNewsListingViews(LayoutInflater inflater) {
    setRootView(inflater.inflate(R.layout.activity_news_listing, null, false));
    initViews();
  }

  private void initViews() {
    setUpSearchView();
    newsListingAdapter = new NewsListingAdapter(getContext());
    rvNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
    rvNewsList.setAdapter(newsListingAdapter);
    rvNewsList.requestFocus();
  }

  private void setUpViews(List<Articles> newsList) {
    tvError.setVisibility(View.GONE);
    newsListingAdapter.setNewsList(newsList);
  }

  private void setUpSearchView() {
    searchCloseBtn.setClickable(false);
    searchView.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    searchView.setIconified(false);
    searchView.setOnQueryTextListener(
        new SearchView.OnQueryTextListener() {
          private Timer timer = new Timer();

          @Override
          public boolean onQueryTextSubmit(String query) {
            return false;
          }

          @Override
          public boolean onQueryTextChange(String newText) {
            if (newText.length() == 0) {
              searchCloseBtn.setClickable(false);
            } else {
              searchCloseBtn.setClickable(true);
            }
            timer.cancel();
            timer = new Timer();
            timer.schedule(
                new TimerTask() {
                  @Override
                  public void run() {
                    new Handler(Looper.getMainLooper()).post(
                        () -> onQueryChange(newText.trim()));
                  }
                },
                DELAY
            );
            return false;
          }
        });
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
    tvError.setVisibility(View.VISIBLE);
  }

  private void onQueryChange(String query) {
    for (Listener listener : getListeners()) {
      listener.onQueryChange(query);
    }
  }

  @Override
  public void showZeroState() {
    showError();
  }

  @Override
  public void showProgressBar() {
    pbNews.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideProgressBar() {
    pbNews.setVisibility(View.GONE);
  }
}
