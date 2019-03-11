package com.agarwal.newsapp.feature.newslisting.ui;

import android.annotation.SuppressLint;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * View Implementation for NewsListingActivity
 * Responsible only for view rendering
 */
public class RealNewsListingView extends BaseObservableView<NewsListingView.Listener>
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
  private static final long DELAY = 300;
  private List<Articles> newsList = new ArrayList<>();

  @SuppressLint("InflateParams")
  public RealNewsListingView(LayoutInflater inflater) {
    setRootView(inflater.inflate(R.layout.activity_news_listing, null, false));
    initViews();
  }

  /**
   * initiates empty views in the activity
   */
  private void initViews() {
    setUpSearchView();
    newsListingAdapter = new NewsListingAdapter(getContext());
    rvNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
    rvNewsList.setAdapter(newsListingAdapter);
    rvNewsList.requestFocus();
  }

  /**
   * sets up views with the data
   *
   * @param newsList list for setting up the RecyclerView with the list of articles
   */
  private void setUpViews(List<Articles> newsList) {
    this.newsList = newsList;
    tvError.setVisibility(View.GONE);
    newsListingAdapter.setNewsList(newsList);
  }

  /**
   * search view in the toolbar for handling the queries
   * handles the delay of 300ms between api calls when user starts typing
   */
  private void setUpSearchView() {
    searchCloseBtn.setVisibility(View.GONE);
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
              searchCloseBtn.setVisibility(View.GONE);
            } else {
              searchCloseBtn.setVisibility(View.VISIBLE);
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
      showError(getContext().getString(R.string.no_data));
    }
  }

  /**
   * shows error in case of api failure or no internet
   *
   * @param message relevant message string
   */
  private void showError(String message) {
    if (newsList.isEmpty()) {
      tvError.setText(message);
      tvError.setVisibility(View.VISIBLE);
    }
  }

  /**
   * method get called when string in SearchView changes
   *
   * @param query searchString
   */
  private void onQueryChange(String query) {
    for (Listener listener : getListeners()) {
      listener.onQueryChange(query);
    }
  }

  @Override
  public void showZeroState(String message) {
    showError(message);
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
