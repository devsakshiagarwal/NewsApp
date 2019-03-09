package com.agarwal.newsapp.common.arch;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableView<T> extends BaseView
    implements ObservableView<T> {

  private final Set<T> listeners = new HashSet<>();

  @Override
  public final void registerListener(T listener) {
    listeners.add(listener);
  }

  @Override
  public final void unregisterListener(T listener) {
    listeners.remove(listener);
  }

  protected final Set<T> getListeners() {
    return Collections.unmodifiableSet(listeners);
  }
}
