package com.agarwal.newsapp.feature.newslisting.network;

import com.google.gson.annotations.SerializedName;

public class Articles {

  private String author;
  private String title;
  private String description;
  private String url;
  private String urlToImage;
  private String publishedAt;
  private String content;
  @SerializedName("source")
  private Source source;

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getUrl() {
    return url;
  }

  public String getUrlToImage() {
    return urlToImage;
  }

  public String getPublishedAt() {
    return publishedAt;
  }

  public String getContent() {
    return content;
  }

  public Source getSource() {
    return source;
  }

  public static class Source {
    private String id;
    private String name;

    public String getId() {
      return id;
    }

    public String getName() {
      return name;
    }
  }
}