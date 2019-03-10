package com.agarwal.newsapp.common.di;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import com.agarwal.newsapp.common.arch.Router;
import com.agarwal.newsapp.common.arch.ViewFactory;
import com.agarwal.newsapp.common.connectivity.ConnectivityDetector;
import com.agarwal.newsapp.feature.newslisting.NewsListUseCase;
import com.agarwal.newsapp.feature.newslisting.network.NewsListingApi;

/**
 * Responsible for returning instances of object required in classes throughout the application
 * Object should be created in BaseActivity/BaseFragment and then should be accessed
 */
public class CompRootUi {

  private final CompRoot compRoot;
  private final AppCompatActivity activity;

  public CompRootUi(CompRoot compositionRoot, AppCompatActivity activity) {
    compRoot = compositionRoot;
    this.activity = activity;
  }

  /**
   * @return activity
   */
  private AppCompatActivity getActivity() {
    return activity;
  }

  /**
   * @return context
   */
  private Context getContext() {
    return activity;
  }

  /**
   * call this method to route from one view to another
   *
   * @return object of router
   */
  public Router getRouter() {
    return new Router(getActivity());
  }

  /**
   * call this method to get to work with the internet connection
   *
   * @return object of ConnectivityDetector
   */
  public ConnectivityDetector getConnectivityDetector() {
    return new ConnectivityDetector(activity);
  }

  /**
   * Call this method to get the Views in the Activity/Fragment
   *
   * @return object of viewFactory
   */
  public ViewFactory getViewFactory() {
    return new ViewFactory(LayoutInflater.from(getContext()));
  }

  /**
   * @return NewsListingApi object that contains api call for News Listing
   */
  private NewsListingApi getNewsListingApi() {
    return compRoot.getNewsListingApi();
  }

  /**
   * UseCase that handles NewsList api call and response
   *
   * @return obhect of NewsListUseCase
   */
  public NewsListUseCase getNewsListUseCase() {
    return new NewsListUseCase(getNewsListingApi());
  }
}
