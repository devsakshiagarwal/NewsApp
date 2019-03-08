package com.agarwal.newsapp.feature.newsdetail;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.agarwal.newsapp.R;

public class NewsDetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_detail);
  }

  public static Intent getLaunchIntent(Context context) {
    Intent intent = new Intent();
    intent.setClass(context, NewsDetailActivity.class);
    return intent;
  }
}
