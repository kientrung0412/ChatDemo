package com.hanabi.thithu.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hanabi.thithu.R;

public class ChatView extends LinearLayout {

    public static int MESS_MY = 1;
    public static int MESS_YOUR = 0;

    private TextView tvContent;

    public ChatView(Context context) {
        super(context);
        initViews(context);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    public ChatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews(context);
    }

    public ChatView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews(context);
    }

    private void initViews(Context context) {
        inflate(context, R.layout.message_view, this);

        final int width = context.getResources().getDisplayMetrics().widthPixels;

        tvContent = findViewById(R.id.tv_content);
        tvContent.setMaxWidth(width / 3 * 2);
    }

    public void setText(String text) {
        tvContent.setText(text);
    }

    public void setStyle(int id) {
        switch (id) {
            case 1:
                tvContent.setBackgroundResource(R.drawable.bg_mess_my);
                tvContent.setTextColor(Color.WHITE);
                break;
            case 0:
                tvContent.setBackgroundResource(R.drawable.bg_mess_your);
                tvContent.setTextColor(Color.BLACK);
                break;
        }
    }

}
