package com.agarwal.newsapp.feature.newslisting.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NewsListSchema {

  private String status;
  private int totalResults;
  @SerializedName("articles")
  private List<Articles> articles;
  private String message;

  public String getStatus() {
    return status;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public List<Articles> getArticles() {
    return articles;
  }

  public String getMessage() {
    return message;
  }
}
