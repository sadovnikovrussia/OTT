package dev.sadovnikov.ott;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final int MY_LOADER_ID = 11;

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
        getSupportLoaderManager().initLoader(MY_LOADER_ID, Bundle.EMPTY, new MyLoaderCallbacks());
    }

    public class MyLoaderCallbacks implements LoaderManager.LoaderCallbacks<Integer> {
        @NonNull
        @Override
        public Loader<Integer> onCreateLoader(int i, @Nullable Bundle bundle) {
            if (i == MY_LOADER_ID) {
                return new MyLoader(MainActivity.this);
            }
            return null;
        }

        @Override
        public void onLoadFinished(@NonNull Loader<Integer> loader, Integer integer) {
            if (loader.getId() == MY_LOADER_ID) {
                Log.d(TAG, "onLoadFinished: ");
                Toast.makeText(MainActivity.this, R.string.load_finished, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onLoaderReset(@NonNull Loader<Integer> loader) {

        }
    }
}
