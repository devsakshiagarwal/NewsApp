package com.agarwal.newsapp.common.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.NewsApp;
import com.agarwal.newsapp.common.di.CompRootUi;

public class BaseActivity extends AppCompatActivity {

  private CompRootUi compRoot;

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
