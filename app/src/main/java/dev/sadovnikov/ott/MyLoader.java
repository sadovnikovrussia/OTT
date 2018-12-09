package dev.sadovnikov.ott;

import android.content.Context;
import android.database.Cursor;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.util.Log;

public class MyLoader extends Loader<Cursor> {

    private static final String TAG = "MyLoader";
    
    public MyLoader(@NonNull Context context) {
        super(context);
        Log.d(TAG, "MyLoader: OnConstructor");
    }

    @Override
    protected void onStartLoading() {
        Log.d(TAG, "onStartLoading: ");
        super.onStartLoading();
        forceLoad();
    }


}
