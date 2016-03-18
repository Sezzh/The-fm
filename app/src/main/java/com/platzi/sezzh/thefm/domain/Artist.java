package com.platzi.sezzh.thefm.domain;

import com.google.gson.annotations.SerializedName;
import com.platzi.sezzh.thefm.io.models.JsonKeys;

/**
 * Created by sezzh on 08/03/2016.
 */
public class Artist {

  @SerializedName(JsonKeys.ARTIST_NAME)
  private String name;

  private String urlMediumImage;
  private String urlLargeImage;

  public Artist() {

  }

  public Artist(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrlMediumImage() {
    return urlMediumImage;
  }

  public void setUrlMediumImage(String urlMediumImage) {
    this.urlMediumImage = urlMediumImage;
  }

  public String getUrlLargeImage() {
    return urlLargeImage;
  }

  public void setUrlLargeImage(String urlLargeImage) {
    this.urlLargeImage = urlLargeImage;
  }
}
