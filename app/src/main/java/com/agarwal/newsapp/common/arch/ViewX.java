package com.agarwal.newsapp.common.arch;

import android.view.View;

/**
 * this interface should be implemented where RootView for a particular activity/class is required
 * Called from BaseView for now as BaseView handles the view
 */
public interface ViewX {
  View getRootView();
}
