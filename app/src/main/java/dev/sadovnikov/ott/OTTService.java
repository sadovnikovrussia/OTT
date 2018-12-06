package dev.sadovnikov.ott;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OTTService {

    @GET("hotels.json")
    Call<List<Hotel>> getHotels();
}
