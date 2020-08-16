package com.iwhale.map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.logging.Logger;

public class BaiduMap extends BaseMap {

    @Override
    public void gotoMap(Activity context, LatLng endPosition) {
        //baidumap://map/navi?query=故宫&src=andr.baidu.openAPIdemo&viaPoints={"viaPoints":[{"name":"对外外贸大学","lng":116,"lat":40}]}
        // 驾车导航
        StringBuffer sb = new StringBuffer("baidumap://map/navi")
                .append("?coord_type=gcj02")
//                .append("&query=").append("杭州东站")
                .append("&location=").append(endPosition.latitude)
                .append(",").append(endPosition.longitude)
                .append("&src=").append(context.getPackageName());
//                .append("&viaPoints={\"viaPoints\":[{\"name\":\"").append("杭州东站").append("\",")
//                .append("\"lng\":").append(endPosition.latitude).append(",")
//                .append("\"lat\":").append(endPosition.longitude).append("}]}");
        Log.d("BaiduMap", " sb : " + sb);
        Intent intent = new Intent();
        intent.setData(Uri.parse(sb.toString()));
        context.startActivity(intent);
    }

    @Override
    public int index() {
        return 1;
    }

    @Override
    public String getAppName() {
        return "百度地图";
    }

    @Override
    public String getPackageName() {
        return "com.baidu.BaiduMap";
    }
}
