package com.agarwal.newsapp.feature.newslisting.network;

/**
 * Object that contains values related to a single news
 * part of NewsListSchema
 */
public class Articles {

  private String author;
  private String title;
  private String description;
  private String url;
  private String urlToImage;

  public Articles(String author, String title, String description, String url,
      String urlToImage) {
    this.author = author;
    this.title = title;
    this.description = description;
    this.url = url;
    this.urlToImage = urlToImage;
  }

  /**
   * @return author name of the news
   */
  public String getAuthor() {
    return author;
  }

  /**
   * @return heading of the news
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return description of the news
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return url for the image to load
   */
  public String getUrl() {
    return url;
  }

  /**
   * @return url for the whole article
   */
  public String getUrlToImage() {
    return urlToImage;
  }
}
