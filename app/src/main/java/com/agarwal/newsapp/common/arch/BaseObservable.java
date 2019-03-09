package com.agarwal.newsapp.common.arch;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseObservable<T> {

  private final Set<T> listeners = Collections.newSetFromMap(
      new ConcurrentHashMap<>(1));

  public final void registerListener(T listener) {
    listeners.add(listener);
  }

  public final void unregisterListener(T listener) {
    listeners.remove(listener);
  }

  protected final Set<T> getListeners() {
    return Collections.unmodifiableSet(listeners);
  }
}
