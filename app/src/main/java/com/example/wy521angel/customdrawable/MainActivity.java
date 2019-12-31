package com.example.wy521angel.customdrawable;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.test_size);
        Drawable drawable = textView.getBackground();
        Log.e(TAG, "bg:" + drawable + "w:" + drawable.getIntrinsicWidth()
                + " h:" + drawable.getIntrinsicHeight());

        findViewById(R.id.ringProgressBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShowActivity.class).putExtra("flag",
                        1));
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // test transition
            View v = findViewById(R.id.test_transition);
            TransitionDrawable drawable = (TransitionDrawable) v.getBackground();
            drawable.startTransition(1000);

            // test scale
            View testScale = findViewById(R.id.test_scale);
            ScaleDrawable testScaleDrawable = (ScaleDrawable) testScale.getBackground();
            testScaleDrawable.setLevel(10);

            // test clip
            ImageView testClip = (ImageView) findViewById(R.id.test_clip);
            ClipDrawable testClipDrawable = (ClipDrawable) testClip.getDrawable();
            testClipDrawable.setLevel(8000);

            // test custom drawable
            View testCustomDrawable = findViewById(R.id.test_custom_drawable);
            CustomDrawable customDrawable = new CustomDrawable(Color.parseColor("#0ac39e"));
            testCustomDrawable.setBackgroundDrawable(customDrawable);
            testCustomDrawable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, CustomDrawableActivity.class));
                }
            });

            View testCustomMeshDrawable = findViewById(R.id.test_custom_mesh_drawable);
            MeshDrawable meshDrawable = new MeshDrawable();
            testCustomMeshDrawable.setBackgroundDrawable(meshDrawable);
            testCustomMeshDrawable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, MeshActivity.class));
                }
            });
        }
    }
}
