package com.agarwal.newsapp.common.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * responsible for detecting the connectivity of the internet
 */
public final class ConnectivityDetector {

  private Context context;

  public ConnectivityDetector(Context context) {
    this.context = context;
  }

  /**
   * @return true if there is internet connection, false if not
   */
  public boolean isConnected() {
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    return cm.getActiveNetworkInfo() != null;
  }
}
