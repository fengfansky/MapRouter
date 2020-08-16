package com.iwhale.map;

import android.app.Activity;

import com.google.android.gms.maps.model.LatLng;

public abstract class BaseMap {

    public abstract void gotoMap(Activity context, LatLng endPosition);

    public void gotoMap(Activity context, double latitude, double longitude) {
        LatLng endPoint = BD2GCJ(new LatLng(latitude, longitude));//坐标转换
        gotoMap(context, endPoint);
    }

    public abstract int index();

    public abstract String getAppName();

    public abstract String getPackageName();

    /**
     * BD-09 坐标转换成 GCJ-02 坐标
     */
    public LatLng BD2GCJ(LatLng bd) {
        double x = bd.longitude - 0.0065, y = bd.latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);
        double lng = z * Math.cos(theta);
        double lat = z * Math.sin(theta);
        return new LatLng(lat, lng);
    }

    /**
     * GCJ-02 坐标转换成 BD-09 坐标
     */
    public LatLng GCJ2BD(LatLng bd) {
        double x = bd.longitude, y = bd.latitude;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        return new LatLng(tempLat, tempLon);
    }


}
