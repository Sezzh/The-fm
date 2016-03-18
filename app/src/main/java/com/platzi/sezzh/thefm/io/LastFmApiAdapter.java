package com.platzi.sezzh.thefm.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.platzi.sezzh.thefm.io.deserializers.TopArtistsDeserializer;
import com.platzi.sezzh.thefm.io.models.TopArtistResponse;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

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
          .setConverter(buildLastFmApiGsonConverter())
          .build();
      API_SERVICE = adapter.create(LastFmApiService.class);
    }
    return API_SERVICE;
  }

  private static GsonConverter buildLastFmApiGsonConverter() {
    Gson gsonConf = new GsonBuilder()
        .registerTypeAdapter(
            TopArtistResponse.class, new TopArtistsDeserializer()
        ).create();

    return new GsonConverter(gsonConf);
  }

}
