package com.agarwal.newsapp.feature.newsdetail.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.agarwal.newsapp.R;
import com.agarwal.newsapp.common.arch.BaseObservableView;

public class RealNewsDetailView extends BaseObservableView<NewsDetailView.Listener>
    implements NewsDetailView {

  @BindView(R.id.pb_news_detail) ProgressBar pbNewsDetail;
  @BindView(R.id.wv_news_detail) WebView wvNewsDetail;

  @SuppressLint("InflateParams")
  public RealNewsDetailView(LayoutInflater inflater) {
    setRootView(inflater.inflate(R.layout.activity_news_detail, null, false));
    pbNewsDetail.setVisibility(View.VISIBLE);
  }

  private void setUpViews(String url) {
    wvNewsDetail.loadUrl(url);
    wvNewsDetail.setWebViewClient(new WebViewClient() {
      @Override public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        pbNewsDetail.setVisibility(View.GONE);
      }
    });
  }

  @Override
  public void bindNewsDetail(String url) {
    setUpViews(url);
  }
}
