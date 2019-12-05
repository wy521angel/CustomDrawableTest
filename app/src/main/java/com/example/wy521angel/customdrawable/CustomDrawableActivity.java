package com.example.wy521angel.customdrawable;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CustomDrawableActivity extends AppCompatActivity {

    private static final String TAG = "MeshActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        View testCustomDrawable = findViewById(R.id.test_custom_drawable);
        CustomDrawable customDrawable = new CustomDrawable(Color.parseColor("#0ac39e"));
        testCustomDrawable.setBackgroundDrawable(customDrawable);
    }
}
