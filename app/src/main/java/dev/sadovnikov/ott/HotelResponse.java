package dev.sadovnikov.ott;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;


public class HotelResponse extends Response {

    @Override
    public void save(@NonNull Context context) {
        List<Hotel> hotels = getTypedAnswer();
        if (hotels != null) {
            HotelsTable.save(context, hotels);
        }
    }

}
