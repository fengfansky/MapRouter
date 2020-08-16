package com.iwhale.map;

import android.app.Activity;

import com.google.android.gms.maps.model.LatLng;

public class TianMap extends BaseMap {
    @Override
    public void gotoMap(Activity context, LatLng endPosition) {

    }

    @Override
    public int index() {
        return 0;
    }

    @Override
    public String getAppName() {
        return null;
    }

    @Override
    public String getPackageName() {
        return null;
    }
}
