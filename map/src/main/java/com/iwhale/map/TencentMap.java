package com.iwhale.map;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

public class TencentMap extends BaseMap {

    @Override
    public void gotoMap(Activity context, LatLng endPosition) {
//        LatLng startPoint = BD2GCJ(new LatLng(32.220567, 122.395174));//坐标转换
        StringBuffer sb = new StringBuffer("qqmap://map/routeplan")
                .append("?type=drive")
                .append("&from=我的位置")
                .append("&fromcoord=")
//                .append(startPoint.latitude).append(",").append(startPoint.longitude)
//                .append("&to=杭州东站")
                .append("&tocoord=").append(endPosition.latitude).append(",").append(endPosition.longitude)
                .append("&referer=你的key");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(sb.toString()));
        context.startActivity(intent);
    }


    @Override
    public int index() {
        return 0;
    }

    @Override
    public String getAppName() {
        return "腾讯地图";
    }

    @Override
    public String getPackageName() {
        return "com.tencent.map";
    }
}
