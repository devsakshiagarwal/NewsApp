package com.agarwal.newsapp.common.arch;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.feature.newsdetail.NewsDetailActivity;

public class Router {

  private final Activity activity;

  public Router(AppCompatActivity activity) {
    this.activity = activity;
  }

  public void toNewsDetailActivity() {
    activity.startActivity(  NewsDetailActivity.getLaunchIntent(activity));
  }
}
