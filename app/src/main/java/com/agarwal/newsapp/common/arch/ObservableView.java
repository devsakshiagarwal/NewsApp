package com.agarwal.newsapp.common.arch;

/**
 * this interface should be implemented in BaseObservableView in order to register or unregister the
 * views from the activity/fragment
 */
public interface ObservableView<T> extends ViewX {

  /**
   * registers the view to the activity/fragment
   *
   * @param listener expect the same interface T used to implement this interface
   */
  void registerListener(T listener);

  /**
   * unregisters the view from the activity/fragment
   *
   * @param listener expect the same interface T used to implement this interface
   */
  void unregisterListener(T listener);
}
