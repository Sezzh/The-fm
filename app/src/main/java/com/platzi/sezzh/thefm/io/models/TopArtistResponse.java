package com.platzi.sezzh.thefm.io.models;

import com.google.gson.annotations.SerializedName;
import com.platzi.sezzh.thefm.domain.Artist;

import java.util.ArrayList;

/**
 * Created by sezzh on 16/03/2016.
 */


public class TopArtistResponse {

  @SerializedName(JsonKeys.ARTISTS_RESULTS)
  TopArtistResults results;

  public ArrayList<Artist> getArtists() {
    return this.results.artists;
  }

  private class TopArtistResults {

    @SerializedName(JsonKeys.ARTISTS_ARRAY)
    ArrayList<Artist> artists;

  }

}
