package com.agarwal.newsapp.feature.newsdetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.agarwal.newsapp.common.ui.BaseActivity;
import com.agarwal.newsapp.common.util.AppConstants;
import com.agarwal.newsapp.feature.newsdetail.ui.NewsDetailView;

/**
 * Activity that is responsible for rendering the whole news into a WebView
 */
public class NewsDetailActivity extends BaseActivity
    implements NewsDetailView.Listener {

  private NewsDetailView newsDetailView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    newsDetailView = getCompositionRoot().getViewFactory().getNewsDetailView();
    setContentView(newsDetailView.getRootView());
  }

  @Override protected void onStart() {
    super.onStart();
    newsDetailView.registerListener(this);
    newsDetailView.bindNewsDetail(getIntent().getStringExtra(AppConstants.PARAM_URL));
  }

  @Override protected void onStop() {
    super.onStop();
    newsDetailView.unregisterListener(this);
  }

  /**
   * launchIntent to launch NewsDetailActivity. Should be called only from router
   *
   * @param activity expects activity context where it is being called from
   * @param bundle arguments that NewsDetailActivity expects: news url for now
   * @return intent for starting NewsDetailActivity
   */
  public static Intent getLaunchIntent(Activity activity, @Nullable Bundle bundle) {
    Intent intent = new Intent();
    intent.setClass(activity, NewsDetailActivity.class);
    if (bundle != null) {
      intent.putExtras(bundle);
    }
    return intent;
  }
}
