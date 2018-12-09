package dev.sadovnikov.ott;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

import static dev.sadovnikov.ott.RequestResult.SUCCESS;

public class HotelsLoader extends BaseLoader {

    private static final String TAG = "HotelsLoader";

    public static final int HOTELS_LOADER_ID = 1;

    HotelsLoader(@NonNull Context context) {
        super(context);
        Log.d(TAG, "HotelsLoader: ");
    }

    @Override
    protected void onStartLoading() {
        Log.d(TAG, "onStartLoading: ");
        forceLoad();
    }

    @Override
    public void forceLoad() {
        Log.d(TAG, "forceLoad: ");
        super.forceLoad();
    }

    @Override
    protected dev.sadovnikov.ott.Response apiCall() throws IOException {
        Log.d(TAG, "apiCall: ");
        OTTService service = ApiFactory.getOTTService();
        Call<Map<String, List<Hotel>>> call = service.getHotels();
        List<Hotel> hotels = call.execute().body().get("hotels");
        return new HotelResponse().setRequestResult(SUCCESS).setAnswer(hotels);
    }
}
