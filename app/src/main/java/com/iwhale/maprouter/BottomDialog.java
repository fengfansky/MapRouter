package com.iwhale.maprouter;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.iwhale.util.MapPackageUtil;

public class BottomDialog {

    private Dialog dialog;
    private View view;
    private Context mContext;
    private TextView tvTencent, tvGaode, tvBaidu, tvTian;
    private final View viewTencent,viewGaode,viewBaidu,viewTian;

    public BottomDialog(Context context, String[] packageNames) {
        mContext = context;
        //1、使用Dialog、设置style
        dialog = new Dialog(context, R.style.DialogTheme);
        //2、设置布局
        view = View.inflate(context, R.layout.bottom_dialog, null);

        tvTencent = view.findViewById(R.id.tv_map_tencent);
        tvGaode = view.findViewById(R.id.tv_map_gaode);
        tvBaidu = view.findViewById(R.id.tv_map_baidu);
        tvTian = view.findViewById(R.id.tv_map_tian);
        viewTencent = view.findViewById(R.id.v_map_tencent);
        viewGaode = view.findViewById(R.id.v_map_gaode);
        viewBaidu = view.findViewById(R.id.v_map_baidu);
        viewTian = view.findViewById(R.id.v_map_tian);
        for (int i = 0; i < packageNames.length; i++) {
            if (MapPackageUtil.packageNames[0].equals(packageNames[i])){
                tvTencent.setVisibility(View.VISIBLE);
                viewTencent.setVisibility(View.VISIBLE);
            }else if (MapPackageUtil.packageNames[1].equals(packageNames[i])){
                tvGaode.setVisibility(View.VISIBLE);
                viewGaode.setVisibility(View.VISIBLE);
            }else if (MapPackageUtil.packageNames[2].equals(packageNames[i])){
                tvBaidu.setVisibility(View.VISIBLE);
                viewBaidu.setVisibility(View.VISIBLE);
            }else if (MapPackageUtil.packageNames[3].equals(packageNames[i])){
                tvTian.setVisibility(View.VISIBLE);
                viewTian.setVisibility(View.VISIBLE);
            }
        }
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    public void setClickListener(final OnSelectListener selectListener) {
        tvTencent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.onSelect(0, mContext.getResources().getString(R.string.map_tencent));
            }
        });
        tvGaode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.onSelect(1, mContext.getResources().getString(R.string.map_gaode));
            }
        });
        tvBaidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.onSelect(2, mContext.getResources().getString(R.string.map_baidu));
            }
        });
        tvTian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.onSelect(3, mContext.getResources().getString(R.string.map_tian));
            }
        });
    }

    public void show() {
        dialog.show();
    }

    public interface OnSelectListener {
        void onSelect(int position, String text);
    }
}
