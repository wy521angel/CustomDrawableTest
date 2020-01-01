package com.example.wy521angel.customdrawable;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class ShowActivity extends AppCompatActivity {

    private ImageView imageView;

    private final static int IS_CONTUNUE = 0x22;
    private ClipDrawable clipDrawable;
    private ImageView imageView2;
    Timer timer = new Timer();

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                imageView.getDrawable().setLevel(1);
            } else if (msg.what == 2) {
                imageView.getDrawable().setLevel(2);
            } else if (msg.what == 3) {
                imageView.getDrawable().setLevel(3);
            } else if (msg.what == IS_CONTUNUE) {
                /**setlevel()设置图片截取的大小
                 * 修改ClipDrawable的level值，level值为0--10000；
                 * 10000：截取图片大小为空白，0：截取图片为整张图片；
                 */
                clipDrawable.setLevel(clipDrawable.getLevel() + 200);
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

                //通过裁剪实现图片徐徐展开
                imageView2 = (ImageView) findViewById(R.id.gemIv3);
                //获取图片所显示的ClipDrawable对象
                clipDrawable = (ClipDrawable) imageView2.getDrawable();
                //定时器
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Message msg = new Message();
                        msg.what = IS_CONTUNUE;
                        handler.sendMessage(msg);
                        if (clipDrawable.getLevel() >= 10000) {
                            timer.cancel();
                        }
                    }
                }, 0, 200);
                break;
            default:
        }
    }
}
