package com.iwhale.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MapPackageUtil {

    public static String[] packageNames = {"com.baidu.BaiduMap", "com.autonavi.minimap", "com.tencent.map", ""};
    public static List<String> installedPackageNames = new ArrayList<>();


    /**
     * 获取议案张的地图应用包名
     * @param context
     * @return
     */
    public static String[] getInstalledPackageName(Context context){
        for (String packageName : packageNames) {
            if (isInstalled(context, packageName)){
                installedPackageNames.add(packageName);
            }
        }
        return  installedPackageNames.toArray(new String[installedPackageNames.size()]);
    }

    /**
     * 检测程序是否安装
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }
}
