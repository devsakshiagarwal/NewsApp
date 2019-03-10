package com.agarwal.newsapp.feature.newslisting.network;

import java.util.List;

/**
 * Schema that receives the values from NewsListingAPi
 */
public class NewsListSchema {

  private String status;
  private List<Articles> articles;
  private String message;

  public NewsListSchema(String status,
      List<Articles> articles, String message) {
    this.status = status;
    this.articles = articles;
    this.message = message;
  }

  /**
   * @return ok/error for success/response
   */
  public String getStatus() {
    return status;
  }

  /**
   * @return listo of articles(news)
   */
  public List<Articles> getArticles() {
    return articles;
  }

  /**
   * @return success/failure response message
   */
  public String getMessage() {
    return message;
  }
}
