package com.agarwal.newsapp.common.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;

public final class ConnectivityDetector {

  private Context context;

  public ConnectivityDetector(Context context) {
    this.context = context;
  }

  public boolean isConnected() {
    ConnectivityManager cm =
        (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    return cm.getActiveNetworkInfo() != null;
  }
}
