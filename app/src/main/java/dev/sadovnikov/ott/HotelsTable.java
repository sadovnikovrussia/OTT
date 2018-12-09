package dev.sadovnikov.ott;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class HotelsTable {

    public static final Uri URI = SQLiteHelper.BASE_CONTENT_URI.buildUpon().appendPath(Requests.TABLE_NAME).build();

    public static void save(Context context, @NonNull Hotel hotel) {
        context.getContentResolver().insert(URI, toContentValues(hotel));
    }

    public static void save(Context context, @NonNull List<Hotel> hotels) {
        ContentValues[] values = new ContentValues[hotels.size()];
        for (int i = 0; i < hotels.size(); i++) {
            values[i] = toContentValues(hotels.get(i));
        }
        context.getContentResolver().bulkInsert(URI, values);
    }

    @NonNull
    public static ContentValues toContentValues(@NonNull Hotel hotel) {
        ContentValues values = new ContentValues();
        values.put(Columns.ID, hotel.getId());
        values.put(Columns.FLIGHTS_IDS, hotel.getFlightsIds().get(0));
        values.put(Columns.NAME, hotel.getName());
        values.put(Columns.PRICE, hotel.getPrice());
        return values;
    }

    @NonNull
    public static Hotel fromCursor(@NonNull Cursor cursor) {
        String code = cursor.getString(cursor.getColumnIndex(Columns.ID));
        String flightsIds = cursor.getString(cursor.getColumnIndex(Columns.FLIGHTS_IDS));
        String name = cursor.getString(cursor.getColumnIndex(Columns.NAME));
        String price = cursor.getString(cursor.getColumnIndex(Columns.PRICE));
        ArrayList<Long> flightsIds1 = new ArrayList<>();
        flightsIds1.add(Long.valueOf(1));
        return new Hotel(Long.valueOf(code), flightsIds1, name, Long.valueOf(price));
    }

    @NonNull
    public static List<Hotel> listFromCursor(@NonNull Cursor cursor) {
        List<Hotel> hotels = new ArrayList<>();
        if (!cursor.moveToFirst()) {
            return hotels;
        }
        try {
            do {
                hotels.add(fromCursor(cursor));
            } while (cursor.moveToNext());
            return hotels;
        } finally {
            cursor.close();
        }
    }

    public static void clear(Context context) {
        context.getContentResolver().delete(URI, null, null);
    }

    public interface Columns {
        String ID = "id";
        String FLIGHTS_IDS = "flights";
        String NAME = "name";
        String PRICE = "price";

    }

    public interface Requests {

        String TABLE_NAME = HotelsTable.class.getSimpleName();

        String CREATION_REQUEST = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                Columns.ID + " NOT NULL, " +
                Columns.FLIGHTS_IDS + " NOT NULL, " +
                Columns.NAME + " NOT NULL, " +
                Columns.PRICE + " NOT NULL" +
                ");";

        String DROP_REQUEST = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
