package dev.sadovnikov.ott;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCallback<Object> implements Callback<List<Hotel>> {
    private static final String TAG = "RetrofitCallback";

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Override
    public void onResponse(Call<List<Hotel>> call, Response<List<Hotel>> response) {
        Log.d(TAG, "onResponse: " + response.body());
    }

    @Override
    public void onFailure(Call<List<Hotel>> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t);
    }
}
