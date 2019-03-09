package com.agarwal.newsapp.feature.newslisting.network;

import java.util.List;

public class NewsListSchema {

  private String status;
  private List<Articles> articles;
  private String message;

  public String getStatus() {
    return status;
  }

  public List<Articles> getArticles() {
    return articles;
  }

  public String getMessage() {
    return message;
  }
}
