package dev.sadovnikov.ott;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OTTService {

    @GET("12q3ws.json")
    Call<Map<String, List<Hotel>>> getHotels();

    @GET("zqxvw")
    Call<List<Flight>> getFlights();

    @GET("8d024")
    Call<List<Company>> getCompanies();
}
