package com.platzi.sezzh.thefm.io;

import com.platzi.sezzh.thefm.io.models.TopArtistResponse;

import retrofit.Callback;
import retrofit.http.GET;


/**
 * Created by sezzh on 16/03/2016.
 */
public interface LastFmApiService {

  @GET(ApiConstants.URL_TOP_ARTIST)
  void getTopArtists(Callback<TopArtistResponse> serverResponse);

}
