package com.agarwal.newsapp.common.arch;

import android.content.Context;
import android.view.View;
import butterknife.ButterKnife;

public abstract class BaseView implements ViewX {

  private View rootView;

  @Override
  public View getRootView() {
    return rootView;
  }

  protected void setRootView(View rootView) {
    this.rootView = rootView;
    ButterKnife.bind(this, rootView);
  }

  protected Context getContext() {
    return getRootView().getContext();
  }
}
