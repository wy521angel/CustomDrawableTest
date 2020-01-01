package com.example.wy521angel.customdrawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class ShowActivity extends AppCompatActivity {

    private static ImageView imageView;

    @SuppressLint("HandlerLeak")
    private static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                imageView.getDrawable().setLevel(1);
            } else if (msg.what == 2) {
                imageView.getDrawable().setLevel(2);
            } else if (msg.what == 3) {
                imageView.getDrawable().setLevel(3);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (getIntent().getIntExtra("flag", 0)) {
            case 1:
                setContentView(R.layout.activity_ring_progress);
                break;
            case 2:
                setContentView(R.layout.activity_show);
                //实现图片切换
                imageView = (ImageView) findViewById(R.id.gemIv);
                imageView.setImageResource(R.drawable.list_drawable);
                imageView.setImageLevel(0);
                for (int i = 1; i < 4; i++) {
                    handler.sendEmptyMessageDelayed(i, i * 2000);
                }

                //实现图片渐变
                View view = findViewById(R.id.gemIv2);
                TransitionDrawable drawable = (TransitionDrawable) view.getBackground();
                drawable.startTransition(4000);
                break;
            default:
        }
    }
}
