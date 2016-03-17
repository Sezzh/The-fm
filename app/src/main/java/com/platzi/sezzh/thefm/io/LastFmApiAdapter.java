package com.platzi.sezzh.thefm.io;

import retrofit.RestAdapter;

/**
 * Created by sezzh on 16/03/2016.
 * This class is a singleton which contains the http connection.
 */
public class LastFmApiAdapter {

  private static LastFmApiService API_SERVICE;

  public static LastFmApiService getApiService() {
    if (API_SERVICE == null) {
      RestAdapter adapter = new RestAdapter.Builder()
          .setEndpoint(ApiConstants.URL_BASE)
          .setLogLevel(RestAdapter.LogLevel.BASIC)
          .build();
      API_SERVICE = adapter.create(LastFmApiService.class);
    }
    return API_SERVICE;
  }

}
