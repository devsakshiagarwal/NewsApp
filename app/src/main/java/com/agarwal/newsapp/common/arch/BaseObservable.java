package com.agarwal.newsapp.common.arch;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Observable class to be extended in all the use cases
 *
 * @param <T> Listener interface to respond back apis to the respective class
 */
public class BaseObservable<T> {

  private final Set<T> listeners = Collections.newSetFromMap(
      new ConcurrentHashMap<>(1));

  /**
   * registers the use case
   *
   * @param listener same listener interface used during extending the class
   */
  public final void registerListener(T listener) {
    listeners.add(listener);
  }

  /**
   * unregisters the use case
   *
   * @param listener same listener interface used during extending the class
   */
  public final void unregisterListener(T listener) {
    listeners.remove(listener);
  }

  /**
   * @return all the registered listeners at a particular time
   */
  protected final Set<T> getListeners() {
    return Collections.unmodifiableSet(listeners);
  }
}
