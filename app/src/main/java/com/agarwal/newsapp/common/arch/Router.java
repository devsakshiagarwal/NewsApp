package com.agarwal.newsapp.common.arch;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.feature.newsdetail.NewsDetailActivity;

/**
 * This class is responsible for routing from one view to another
 * Should be called from CompRootUi only
 */
public class Router {

  private final Activity activity;

  public Router(AppCompatActivity activity) {
    this.activity = activity;
  }

  /**
   * this method routes to NewsDetailActivity
   *
   * @param bundle expects bundled values of the class this method is being called from
   */
  public void toNewsDetailActivity(Bundle bundle) {
    activity.startActivity(NewsDetailActivity.getLaunchIntent(activity, bundle));
  }
}
