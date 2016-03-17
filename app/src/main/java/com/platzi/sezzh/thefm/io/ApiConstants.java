package com.platzi.sezzh.thefm.io;

/**
 * Created by sezzh on 16/03/2016.
 */
public class ApiConstants {

  public static final String URL_BASE = "http://ws.audioscrobbler.com";
  public static final String API_KEY = "f4e0bf3a10def1afb724d0f2081d0192";
  public static final String PATH_VERSION = "/2.0";
  public static final String PARAM_METHOD = "method";
  public static final String PARAM_FORMAT = "format";
  public static final String PARAM_API_KEY = "api_key";

  public static final String VALUE_TOP_ARTIST_METHOD = "chart.gettopartists";
  public static final String VALUE_JSON = "json";

  // http://ws.audioscrobbler.com/2.0/?method=chart.gettopartists&api_key=f4e0bf3a10def1afb724d0f2081d0192&format=json

  public static final String URL_TOP_ARTIST =
      PATH_VERSION + "/?" + PARAM_METHOD + "=" + VALUE_TOP_ARTIST_METHOD + "&" +
          PARAM_API_KEY + "=" + API_KEY + "&" + PARAM_FORMAT + "=" +
          VALUE_JSON;

}
