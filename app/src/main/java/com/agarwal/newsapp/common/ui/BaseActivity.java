package com.agarwal.newsapp.common.ui;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.NewsApp;
import com.agarwal.newsapp.common.di.CompRootUi;

/**
 * Base Activity to be called from every activity.
 * Should have methods which are supposed to be called across activities
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

  private CompRootUi compRoot;

  /**
   * @return CompRootUi that contains all the app level method
   */
  protected CompRootUi getCompositionRoot() {
    if (compRoot == null) {
      compRoot = new CompRootUi(
          ((NewsApp) getApplication()).getCompRoot(),
          this
      );
    }
    return compRoot;
  }
}
