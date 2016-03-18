package com.platzi.sezzh.thefm.io.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.platzi.sezzh.thefm.domain.Artist;
import com.platzi.sezzh.thefm.io.models.JsonKeys;
import com.platzi.sezzh.thefm.io.models.TopArtistResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by sezzh on 17/03/2016.
 */
public class TopArtistsDeserializer
    implements JsonDeserializer<TopArtistResponse> {

  @Override
  public TopArtistResponse deserialize(JsonElement json, Type typeOfT,
                                       JsonDeserializationContext context)
      throws JsonParseException {
    TopArtistResponse response = null;
    Gson gson = new Gson();
    response = gson.fromJson(json, TopArtistResponse.class);
    JsonObject artistResponseData = json.getAsJsonObject()
        .getAsJsonObject(JsonKeys.ARTISTS_RESULTS);
    JsonArray artistsArray = artistResponseData
        .getAsJsonArray(JsonKeys.ARTISTS_ARRAY);

    response.setArtists(this.extractArtistFromJsonArray(artistsArray));

    return response;
  }

  private ArrayList<Artist> extractArtistFromJsonArray(JsonArray jsonArray) {
    ArrayList<Artist> artists = new ArrayList<>();
    for (int i = 0; i < jsonArray.size(); i++) {
      JsonObject artistData = jsonArray.get(i).getAsJsonObject();
      Artist currentArtist = new Artist();
      String name = artistData.get(JsonKeys.ARTIST_NAME).getAsString();
      JsonArray imagesArray = artistData
          .getAsJsonArray(JsonKeys.ARTIST_IMAGES);
      ArrayList<String> images =
          this.extractArtistImagesFromJsonArray(imagesArray);
      currentArtist.setName(name);
      currentArtist.setUrlMediumImage(images.get(0));
      currentArtist.setUrlLargeImage(images.get(1));

      artists.add(currentArtist);
    }
    return artists;
  }

  private ArrayList<String> extractArtistImagesFromJsonArray
      (JsonArray imagesArray) {
    ArrayList<String> images = new ArrayList<>();
    for (int i = 0; i < imagesArray.size(); i++) {
      JsonObject imageData = imagesArray.get(i).getAsJsonObject();
      String size = imageData.get(JsonKeys.ARTIST_IMAGE_SIZE).getAsString();
      String url = imageData.get(JsonKeys.ARTIST_IMAGE_URL).getAsString();
      if (url.isEmpty()) {
        url = null;
      } else if (size.matches(JsonKeys.ARTIST_IMAGE_SIZE_MEDIUM) ||
          size.matches(JsonKeys.ARTIST_IMAGE_SIZE_LARGE)) {
        images.add(url);
      }
    }
    return images;
  }

}
