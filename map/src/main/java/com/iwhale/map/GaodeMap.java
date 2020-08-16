package com.iwhale.map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

public class GaodeMap extends BaseMap {

    @Override
    public void gotoMap(Activity context, LatLng endPosition) {
        StringBuffer sb = new StringBuffer("androidamap://navi")
                .append("?sourceApplication=").append("hello")
                .append("&lat=").append(endPosition.latitude)
                .append("&lon=").append(endPosition.longitude)
                .append("&dev=0");
        Intent intent = new Intent();
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.autonavi.minimap");
        intent.setData(Uri.parse(sb.toString()));
        context.startActivity(intent);
    }

    @Override
    public int index() {
        return 1;
    }

    @Override
    public String getAppName() {
        return "高德地图";
    }

    @Override
    public String getPackageName() {
        return "com.autonavi.minimap";
    }


}
