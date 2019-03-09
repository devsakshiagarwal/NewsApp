package com.agarwal.newsapp;

import android.app.Application;
import com.agarwal.newsapp.common.di.CompRoot;

public class NewsApp extends Application {

  private CompRoot compRoot;

  @Override
  public void onCreate() {
    super.onCreate();
    compRoot = new CompRoot();
  }

  public CompRoot getCompRoot() {
    return compRoot;
  }
}
