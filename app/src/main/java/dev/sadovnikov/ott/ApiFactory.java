package dev.sadovnikov.ott;


import android.support.annotation.NonNull;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiFactory {

    private static final OkHttpClient CLIENT = new OkHttpClient();

    @NonNull
    public static OTTService getOTTService() {
        return getRetrofit().create(OTTService.class);
    }


    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(CLIENT)
                .build();
    }
}
