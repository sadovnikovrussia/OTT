package dev.sadovnikov.ott;

import android.database.Cursor;
import android.database.Observable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Response> {

    private static final String TAG = "MainActivity";

    public static final int MY_LOADER_ID = 11;

    List<Hotel> hotels;
    List<Flight> flights;
    List<Company> companies;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });
        //getSupportLoaderManager().initLoader(MY_LOADER_ID, Bundle.EMPTY, new MyLoaderCallbacks());
        //List<Hotel> hotels = ApiFactory.getOTTService().getHotels();
        getSupportLoaderManager().initLoader(HotelsLoader.HOTELS_LOADER_ID, Bundle.EMPTY, this);
        //getLoaderManager().initLoader(HotelsLoader.HOTELS_LOADER_ID, Bundle.EMPTY, this);
        //getLoaderManager().initLoader(HotelsLoader.HOTELS_LOADER_ID, Bundle.EMPTY, this);

    }

    @NonNull
    @Override
    public Loader<Response> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new HotelsLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Response> loader, Response response) {
        List<Hotel> hotels = response.getTypedAnswer();
        Log.i(TAG, "onLoadFinished: " + hotels);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Cursor query = getContentResolver().query(HotelsTable.URI, new String[]{"id", "name", }, null, null, null);
            if (query != null) {
                Log.d(TAG, "onLoadFinished: " + HotelsTable.listFromCursor(query));
                query.close();
            }
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Response> loader) {
        Log.d(TAG, "onLoaderReset: ");
    }


    //
//    public class MyLoaderCallbacks implements LoaderManager.LoaderCallbacks<Integer> {
//        @NonNull
//        @Override
//        public Loader<Integer> onCreateLoader(int i, @Nullable Bundle bundle) {
//            if (i == MY_LOADER_ID) {
//                return new MyLoader(MainActivity.this);
//            }
//            return null;
//        }
//
//        @Override
//        public void onLoadFinished(@NonNull Loader<Integer> loader, Integer integer) {
//            if (loader.getId() == MY_LOADER_ID) {
//                Log.d(TAG, "onLoadFinished: ");
//                Toast.makeText(MainActivity.this, R.string.load_finished, Toast.LENGTH_SHORT).show();
//            }
//
//        }
//
//        @Override
//        public void onLoaderReset(@NonNull Loader<Integer> loader) {
//
//        }
//    }
}
