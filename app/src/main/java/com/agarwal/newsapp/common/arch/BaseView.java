package com.agarwal.newsapp.common.arch;

import android.content.Context;
import android.view.View;
import butterknife.ButterKnife;

/**
 * this class should be extended in BaseObservableView to handle the views related to different
 * screens
 */
public abstract class BaseView implements ViewX {

  private View rootView;

  @Override
  public View getRootView() {
    return rootView;
  }

  /**
   * set the view of a particular screen during the implementation of the view
   *
   * @param rootView view of the screen
   */
  protected void setRootView(View rootView) {
    this.rootView = rootView;
    ButterKnife.bind(this, rootView);
  }

  /**
   * @return context
   */
  protected Context getContext() {
    return getRootView().getContext();
  }
}
