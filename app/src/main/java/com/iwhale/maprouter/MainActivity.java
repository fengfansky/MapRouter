package com.iwhale.maprouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iwhale.map.BaiduMap;
import com.iwhale.map.BaseMap;
import com.iwhale.map.GaodeMap;
import com.iwhale.map.TianMap;
import com.iwhale.util.MapPackageUtil;
import com.iwhale.map.TencentMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mapBtn;
    private BaseMap map;
    private BottomDialog bottomDialog;
    private CenterDialog centerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapBtn = findViewById(R.id.map_btn);
        mapBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String[] installedPackageNames = MapPackageUtil.getInstalledPackageName(MainActivity.this);
        if (installedPackageNames.length == 0) {
            Toast.makeText(getApplicationContext(), "您的手机未安装导航App,请先下载哦", Toast.LENGTH_SHORT)
                    .show();
        } else {
            centerDialog = new CenterDialog(MainActivity.this);
            centerDialog.show();

      /*      bottomDialog = new BottomDialog(MainActivity.this , installedPackageNames);
            bottomDialog.setClickListener(new BottomDialog.OnSelectListener() {
                @Override
                public void onSelect(int position, String text) {
                    switch (position) {
                        case 0:
                            map = new TencentMap();
                            break;
                        case 1:
                            map = new GaodeMap();
                            break;
                        case 2:
                            map = new BaiduMap();
                            break;
                        case 3:
                            map = new TianMap();
                            break;
                        default:
                            break;
                    }
                    if (map != null) {
                        map.gotoMap(MainActivity.this, 31.220567, 121.395174);
                    }
                }
            });
            bottomDialog.show();*/
        }

    }

}