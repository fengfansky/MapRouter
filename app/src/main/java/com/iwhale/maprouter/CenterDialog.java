package com.iwhale.maprouter;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.iwhale.util.MapPackageUtil;

public class CenterDialog {

    private Dialog dialog;
    private View view;
    private Context mContext;
    TextView tvTitle,tvTip, btnNegative, btnOK;

    public CenterDialog(Context context) {
        mContext = context;
        //1、使用Dialog、设置style
        dialog = new Dialog(context, R.style.DialogTheme);
        //2、设置布局
        view = View.inflate(context, R.layout.dialog_select_ios, null);
        tvTitle = view.findViewById(R.id.txt_dialog_title);
        tvTip = view.findViewById(R.id.txt_dialog_tip);
        btnNegative = view.findViewById(R.id.btn_selectNegative);
        btnOK = view.findViewById(R.id.btn_selectPositive);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.CENTER);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
